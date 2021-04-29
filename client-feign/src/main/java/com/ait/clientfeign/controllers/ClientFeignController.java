package com.ait.clientfeign.controllers;

import com.ait.clientfeign.Configuration;
import com.ait.clientfeign.feignclients.ShopProductServiceClientZuul;
import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientFeignController {
    @Autowired
    Configuration config;

    @Autowired
    ShopProductServiceClientZuul shopProductClientZuul;

    @GetMapping("client-feign-zuul/shops/{shopId}")
    public Shop getShopFromShopServiceZuul(@PathVariable long shopId) {
        return shopProductClientZuul.getShopById(shopId);
    }

    @PostMapping("client-feign-zuul/shops")
    public Shop addShopFromShopServiceZuul(@RequestBody Shop shop) {
        return shopProductClientZuul.addShop(shop);
    }

    /*@PutMapping("/shops/{shopId}")
    public ResponseEntity updateShopFromServiceZuul(@RequestBody Shop shop,
                                     @PathVariable("shopId") long shopId){
        return shopProductClientZuul.updateShop(shop, shopId);
    }*/
    @GetMapping(value = "client-feign-zuul/shops", params = {"name", "country"})
    public List<Shop> getShopsByNameAndCountryFromShopServiceZuul(@RequestParam("name") String name, @RequestParam("country") String country) {
        return shopProductClientZuul.getShopsByNameAndCountry(name, country);
    }

    @GetMapping(value = "client-feign-zuul/shops", params = "name")
    public List<Shop> getShopsByNameFromShopServiceZuul(@RequestParam("name") String name) {
        return shopProductClientZuul.getShopsByName(name);
    }

    @GetMapping(value = "client-feign-zuul/shops", params = "country")
    public List<Shop> getShopsByCountryFromShopServiceZuul(@RequestParam("country") String country) {
        return shopProductClientZuul.getShopsByCountry(country);
    }

    @GetMapping("client-feign-zuul/shops")
    public List<Shop> getShopsFromShopServiceZuul() {
        return shopProductClientZuul.getShops();
    }

    @DeleteMapping("client-feign-zuul/shops/{shopId}")
    void deleteShopFromShopServiceZuul(@PathVariable long shopId) {
        shopProductClientZuul.deleteShopById(shopId);
    }

    @GetMapping("client-feign-zuul/shops/{shopId}/products")
    public List<Product> getProductsByShopId(@PathVariable long shopId) {
        return shopProductClientZuul.getProductsByShopId(shopId);
    }

   /* @GetMapping("client-feign-zuul/shops/config")
    public String config() {
        return shopProductClientZuul.config();
    }*/
}
