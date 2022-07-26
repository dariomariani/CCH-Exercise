package it.cch.data;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@RequiredArgsConstructor
public class Product {
    @Getter int productId;
    @Getter @NonNull String description;
    @Getter @NonNull Category category;
    @Getter @NonNull int quantity;
    @Getter @NonNull double price;
    @Getter LocalDate updatedAt;

    public double getTotalAmount() {
        return price * quantity;
    }
}
