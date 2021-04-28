package com.ait.store;

import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import com.ait.store.repositories.ShopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Configuration
public class ShopServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceApplication.class, args);


	}
}