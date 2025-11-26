package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }

    public void addToCart(Product product) {
        products.add(product);
    }

    public int totalPrice() {
        int total = 0;
        for (Product p: products) {
            total += p.getPrice();
        }
        return total;
    }

    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        }
        else {
            System.out.println("Список товаров в корзине:");
            for (Product p : products) {
                System.out.println(p.toString());
            }
            System.out.println("Итого в корзине: " + totalPrice());
        }
    }

    public boolean checkProduct(Product product) {
        return products.contains(product);
    }

    public void cleanBasket() {
        products.clear();
    }
}
