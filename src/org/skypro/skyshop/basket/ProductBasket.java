package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[]{null, null, null, null, null};

    public void addToCart(Product product) {
        boolean cartIsFull = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                cartIsFull = false;
            }
        } if (!cartIsFull) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = product;
                    break;
                }
            }
        } if (cartIsFull) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalPrice() {
        int total = 0;
        for (Product p: products) {
            if (p != null) {
                total += p.getPrice();
            }
        }
        return total;
    }

    public void showCart() {
        boolean cartIsEmpty = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                cartIsEmpty = false;
                break;
            }
        }
        if (!cartIsEmpty) {
            System.out.println("Список товаров в корзине:");
            for (Product p : products) {
                if (p != null) {
                    System.out.println(p.toString());
                } else continue;
            }
            System.out.println("Итого в корзине: " + totalPrice() + " руб.");
        } else {
            System.out.println("Корзина пуста");
        }
    }

    public boolean checkProduct(String title) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getTitle() == title) return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
    }
}
