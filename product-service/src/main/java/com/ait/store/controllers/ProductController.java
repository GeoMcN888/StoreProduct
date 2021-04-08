package com.ait.store.controllers;


import com.ait.store.Configuration;
import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import com.ait.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    Configuration config;



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

    @GetMapping(value = "/products", params = {"name", "company"})
    public List<Product> getProductsByNameAndCompany(@RequestParam("name") Optional<String> name, @RequestParam("company")Optional<String> company) {
        return productRepository.findByNameAndCompany(name.get(), company.get());
    }

    @GetMapping(value = "/products", params = "name")
    public List<Product> getProductsByName(@RequestParam("name") Optional<String> name) {
        return productRepository.findByName(name.get());
    }

    @GetMapping(value = "/products", params = "company")
    public List<Product> getProductsByCompany(@RequestParam("company")Optional<String> company) {
        return productRepository.findByCompany(company.get());
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}/stores")
    public List<Shop> getShopsByProductId(@PathVariable long productId){
        return productRepository.findShopsByProductId(productId);
    }

    @GetMapping("/products/config")
    public String test(){
        return config.getName();
    }
}
