package it.cch.data;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Product extends AuditableEntity{
    @Getter @Setter @Id @GeneratedValue @EqualsAndHashCode.Include int productId;
    @Getter @Setter @NonNull String description;
    @Getter @Setter @NonNull Category category;
    @Getter @Setter @NonNull int quantity;
    @Getter @Setter @NonNull double price;

    public double getTotalAmount() {
        return price * quantity;
    }
}
