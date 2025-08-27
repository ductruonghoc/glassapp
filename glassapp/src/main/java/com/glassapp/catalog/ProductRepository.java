package com.glassapp.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrandIgnoreCase(String brand);
    List<Product> findByStyleIgnoreCase(String style);
    List<Product> findByPriceBetween(double min, double max);
}
