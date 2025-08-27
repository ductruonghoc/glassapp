package com.glassapp.catalog.controller;

import com.glassapp.catalog.Product;
import com.glassapp.catalog.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String style,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return service.filterProducts(brand, style, minPrice, maxPrice);
    }

    @GetMapping("/code/{code}")
    public Product getProductByCode(@PathVariable String code) {
        return service.getProductByCode(code);
    }

    @GetMapping("/brands")
    public Set<String> getAllBrands() {
        return service.getAllBrands();
    }

    @GetMapping("/price-map")
    public Map<String, Double> getProductPriceMap() {
        return service.getProductPriceMap();
    }
}
