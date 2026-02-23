package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String title, int price) {
        super(title);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() { // Простой продукт
        return false;
    }

    @Override
    public String toString() {
        return getTitle() + ": " + price;
    }
}
