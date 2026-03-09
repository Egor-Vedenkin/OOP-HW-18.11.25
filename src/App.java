import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Создание корзины и добавление товаров
        ProductBasket basket = new ProductBasket();
        basket.addToCart(new SimpleProduct("Молоко", 70));
        basket.addToCart(new SimpleProduct("Хлеб", 30));
        basket.addToCart(new SimpleProduct("Сыр", 180));

        // Демонстрация добавления и вывода корзины
        System.out.println("\nКорзина ДО удаления:\n");
        basket.showCart();

        // Удаление продукта по имени
        List<Product> deletedProducts = basket.removeByName("Хлеб");
        if (!deletedProducts.isEmpty()) {
            System.out.println("\nУдалённые продукты:");
            for (Product p : deletedProducts) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("\nСписок пуст.");
        }

        // Просмотр корзины после удаления
        System.out.println("\nКорзина ПОСЛЕ удаления:\n");
        basket.showCart();

        // Попытка удалить несуществующий продукт
        deletedProducts = basket.removeByName("Колбаса");
        if (!deletedProducts.isEmpty()) {
            System.out.println("\nУдалённые продукты:");
            for (Product p : deletedProducts) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("\nСписок пуст.");
        }

        // Финальная проверка состояния корзины
        System.out.println("\nФинальное состояние корзины:\n");
        basket.showCart();

        // Работа с поиском
        SearchEngine engine = new SearchEngine();
        engine.add(new Article("Первая статья", "Это первая тестовая статья"));
        engine.add(new Article("Вторая статья", "Эта вторая статья тоже важна"));
        engine.add(new SimpleProduct("Простой продукт", 100));

        // Поиск статей
        List<Searchable> result = engine.search("статья");
        System.out.println("\nРезультаты поиска:");
        for (Searchable r : result) {
            System.out.println(r.getStringRepresentation());
        }
    }
}