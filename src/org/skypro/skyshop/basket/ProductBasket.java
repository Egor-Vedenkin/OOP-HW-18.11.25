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
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void showCart() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Список товаров в корзине:");
        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(p -> System.out.println(p.toString()));

        long specialCount = getSpecialCount();
        System.out.println("Специальных товаров: " + specialCount);
    }

    private long getSpecialCount() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean checkProduct(String title) {
        return basket.containsKey(title);
    }

    public void cleanBasket() {
        basket.clear();
    }
}