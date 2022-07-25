package it.cch.data;

import lombok.Getter;

import java.time.LocalDate;

public class Product {
    @Getter int productId;
    @Getter String description;
    @Getter Category category;
    @Getter int quantity;
    @Getter double price;
    @Getter LocalDate date;
}
