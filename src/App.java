import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        DiscountedProduct discountedPhone = new DiscountedProduct("Телефончик", 3000);
        FixPriceProduct fixedNotebook = new FixPriceProduct("Фиксированный ноутбук");
        SimpleProduct simpleTablet = new SimpleProduct("Обычный планшет", 5000);
        SimpleProduct simpleLaptop = new SimpleProduct("Обычный ноутбук", 6000);

        ProductBasket basket = new ProductBasket();
        basket.addToCart(discountedPhone);
        basket.addToCart(fixedNotebook);
        basket.addToCart(simpleTablet);

        basket.showCart();

        System.out.println("Привет");
    }
}