package com.ait.clientfeign.feignclients;

import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("zuul-api-gateway")
public interface ShopProductServiceClientZuul {
    @GetMapping("product-service/product/{productId}")
    Product getProductById(@PathVariable(value = "productId") long productId);

    @DeleteMapping("product-service/product/{productId}")
    void deleteProductById(@PathVariable(value = "productId") long productId);

    @PostMapping("product-service/product/{productId}")
    Product addProduct(@RequestBody Product product) ;

    @GetMapping("product-service/product")
    List<Product> getProducts(@RequestParam("name") Optional<String> name, @RequestParam("company")Optional<String> company);

    @GetMapping("product-service/products/{productId}/shops")
    List<Shop> getShopsByProductId(@PathVariable long productId);

    @GetMapping("shop-service/shops/{shopId}")
    Shop getShopById(@PathVariable(value = "shopId") long shopId);

    @DeleteMapping("shop-service/shops/{shopId}")
    void deleteShopById(@PathVariable(value = "shopId") long shopId);

    @PostMapping("shop-service/shops")
    Shop addShop(@RequestBody Shop shop) ;

    @GetMapping("shop-service/shops")
    List<Shop> getShops(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country);

    @GetMapping("shop-service//shops/{shopId}/products")
    List<Product> getProductsByShopId(@PathVariable long shopId);

}
