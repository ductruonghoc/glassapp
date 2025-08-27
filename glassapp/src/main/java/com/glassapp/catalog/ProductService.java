package com.glassapp.catalog;

import com.glassapp.catalog.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> filterProducts(String brand, String style, Double minPrice, Double maxPrice) {
        List<Product> all = repo.findAll();

        return all.stream()
                .filter(p -> brand == null || p.getBrand().equalsIgnoreCase(brand))
                .filter(p -> style == null || p.getStyle().equalsIgnoreCase(style))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .toList();
    }

    public Product getProductByCode(String code) {
        return repo.findAll().stream()
                .filter(p -> p.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(code));
    }

    public Set<String> getAllBrands() {
        return repo.findAll().stream()
                .map(Product::getBrand)
                .collect(Collectors.toSet());
    }

    public Map<String, Double> getProductPriceMap() {
        return repo.findAll().stream()
                .collect(Collectors.toMap(Product::getCode, Product::getPrice));
    }
}
