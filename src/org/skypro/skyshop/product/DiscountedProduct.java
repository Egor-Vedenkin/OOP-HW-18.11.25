package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int discountPercent;
    private int basePrice;
    private int salePrice;

    public DiscountedProduct(String title, int price, int discountPercent) {
        super(title);
        if (price <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше нуля");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100 включительно");
        }
        this.basePrice = price;
        this.discountPercent = discountPercent;
        calculateSalePrice();
    }

    private void calculateSalePrice() {
        salePrice = (int) (basePrice * 0.9); // скидка 10%
    }

    @Override
    public int getPrice() {
        return salePrice;
    }

    @Override
    public boolean isSpecial() { // Спецпродукт
        return true;
    }

    @Override
    public String toString() {
        double discountPercentage = ((double)(basePrice - salePrice)) / basePrice * 100;
        return getTitle() + ": " + salePrice + " (" + Math.round(discountPercentage) + "%)";
    }
}
