package seminars.first.Shop;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

// Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Используем компаратор для сравнения продуктов по цене
        Collections.sort(products, Comparator.comparing(Product::getCost));
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null; // Возвращаем null, если список продуктов пуст
        }

        // Ищем максимальное значение цены среди продуктов
        Product mostExpensive = Collections.max(products, Comparator.comparing(Product::getCost));
        return mostExpensive;
    }

}