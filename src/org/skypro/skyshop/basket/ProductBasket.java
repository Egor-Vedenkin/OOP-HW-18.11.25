package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket = new HashMap<>();

    public void addToCart(Product product) {
        String name = product.getTitle();
        basket.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int totalPrice() {
        int total = 0;
        for (List<Product> products : basket.values()) {
            for (Product p : products) {
                total += p.getPrice();
            }
        }
        return total;
    }

    public void showCart() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Список товаров в корзине:");
        for (List<Product> products : basket.values()) {
            for (Product p : products) {
                System.out.println(p.toString());
            }
        }
    }

    public boolean checkProduct(String title) {
        return basket.containsKey(title);
    }

    public void cleanBasket() {
        basket.clear();
    }
}