import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addToCart(new SimpleProduct("Хлеб", 50));
        basket.addToCart(new DiscountedProduct("Молоко", 100, 10));

        System.out.println("\nПоказ корзины:");
        basket.showCart();

        Article article1 = new Article("JavaScript основы", "Здесь рассказывается о JS...");
        Article article2 = new Article("Основы Java", "Изучаем основы программирования на Java...");

        SearchEngine engine = new SearchEngine();

        engine.add(article1);
        engine.add(article2);
        engine.add(new SimpleProduct("Хлеб", 50)); // Дубликат не добавится

        System.out.println("\nРезультат поиска:");

        Set<Searchable> results = engine.search("основы");
        results.forEach(item -> {
            System.out.println(item.getName() + ": " + item.getStringRepresentation());
            System.out.println("---");
        });
    }
}