package it.cch.exercise3.controller;

import it.cch.data.Category;
import it.cch.data.Product;
import it.cch.exercise3.dto.NewProductDto;
import it.cch.exercise3.dto.PriceQuantityDto;
import it.cch.exercise3.exception.ProductNotFoundException;
import it.cch.exercise3.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ProductController(ProductRepository repository) {
        this.repository = repository;
    }
    @PostMapping()
    public ResponseEntity<Product> addProduct(@Valid @RequestBody NewProductDto newProductDto) {
        var newProduct = this.modelMapper.map(newProductDto, Product.class);
        newProduct = this.repository.save(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Product> getAll() {
        return (List<Product>) this.repository.findAll();
    }
    @GetMapping(path = "/findByCategory", params = "category")
    public List<Product> getAllProductByCategory(@RequestParam Category category) {
        return this.repository.findByCategory(category);
    }
    @GetMapping("/groupByCategory")
    public List<Product> getAllProductsGroupedByCategory() {
        return this.repository.findGroupedByCategory();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,@Valid @RequestBody PriceQuantityDto priceQuantityDto) {
        return repository.findById(id).map(product -> {
            var quantity = priceQuantityDto.getQuantity();
            if (quantity != null) product.setQuantity(quantity.intValue());
            var price = priceQuantityDto.getPrice();
            if (price != null) product.setPrice(price.doubleValue());
            return this.repository.save(product);
        }).orElseThrow(() -> new ProductNotFoundException(id));
    }
}

