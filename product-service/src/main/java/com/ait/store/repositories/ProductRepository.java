package com.ait.store.repositories;


import com.ait.store.models.Product;
import com.ait.store.models.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> findByNameAndCompany(String name, String company);
    List<Product> findByName(String name);
    List<Product> findByCompany(String company);

    @Query("SELECT w from Shop w JOIN w.shopProducts u where u.id = ?1 ")
    List<Shop> findShopsByProductId(@PathVariable("productId") long productId);

}
