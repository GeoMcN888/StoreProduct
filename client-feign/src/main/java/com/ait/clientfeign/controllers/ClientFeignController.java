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

    @GetMapping("client-feign-zuul/products/{productId}")
    public Product getProductFromProductServiceZuul(@PathVariable long productId)
    {
        return shopProductClientZuul.getProductById(productId);
    }

    @DeleteMapping("client-feign-zuul/products/{productId}")
    public void deleteProductFromProductServiceZuul(@PathVariable long productId) {
        shopProductClientZuul.deleteProductById(productId);
    }

    @PostMapping("client-feign-zuul/products")
    public Product addProductToProductServiceZuul(@RequestBody Product product) {
        return shopProductClientZuul.addProduct(product);
    }


    @GetMapping("client-feign-zuul/products")
    public List<Product> getProductsFromProductService() {
        return shopProductClientZuul.getProducts();
    }

    @GetMapping(value = "client-feign-zuul/products", params = {"name", "company"})
    public List<Product> getProductsByNameAndCompanyFromProductService(@RequestParam("name") Optional<String> name, @RequestParam("company") Optional<String> company) {
        return shopProductClientZuul.getProductsByNameAndCompany(name, company);
    }

    @GetMapping(value = "client-feign-zuul/products", params = "name")
    public List<Product> getProductsByNameFromProductService(@RequestParam("name") Optional<String> name) {
        return shopProductClientZuul.getProductsByName(name);
    }

    @GetMapping(value = "client-feign-zuul/products", params = "company")
    public List<Product> getProductsByCompanyFromProductService(@RequestParam("company") Optional<String> company) {
        return shopProductClientZuul.getProductsByCompany(company);
    }

    @GetMapping("client-feign-zuul/shops/{shopId}")
    public Shop getShopFromShopServiceZuul(@PathVariable long shopId){
        return shopProductClientZuul.getShopById(shopId);
    }


    @PostMapping("client-feign-zuul/shops")
    public Shop addShopFromShopServiceZuul(@RequestBody Shop shop) {
        return shopProductClientZuul.addShop(shop);
    }


    @GetMapping(value = "client-feign-zuul/shops", params = {"name", "country"})
    public List<Shop> getShopsByNameAndCountryFromShopServiceZuul(@RequestParam("name") Optional<String> name, @RequestParam("country")Optional<String> country){

        return shopProductClientZuul.getShopsByNameAndCountry(name, country );
    }

    @GetMapping(value = "client-feign-zuul/shops", params = "name")
    public List<Shop> getShopsByNameFromShopServiceZuul(@RequestParam("name") Optional<String> name){

        return shopProductClientZuul.getShopsByName(name);
    }

    @GetMapping(value = "client-feign-zuul/shops", params = "country")
    public List<Shop> getShopsByCountryFromShopServiceZuul(@RequestParam("country")Optional<String> country){

        return shopProductClientZuul.getShopsByCountry(country);
    }

    @GetMapping("client-feign-zuul/shops")
    public List<Shop> getShopsFromShopServiceZuul(){

        return shopProductClientZuul.getShops();
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
