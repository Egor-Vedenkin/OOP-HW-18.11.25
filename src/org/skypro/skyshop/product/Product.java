package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String title;

    public Product(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название товара не может быть пустым или null");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}