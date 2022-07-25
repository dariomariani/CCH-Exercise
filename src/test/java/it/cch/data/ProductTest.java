package it.cch.data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void testWhenQuantityIsZeroTotalAmountIsZero(){
        var product = new Product("Macbook", Category.CAT1, 0, 999.99);
        assertEquals(0, product.getTotalAmount());
    }
}
