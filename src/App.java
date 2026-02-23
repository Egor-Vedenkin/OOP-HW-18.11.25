import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        // Товары
        DiscountedProduct phone = new DiscountedProduct("Телефон", 3000);
        FixPriceProduct notebook = new FixPriceProduct("Ноутбук");
        SimpleProduct tablet = new SimpleProduct("Планшет", 5000);

        // Статьи
        Article article1 = new Article("Советы по выбору телефона", "Выбирайте телефон с хорошим аккумулятором!");
        Article article2 = new Article("Что выбрать: ноутбук или планшет?", "Рассмотрите потребности перед покупкой.");

        // Объект ProductBasket
        ProductBasket basket = new ProductBasket();
        basket.addToCart(phone);
        basket.addToCart(notebook);
        basket.addToCart(tablet);

        // Объект SearchEngine
        SearchEngine engine = new SearchEngine(8); // 5 товаров и 3 статьи
        engine.add(phone);
        engine.add(notebook);
        engine.add(tablet);
        engine.add(article1);
        engine.add(article2);

        // Проверка поиска
        Searchable[] result = engine.search("телефон");
        for (Searchable s : result) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }

        // Показываем содержимое корзины
        basket.showCart();
    }
}