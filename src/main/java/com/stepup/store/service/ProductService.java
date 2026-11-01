package com.stepup.store.service;

import com.stepup.store.model.Product;
import com.stepup.store.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Optional<Product> getById(Long id) {
        return repo.findById(id);
    }

    public List<Product> search(String name, String category, String brand,
                                Double minPrice, Double maxPrice, String sort) {
        List<Product> results = repo.search(
            (name != null && name.isBlank()) ? null : name,
            (category != null && category.isBlank()) ? null : category,
            (brand != null && brand.isBlank()) ? null : brand,
            minPrice, maxPrice
        );

        if ("price_asc".equals(sort)) {
            results.sort(Comparator.comparingDouble(Product::getPrice));
        } else if ("price_desc".equals(sort)) {
            results.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        } else if ("rating".equals(sort)) {
            results.sort(Comparator.comparingDouble(Product::getRating).reversed());
        }

        return results;
    }

    public List<String> getCategories() {
        return repo.findAll().stream()
                .map(Product::getCategory)
                .distinct()
                .sorted()
                .toList();
    }

    public List<String> getBrands() {
        return repo.findAll().stream()
                .map(Product::getBrand)
                .distinct()
                .sorted()
                .toList();
    }
}
