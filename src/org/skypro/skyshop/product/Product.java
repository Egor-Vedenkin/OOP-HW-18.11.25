package org.skypro.skyshop.product;

public class Product {
    private String title;
    private int price;

    public String toString() {
        return this.title + " " + this.price + " руб";
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

}
