package it.cch.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @Getter @Id @GeneratedValue @EqualsAndHashCode.Include int productId;
    @Getter @NonNull String description;
    @Getter @NonNull Category category;
    @Getter @NonNull int quantity;
    @Getter @NonNull double price;
    @Getter LocalDateTime updatedAt;

    public double getTotalAmount() {
        return price * quantity;
    }
}
