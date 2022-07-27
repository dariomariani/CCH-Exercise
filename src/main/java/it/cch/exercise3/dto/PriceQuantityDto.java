package it.cch.exercise3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@NoArgsConstructor
public class PriceQuantityDto {
    @Getter @Setter @Min(value = 0, message = "The quantity must be positive") Integer quantity;
    @Getter @Setter @Min(value = 0, message = "The price must be positive") Double price;
}
