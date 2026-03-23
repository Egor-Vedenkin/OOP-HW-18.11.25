package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        return items.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(s -> countOccurrences(s.getSearchTerm(), search)))
                .orElseThrow(() -> new BestResultNotFound("Нет подходящего результата для '" + search + "'"));
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

    public Set<Searchable> search(String keyword) {
        Comparator<Searchable> comparator = Comparator.comparingInt((Searchable s) -> -s.getName().length())
                .thenComparing(Searchable::getName);

        return items.stream()
                .filter(s -> s != null && s.getSearchTerm().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}
