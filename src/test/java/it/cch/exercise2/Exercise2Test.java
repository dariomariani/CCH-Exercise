package it.cch.exercise2;

import it.cch.data.Category;
import it.cch.data.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class Exercise2Test {
    private static final double price = 999.99;
    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new Product("Macbook", Category.CAT1, 1, 999.99), new Product("iPhone", Category.CAT1, 1, 1000.00)),
                Arguments.of(new Product("Macbook", Category.CAT2, 1, 999.99), new Product("iPhone", Category.CAT2, 1, 1000.00)),
                Arguments.of(new Product("Macbook", Category.CAT1, 2, 999.99), new Product("iPhone", Category.CAT1, 3, 1000.00))
        );
    }

    private static Stream<Arguments> testProductArguments() {
        return Stream.of(
                Arguments.of(1, Category.CAT1),
                Arguments.of(2, Category.CAT1),
                Arguments.of(2, Category.CAT2)
        );
    }

    private final Exercise2 exercise2 = new Exercise2();

    @Test
    public void testGetAmountWhenRepositoryIsEmptyReturnZero() {
        assertEquals(0, exercise2.amount(new ArrayList<>(), Category.CAT1));
    }

    @ParameterizedTest
    @MethodSource("testProductArguments")
    public void testGetAmountSingleProductFoundDifferentQuantitiesOrNotFound(int quantity, Category expectedCategory) {
        var product = new Product("Macbook", Category.CAT1, quantity, price);
        var singletonProduct = Collections.singletonList(product);
        assertEquals(expectedCategory.equals(product.getCategory()) ? price * quantity : 0, exercise2.amount(singletonProduct, expectedCategory));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void parametrized(Product firstProduct, Product secondProduct) {
        var category = Category.CAT1;
        var productPair = Arrays.asList(firstProduct, secondProduct);
        var expected = productPair.stream()
                .filter(product -> category.equals(product.getCategory()))
                .map((product -> product.getPrice() * product.getQuantity()))
                .reduce(0.0, Double::sum);
        assertEquals(expected, exercise2.amount(productPair, category));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsElementFromDiffCategory() {
        var product1 = new Product("Macbook", Category.CAT1, 1, 999.99);
        var product2 = new Product("iPhone", Category.CAT2, 1, 1000.00);
        var productPair = Arrays.asList(product1, product2);
        assertEquals(999.99, exercise2.amount(productPair, Category.CAT1));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsMultipleElementFromDiffCategory() {
        var product1 = new Product("Macbook", Category.CAT1, 2, 999.99);
        var product2 = new Product("MacbookPRO", Category.CAT1, 1, 10000.00);
        var product3 = new Product("iPhone", Category.CAT2, 1, 1999.99);
        var productPair = Arrays.asList(product1, product2, product3);
        assertEquals((999.99 * 2) + 10000.00, exercise2.amount(productPair, Category.CAT1));
    }
}
