package it.cch.exercise3.repository;

import it.cch.data.Category;
import it.cch.data.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategory(Category category);
    @Query("select p from Product p group by p.category, p.productId")
    List<Product> findGroupedByCategory();
}
