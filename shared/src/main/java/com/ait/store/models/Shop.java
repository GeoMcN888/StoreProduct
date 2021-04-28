package com.ait.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shop_id")
    private long shopId;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String country;
    @Column(name="phone_number")
    private long phoneNumber;
    @Column(name="year_founded", columnDefinition = "DATE")
    private LocalDate yearFounded;
    @Column
    private String picture;

    @Transient long productValue;

    public long getProductValue() {
        return productValue;
    }

    public void setProductValue(long productValue) {
        this.productValue = productValue;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "shop_products",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> shopProducts = new ArrayList<>();

    public void shopProducts(Product product){
        shopProducts.add(product);
    }

    public Shop() {
    }

    public Shop(long shopId, String name, String address, String country, long phoneNumber, LocalDate yearFounded, String picture, long productValue) {
        this.shopId = shopId;
        this.name = name;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.yearFounded = yearFounded;
        this.picture = picture;
        this.productValue = productValue;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(LocalDate yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Product> getShopProducts() {
        return shopProducts;
    }

    public void setShopProducts(List<Product> shopProducts) {
        this.shopProducts = shopProducts;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", yearFounded=" + yearFounded +
                ", picture='" + picture + '\'' +
                ", shopProducts=" + shopProducts +
                '}';
    }
}
