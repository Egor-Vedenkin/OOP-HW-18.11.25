import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addToCart(new SimpleProduct("Хлеб", 50));
        basket.addToCart(new DiscountedProduct("Молоко", 100, 10));
        basket.addToCart(new SimpleProduct("Сыр", 150));
        basket.addToCart(new DiscountedProduct("Колбаса", 200, 15));

        System.out.println("\nПоказ корзины:");
        basket.showCart();

        System.out.println("\nЕсть ли 'Хлеб' в корзине?: " + basket.checkProduct("Хлеб"));

        System.out.println("\nОбщая сумма в корзине: " + basket.totalPrice() + " рублей");

        basket.cleanBasket();
        System.out.println("\nКорзина очищена. Текущее состояние корзины:");
        basket.showCart();

        Article article1 = new Article("JavaScript основы", "Здесь рассказывается о JS...");
        Article article2 = new Article("Основы Java", "Изучаем основы программирования на Java...");

        SearchEngine engine = new SearchEngine();
        engine.add(article1);
        engine.add(article2);

        System.out.println("\nРезультат поиска:");
        Map<String, Searchable> results = engine.search("основы");
        for (String key : results.keySet()) {
            System.out.println(key + ": " + results.get(key).getStringRepresentation());
        }
    }
}