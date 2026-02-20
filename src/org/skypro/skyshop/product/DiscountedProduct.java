package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    public int basedPrice;
    public int salePrice;

    public DiscountedProduct(String title, int price) {
        super(title, price);
        this.basedPrice = price;
    }

    @Override
    public int getPrice() {
        salePrice = (int) (basedPrice * 0.9);
        return salePrice;
    }
}
