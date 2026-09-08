/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

/**
 *
 * @author Jose Rodriguez
 */
public abstract class Product {
    private String id;
    private String title;
    private double price;
    private int availableQuantity;

    public Product(String id, String title, double price, int availableQuantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    
    public abstract String getDescription();
    public abstract String getProductType();

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title=" + title + ", price=" + price + ", availableQuantity=" + availableQuantity + '}';
    }
}
