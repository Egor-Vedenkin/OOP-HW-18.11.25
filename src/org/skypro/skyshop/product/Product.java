package org.skypro.skyshop.product;

public abstract class Product {
    private String title;

    public String toString() {
        return this.title;
    }

    public Product(String title, int price) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

}
