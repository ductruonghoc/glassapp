package com.glassapp.catalog;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


import com.glassapp.catalog.exception.ProductNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceTest {
    // Khai báo một mock repository
    @Mock
    private ProductRepository repo;

    // Tiêm mock repository vào ProductService
    @InjectMocks
    private ProductService service;

    @Test
    void testFilterProductsByBrand() {
        Product p1 = new Product(1L, "P001", "Kính A", "Gucci", 3000000, "Metal", "Medium", "Round", "/img/a.png");
        Product p2 = new Product(2L, "P002", "Kính B", "RayBan", 2500000, "Plastic", "Small", "Square", "/img/b.png");

        when(repo.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> result = service.filterProducts("Gucci", null, null, null);

        System.out.println("Mocked result returned: " + result);

        assertEquals(1, result.size());
        assertEquals("Gucci", result.getFirst().getBrand());
    }

    @Test
    void testGetProductByCode_NotFound() {
        when(repo.findAll()).thenReturn(List.of());

        Exception ex = assertThrows(ProductNotFoundException.class,
                () -> service.getProductByCode("X123"));

        assertEquals("Product with code X123 not found", ex.getMessage());
    }

    @Test
    void testGetAllBrands() {
        Product p1 = new Product(1L, "P001", "Kính A", "Gucci", 3000000, "Metal", "Medium", "Round", "/img/a.png");
        Product p2 = new Product(2L, "P002", "Kính B", "RayBan", 2000000, "Plastic", "Small", "Square", "/img/b.png");

        when(repo.findAll()).thenReturn(Arrays.asList(p1, p2));

        Set<String> brands = service.getAllBrands();
        assertTrue(brands.contains("Gucci"));
        assertTrue(brands.contains("RayBan"));
    }

}
