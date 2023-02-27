package com.example.order.service;

import com.example.order.entity.Product;
import com.example.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public void create(Product product) {

        productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product is not found with Id : " + id));
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public void delete(Long id) {

        productRepository.deleteById(id);
    }

    public void update(Product product) {
        if (product.getId() == null) {
            throw new IllegalArgumentException("Update operation should have an Id.");
        }
        productRepository.save(product);
    }

    public void update(Long id, Product product) {

        Optional<Product> productLoaded = productRepository.findById(id);
        productLoaded.orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Product updatedProduct = productLoaded.get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setProductStatus(product.isProductStatus());

        productRepository.save(updatedProduct);

    }
}
