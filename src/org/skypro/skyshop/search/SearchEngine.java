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
}