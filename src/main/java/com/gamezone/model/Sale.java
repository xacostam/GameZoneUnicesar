/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private LocalDate date;
    private Customer customer;
    private Seller seller;
    private List<Product> products;

    public Sale(LocalDate date, Customer customer, Seller seller) {
        this.date = date;
        this.customer = customer;
        this.seller = seller;
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }

        products.add(product);
    }

    public LocalDate getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Seller getSeller() {
        return seller;
    }

}

