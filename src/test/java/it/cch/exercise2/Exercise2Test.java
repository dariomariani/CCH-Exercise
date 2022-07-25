package it.cch.exercise2;

import it.cch.data.Category;
import it.cch.data.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Exercise2Test {

    private Exercise2 exercise2 = new Exercise2();

    @Test
    public void testGetAmountWhenRepositoryIsEmptyReturnZero(){
        assertEquals(0, exercise2.amount(new ArrayList<>(), Category.CAT1));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsOneElementAndCategoryIsFoundReturnProductPrice(){
        var product = new Product("Macbook", Category.CAT1, 999.99);
        var singletonProduct = Collections.singletonList(product);
        assertEquals(999.99, exercise2.amount(singletonProduct, Category.CAT1));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsOneElementAndCategoryIsNotFoundReturnZero(){
        var product = new Product("Macbook", Category.CAT1, 999.99);
        var singletonProduct = Collections.singletonList(product);
        assertEquals(0, exercise2.amount(singletonProduct, Category.CAT2));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsTwoElementAndCategoryIsFoundReturnSum(){
        var product1 = new Product("Macbook", Category.CAT1, 999.99);
        var product2 = new Product("iPhone", Category.CAT1, 1000.00);
        var productPair = Arrays.asList(product1, product2);
        assertEquals(1999.99, exercise2.amount(productPair, Category.CAT1));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsTwoElementAndCategoryIsNotFoundReturnZero(){
        var product1 = new Product("Macbook", Category.CAT1, 999.99);
        var product2 = new Product("iPhone", Category.CAT1, 1000.00);
        var productPair = Arrays.asList(product1, product2);
        assertEquals(0, exercise2.amount(productPair, Category.CAT2));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsElementFromDiffCategory(){
        var product1 = new Product("Macbook", Category.CAT1, 999.99);
        var product2 = new Product("iPhone", Category.CAT2, 1000.00);
        var productPair = Arrays.asList(product1, product2);
        assertEquals(999.99, exercise2.amount(productPair, Category.CAT1));
    }

    @Test
    public void testGetAmountWhenRepositoryContainsMultipleElementFromDiffCategory(){
        var product1 = new Product("Macbook", Category.CAT1, 999.99);
        var product2 = new Product("MacbookPRO", Category.CAT1, 10000.00);
        var product3 = new Product("iPhone", Category.CAT2, 1999.99);
        var productPair = Arrays.asList(product1, product2, product3);
        assertEquals(10999.99, exercise2.amount(productPair, Category.CAT1));
    }
}
