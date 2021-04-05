package com.ait.clientfeign.controllers;

import com.ait.clientfeign.feignclients.ShopProductServiceClientZuul;
import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientFeignController
{
   

    @Autowired
    ShopProductServiceClientZuul shopProductClientZuul;

    @GetMapping("client-feign-zuul/product/{productId}")
    public Product getProductFromProductServiceZuul(@PathVariable long productId)
    {
        return shopProductClientZuul.getProductById(productId);
    }

    @DeleteMapping("client-feign-zuul/product/{productId}")
    public void deleteProductFromProductServiceZuul(@PathVariable long productId) {
        shopProductClientZuul.deleteProductById(productId);
    }

    @PostMapping("client-feign-zuul/product")
    public Product addProductToProductServiceZuul(@RequestBody Product product) {
        return shopProductClientZuul.addProduct(product);
    }


    @GetMapping("client-feign-zuul/product")
    public List<Product> getProductsFromProductService(@RequestParam("name") Optional<String> name, @RequestParam("company") Optional<String> company) {
        return shopProductClientZuul.getProducts(name, company);
    }

    @GetMapping("client-feign-zuul/shops/{shopId}")
    public Shop getShopFromShopServiceZuul(@PathVariable long shopId){
        return shopProductClientZuul.getShopById(shopId);
    }


    @PostMapping("client-feign-zuul/shops")
    public Shop addShopFromShopServiceZuul(@RequestBody Shop shop) {
        return shopProductClientZuul.addShop(shop);
    }


    @GetMapping("client-feign-zuul/shops")
    public List<Shop> getShopsFromShopServiceZuul(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country){
        return shopProductClientZuul.getShops(name, country );
    }


    @DeleteMapping("client-feign-zuul/shops/{shopId}")
    void deleteShopFromShopServiceZuul(@PathVariable long shopId) {
        shopProductClientZuul.deleteShopById(shopId);
    }

    @GetMapping("client-feign-zuul/products/{productId}/shops")
    public List<Shop> getShopsByProductId(@PathVariable long productId){
        return shopProductClientZuul.getShopsByProductId(productId);
    }

    @GetMapping("client-feign-zuul/shops/{shopId}/products")
    public List<Product> getProductsByShopId(@PathVariable long shopId){
        return shopProductClientZuul.getProductsByShopId(shopId);
    }


}
