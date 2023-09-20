package seminars.first.Shop;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {
    
    private Shop shop;

    public void setUp() {
        // Инициализируем магазин и добавляем продукты для тестирования
        shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product A", 10.0));
        products.add(new Product("Product B", 5.0));
        products.add(new Product("Product C", 15.0));
        shop.setProducts(products);
    }

    public void testGetMostExpensiveProduct() {
        // Проверяем, что метод getMostExpensiveProduct возвращает самый дорогой продукт
        Product mostExpensive = shop.getMostExpensiveProduct();
        assertThat(mostExpensive).isNotNull();
        assertThat(mostExpensive.getTitle()).isEqualTo("Product C");
        assertThat(mostExpensive.getCost()).isEqualTo(15.0);
    }

    public void testSortProductsByPrice() {
        // Проверяем, что метод sortProductsByPrice сортирует продукты по цене
        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts).hasSize(3);
        assertThat(sortedProducts).extracting(Product::getTitle)
                .containsExactly("Product B", "Product A", "Product C");
    }

    public void testEmptyShop() {
        // Проверяем, что методы корректно обрабатывают пустой магазин
        shop.setProducts(new ArrayList<>()); // Пустой список продуктов

        Product mostExpensive = shop.getMostExpensiveProduct();
        assertThat(mostExpensive).isNull();

        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts).isEmpty();
    }
}