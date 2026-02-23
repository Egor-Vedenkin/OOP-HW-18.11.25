package org.skypro.skyshop.product;

public abstract class Product {
    protected String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial(); // Метод проверки спецтовара
}