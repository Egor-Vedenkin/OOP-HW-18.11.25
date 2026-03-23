package org.skypro.skyshop.search;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item); // HashSet не допускает дубликатов, если equals/hashCode реализованы по имени
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxMatches = -1;

        for (Searchable s : items) {
            if (s != null) {
                int matches = countOccurrences(s.getSearchTerm(), search);
                if (matches > maxMatches) {
                    maxMatches = matches;
                    bestMatch = s;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Нет подходящего результата для '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String search) {
        int lastIndex = 0;
        int count = 0;
        while ((lastIndex = str.indexOf(search, lastIndex)) != -1) {
            count++;
            lastIndex += search.length();
        }
        return count;
    }

    // Возвращает отсортированный Set по длине имени (убыв.), затем по алфавиту (возр.)
    public Set<Searchable> search(String keyword) {
        Comparator<Searchable> comparator = Comparator.comparingInt((Searchable s) -> -s.getName().length())
                .thenComparing(Searchable::getName);

        TreeSet<Searchable> resultSet = items.stream()
                .filter(s -> s != null && s.getSearchTerm().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));

        return resultSet;
    }
}