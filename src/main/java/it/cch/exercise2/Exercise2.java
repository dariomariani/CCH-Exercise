package it.cch.exercise2;

import it.cch.data.Category;
import it.cch.data.Product;

import java.util.List;

public class Exercise2 {
    /**
     * @param products the list of products
     * @param category the category on which to filter
     *
     * @return The sum of total amount for all products belonging to the input category
     */
    public double amount(List<Product> products, Category category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .mapToDouble(Product::getTotalAmount)
                .reduce(0, Double::sum);
    }
}
