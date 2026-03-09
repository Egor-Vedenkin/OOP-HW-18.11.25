package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.List;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void addToCart(Product product) {
        products.add(product);
    }

    public int totalPrice() {
        int total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println("Список товаров в корзине:");
            for (Product p : products) {
                System.out.println(p.toString());
            }
            int specialCount = 0;
            for (Product p : products) {
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого в корзине: " + totalPrice() + " руб.");
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean checkProduct(String title) {
        for (Product p : products) {
            if (p.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); ) {
            Product currentProduct = products.get(i);
            if (currentProduct.getTitle().equals(name)) {
                removedProducts.add(currentProduct);
                products.remove(i);
            } else {
                i++; // Продвигаемся дальше, если товар не соответствует названию
            }
        }
        return removedProducts;
    }
}
