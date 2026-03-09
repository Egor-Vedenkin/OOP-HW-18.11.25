package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search(String keyword) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable s : items) {
            if (s != null && s.getSearchTerm().contains(keyword)) {
                results.add(s);
            }
        }
        return results;
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
}