package com.example.spring_boot.service;

import com.example.spring_boot.model.product;
import com.example.spring_boot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    public product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public product addProduct(product product) {
        return productRepository.save(product);
    }

    public product updateProduct(Long id, product product) {
        product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}