package com.ait.store;

import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import com.ait.store.repositories.ProductRepository;
import com.ait.store.repositories.ShopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceApplication.class, args);


	}
}