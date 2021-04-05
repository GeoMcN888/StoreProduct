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
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ShopServiceApplication.class, args);
		ShopRepository shopRepository = configurableApplicationContext.getBean(ShopRepository.class);
		ProductRepository productRepository = configurableApplicationContext.getBean(ProductRepository.class);

		Shop shop1 = new Shop(1, "Supervalu", "Knocklyon, Dublin", "Ireland", 012342354, LocalDate.of(1994, 1, 8), "dewre");

		List<Shop> shops = Arrays.asList(shop1);

		Product product1 = new Product(1, "Kinder Egg", "Nestle", 2.55, LocalDate.of(1994, 1, 8), "Chocolate Bar", "Great quality choclate", "Germany");
		List<Product> products = Arrays.asList(product1);


		shop1.shopProducts(product1);

		shopRepository.save(shop1);

	}
}