package it.cch.exercise3.dto;

import it.cch.data.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
@NoArgsConstructor
public class NewProductDto {
    @Getter @NonNull String description;
    @Getter @NonNull Category category;
    @Getter @NonNull @Min(value = 0, message = "The quantity must be positive") int quantity;
    @Getter @NonNull @Min(value = 0, message = "The price must be positive") double price;
}
