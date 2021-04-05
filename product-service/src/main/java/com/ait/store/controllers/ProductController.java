package com.ait.store.controllers;


import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import com.ait.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(() -> new Exception("Product not found"));
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity deleteProductById(@PathVariable long productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(() -> new Exception("Product not found"));
        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.accepted().body(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam("name") Optional<String> name, @RequestParam("company")Optional<String> company) {
        if (name.isPresent() && company.isPresent()) {
            return productRepository.findByNameAndCompany(name.get(), company.get());
        } else if (name.isPresent()) {
            return productRepository.findByName(name.get());
        } else if (company.isPresent()) {
            return productRepository.findByCompany(company.get());
        }
        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}/stores")
    public List<Shop> getShopsByProductId(@PathVariable long productId){
        return productRepository.findShopsByProductId(productId);
    }
}
