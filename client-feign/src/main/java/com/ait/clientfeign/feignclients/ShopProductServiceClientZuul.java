package com.ait.clientfeign.feignclients;

import com.ait.clientfeign.models.Product;
import com.ait.clientfeign.models.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("zuul-api-gateway")
public interface ShopProductServiceClientZuul {


    @GetMapping("product-service/products/{productId}")
    Product getProductById(@PathVariable(value = "productId") long productId);

    @DeleteMapping("product-service/products/{productId}")
    void deleteProductById(@PathVariable(value = "productId") long productId);

    @PostMapping("product-service/products/{productId}")
    Product addProduct(@RequestBody Product product) ;

    @GetMapping("product-service/products")
    List<Product> getProducts();

    @GetMapping(value = "product-service/products", params = "company")
    List<Product> getProductsByCompany(@RequestParam("company")Optional<String> company);

    @GetMapping(value = "product-service/products", params = "name")
    List<Product> getProductsByName(@RequestParam("name") Optional<String> name);

    @GetMapping(value = "product-service/products", params = {"name", "company"})
    List<Product> getProductsByNameAndCompany(@RequestParam("name") Optional<String> name, @RequestParam("company")Optional<String> company);

    @GetMapping("product-service/products/{productId}/shops")
    List<Shop> getShopsByProductId(@PathVariable long productId);

    @GetMapping("shop-service/shops/{shopId}")
    Shop getShopById(@PathVariable(value = "shopId") long shopId);

    @DeleteMapping("shop-service/shops/{shopId}")
    void deleteShopById(@PathVariable(value = "shopId") long shopId);

    @PostMapping("shop-service/shops")
    Shop addShop(@RequestBody Shop shop) ;

    @GetMapping("shop-service/shops")
    List<Shop> getShops();

    @GetMapping(value = "shop-service/shops", params = "name")
    List<Shop> getShopsByName(@RequestParam("name") Optional<String> name);

    @GetMapping(value = "shop-service/shops", params = "country")
    public List<Shop> getShopsByCountry(@RequestParam("country")Optional<String> country);

    @GetMapping(value = "shop-service/shops", params = {"name", "country"})
    public List<Shop> getShopsByNameAndCountry(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country);

    @GetMapping("shop-service/shops/{shopId}/products")
    List<Product> getProductsByShopId(@PathVariable long shopId);

    @GetMapping("/test")
    public String test();

}
