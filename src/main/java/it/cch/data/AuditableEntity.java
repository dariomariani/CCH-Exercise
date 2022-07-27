package it.cch.data;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
@MappedSuperclass
public abstract class AuditableEntity {
    @Getter @CreatedDate @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdAt;
    @Getter @LastModifiedDate @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updatedAt;
}
