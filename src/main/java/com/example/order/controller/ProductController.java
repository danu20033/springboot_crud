package com.example.order.controller;

import com.example.order.entity.Product;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Product controller handle all api/products specific requests
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create new product by given product details.
     *
     * @param product Product instance to be set
     * @return
     */
    @PostMapping("/api/products")
    public ResponseEntity<Void> create(@RequestBody Product product) {
        productService.create(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Find Product by given id.
     *
     * @param id id of the product
     * @return matched Product
     */
    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Find Product by given name.
     *
     * @param name name of the Product.
     * @return matched Product
     */
    @GetMapping("/api/products/findByName")
    public ResponseEntity<Product> findByName(@RequestParam String name) {
        Product product = productService.findByName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Delete any given product by it's id.
     *
     * @param id id of the product
     * @return
     */
    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update Product by any given product details.
     *
     * @param product Product instance details to be set.
     * @return
     */
    @PutMapping("/api/products")
    public ResponseEntity<Void> update(@RequestBody Product product) {
        productService.update(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update partial data with given product detail.
     *
     * @param id id of the product
     * @return
     */
    @PatchMapping("/api/products/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Product product) {
        productService.update(id, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
