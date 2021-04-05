package com.ait.store.controllers;

import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import com.ait.store.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<Shop> getShopById(@PathVariable long shopId) throws Exception {
        Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new Exception("Shop not found"));
        return ResponseEntity.ok(shop);
    }

    @DeleteMapping("/shops/{shopId}")
    public ResponseEntity deleteShopById(@PathVariable long shopId) throws Exception {
        Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new Exception("Shop not found"));
        shopRepository.delete(shop);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/shops")
    public ResponseEntity addShop(@RequestBody Shop shop) {
        shopRepository.save(shop);
        return ResponseEntity.accepted().body(shop);
    }

    @GetMapping("/shops")
    public List<Shop> getShops(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country) {
        if (name.isPresent() && country.isPresent()) {
            return shopRepository.findByNameAndCountry(name.get(), country.get());
        } else if (name.isPresent()) {
            return shopRepository.findByName(name.get());
        } else if (country.isPresent()) {
            return shopRepository.findByCountry(country.get());
        }
        return shopRepository.findAll();
    }

    @GetMapping("/shops/{shopId}/products")
    public List<Product> getProductsByShopId(@PathVariable long shopId){
        return shopRepository.findProductsByShopId(shopId);
    }
}
