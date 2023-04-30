package com.rogerirobothia.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productBrand;
    private int amount;
    private boolean stock;
    private LocalDateTime createdDate;

    public Product() {
    }

    public Product(Long id, String productName, String productBrand, int amount, boolean stock) {
        this.id = id;
        this.productName = productName;
        this.productBrand = productBrand;
        this.amount = amount;
        this.stock = stock;
        this.createdDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", amount=" + amount +
                ", stock=" + stock +
                ", createdDate=" + createdDate +
                '}';
    }
}
