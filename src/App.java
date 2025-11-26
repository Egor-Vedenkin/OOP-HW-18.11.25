import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Телефон", 3000);
        Product product2 = new Product("Планшет", 5000);
        Product product3 = new Product("Ноутбук", 10000);
        Product product4 = new Product("Телевизор", 12500);

        ProductBasket basket = new ProductBasket();
        basket.addToCart(product1);
        basket.addToCart(product2);
        basket.addToCart(product3);

        basket.showCart();

        System.out.println(basket.checkProduct(product4));
        System.out.println(basket.checkProduct(product1));

        basket.cleanBasket();

        basket.showCart();

        System.out.println(basket.totalPrice());

        System.out.println(basket.checkProduct(product1));
    }
}