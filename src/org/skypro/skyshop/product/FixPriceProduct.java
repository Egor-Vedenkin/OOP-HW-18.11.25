package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    public static final int FIXED_PRICE = 10000;

    public FixPriceProduct(String title) {
        super(title);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() { // Спецпродукт
        return true;
    }

    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена " + FIXED_PRICE;
    }
}

