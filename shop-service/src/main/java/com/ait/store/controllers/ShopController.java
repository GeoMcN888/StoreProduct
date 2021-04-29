package com.ait.store.controllers;

import com.ait.store.Configuration;
import com.ait.store.exceptions.ShopNotFoundException;
import com.ait.store.feignclients.ProductClient;
import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import com.ait.store.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    Configuration config;

    @Autowired
    ProductClient productClient;

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<Shop> getShopById(@PathVariable long shopId) throws ShopNotFoundException {

        Product product = productClient.getProductById(shopId);
        Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new ShopNotFoundException("Shop not found"));
        shop.setProductValue(product.getProductValue());
        return ResponseEntity.ok(shop);
    }

    @DeleteMapping("/shops/{shopId}")
    public ResponseEntity deleteShopById(@PathVariable long shopId) throws ShopNotFoundException {
        Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new ShopNotFoundException("Shop not found"));
        shopRepository.delete(shop);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/shops")
    public ResponseEntity addShop(@RequestBody Shop shop) {
        shopRepository.save(shop);
        return ResponseEntity.accepted().body(shop);
    }

    @PutMapping("/shops/{shopId}")
    public ResponseEntity updateShop(@RequestBody Shop shop,
                                          @PathVariable("shopId") long shopId) {
        shopRepository.save(shop);
        return ResponseEntity.ok("shop saved");
    }

    @GetMapping("/shops")
    public List<Shop> getShops(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country){

        return shopRepository.findAll();
    }

    @GetMapping(value = "/shops", params = {"name", "country"})
    public List<Shop> getShopsByNameAndCountry(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country) {

            return shopRepository.findByNameAndCountry(name.get(), country.get());

    }

    @GetMapping(value = "/shops", params = "name")
    public List<Shop> getShopsByName(@RequestParam("name") Optional<String> name) {

        return shopRepository.findByName(name.get());
    }

    @GetMapping(value = "/shops", params = "country")
    public List<Shop> getShopsByCountry(@RequestParam("country") Optional<String> country) {

        return shopRepository.findByCountry(country.get());
    }

    @GetMapping("/shops/{shopId}/products")
    public List<Product> getProductsByShopId(@PathVariable long shopId){
        List<Product> products = productClient.findProductsByShopId(shopId);
        return products;
    }

//   Showing Configuration Stage. eg Development.
    @GetMapping("/shops/config")
    public String config(){
        return config.getName();
    }


}
