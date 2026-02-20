package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String title, int price) {
        super(title, price);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

}
