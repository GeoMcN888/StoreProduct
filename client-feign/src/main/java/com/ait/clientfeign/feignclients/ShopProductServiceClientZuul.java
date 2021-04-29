package com.ait.clientfeign.feignclients;


import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("zuul-api-gateway")
public interface ShopProductServiceClientZuul {

    @GetMapping("shop-service/shops/{shopId}")
    Shop getShopById(@PathVariable(value = "shopId") long shopId);

    @DeleteMapping("shop-service/shops/{shopId}")
    void deleteShopById(@PathVariable(value = "shopId") long shopId);

    @PostMapping("shop-service/shops")
    Shop addShop(@RequestBody Shop shop) ;

    @GetMapping("shop-service/shops")
    List<Shop> getShops();

    @GetMapping(value = "shop-service/shops", params = "name")
    List<Shop> getShopsByName(@RequestParam("name") String name);

    @GetMapping(value = "shop-service/shops", params = "country")
    List<Shop> getShopsByCountry(@RequestParam("country") String country);

    @GetMapping(value = "shop-service/shops", params = {"name", "country"})
    List<Shop> getShopsByNameAndCountry(@RequestParam("name") String name, @RequestParam("country") String country);

    @GetMapping("shop-service/shops/{shopId}/products")
    List<Product> getProductsByShopId(@PathVariable long shopId);

    @PutMapping("/shops/{shopId}")
    ResponseEntity updateShop(@RequestBody Shop shop, @PathVariable("shopId") long shopId);
}
