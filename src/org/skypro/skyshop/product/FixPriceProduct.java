package org.skypro.skyshop.product;

public class FixPriceProduct {

    private String title;
    public static final int FIXED_PRICE = 10000;

    public FixPriceProduct(String title) {
        this.title = title;
    }

    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
