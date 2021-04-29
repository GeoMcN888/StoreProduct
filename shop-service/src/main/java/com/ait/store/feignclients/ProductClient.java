package com.ait.store.feignclients;

import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "zuul-api-gateway")
public interface ProductClient {
    @GetMapping("product-service/products/{productId}")
    Product getProductById(@PathVariable long productId);

    @DeleteMapping("product-service/products/{productId}")
    void deleteProductById(@PathVariable(value = "productId") long productId);

    @PostMapping("product-service/products/{productId}")
    Product addProduct(@RequestBody Product product) ;

    @GetMapping("product-service/products")
    List<Product> getProducts();

    @GetMapping(value = "product-service/products", params = "company")
    List<Product> getProductsByCompany(@RequestParam("company") Optional<String> company);

    @GetMapping(value = "product-service/products", params = "name")
    List<Product> getProductsByName(@RequestParam("name") Optional<String> name);

    @GetMapping(value = "product-service/products", params = {"name", "company"})
    List<Product> getProductsByNameAndCompany(@RequestParam("name") Optional<String> name, @RequestParam("company")Optional<String> company);

    @GetMapping("product-service/products/{productId}/shops")
    List<Shop> getShopsByProductId(@PathVariable long productId);

    @GetMapping("product-service/shops/{shopId}/products")
    List<Product> findProductsByShopId(@PathVariable("shopId") long shopId);

}
