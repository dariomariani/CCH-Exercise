package it.cch.exercise3.controller;

import it.cch.data.Category;
import it.cch.data.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping()
    public Product addProduct() {
        return new Product("Macbook", Category.CAT1, 1, 999.99);
    }
    @GetMapping()
    public List<Product> getAll() {
        return Collections.singletonList(new Product("Macbook", Category.CAT1, 7, 999.99));
    }
    @GetMapping(path = "/findByCategory", params = "category")
    public Product getAllProductByCategory(@RequestParam Category category) {
        return new Product("Macbook", category, 5, 999.99);
    }
    @GetMapping("groupByCategory")
    public Map<Category,List<Product>> getAllProductsGroupedByCategory() {
        var result = new HashMap<Category,List<Product>>();
        result.put(Category.CAT1, Collections.singletonList(new Product("Macbook", Category.CAT1, 1, 999.99)));
        return result;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return new Product("Macbook", Category.CAT1, 1, 999.99);
    }
    @PutMapping()
    public Product updateProduct() {
        return new Product("Macbook", Category.CAT1, 1, 999.99);
    }
}

