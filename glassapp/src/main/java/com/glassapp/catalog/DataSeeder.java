package com.glassapp.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository repo;
    private final Random random = new Random();

    public DataSeeder(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            IntStream.rangeClosed(1, 20).forEach(i -> {
                Product p = new Product();
                p.setCode("P" + String.format("%03d", i));
                p.setName("Kính Demo " + i);
                p.setBrand(randomBrand());
                p.setPrice(1000000 + random.nextInt(3000000));
                p.setMaterial(randomMaterial());
                p.setSize(randomSize());
                p.setImageUrl("/images/demo-" + i + ".png");
                repo.save(p);
            });
        }
    }

    private String randomBrand() {
        String[] brands = {"Gucci", "RayBan", "Gentle Monster", "Oakley"};
        return brands[random.nextInt(brands.length)];
    }

    private String randomMaterial() {
        String[] mats = {"Titanium", "Plastic", "Metal"};
        return mats[random.nextInt(mats.length)];
    }

    private String randomSize() {
        String[] sizes = {"Small", "Medium", "Large"};
        return sizes[random.nextInt(sizes.length)];
    }
}
