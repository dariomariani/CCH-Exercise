package it.cch.exercise3.controller;

import it.cch.data.Category;
import it.cch.data.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/product")
    public Product product() {
        return new Product("Macbook", Category.CAT1, 1, 999.99);
    }
}

