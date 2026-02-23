package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    protected final String title;

    public Product(String title) {
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