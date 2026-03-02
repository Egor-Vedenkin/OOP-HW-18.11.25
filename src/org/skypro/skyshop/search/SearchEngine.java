package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] items;

    public SearchEngine(int size) {
        items = new Searchable[size];
    }

    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    public Searchable[] search(String keyword) {
        Searchable[] results = new Searchable[5]; // Максимум 5 результатов
        int count = 0;
        for (Searchable s : items) {
            if (s != null && s.getSearchTerm().contains(keyword)) {
                results[count++] = s;
                if (count >= 5) break;
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