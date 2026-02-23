package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int salePrice;

    public DiscountedProduct(String title, int price) {
        super(title);
        this.basePrice = price;
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
