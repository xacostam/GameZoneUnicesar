/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.service;

import com.gamezone.model.Console;
import com.gamezone.model.Product;
import com.gamezone.model.VideoGame;
import com.gamezone.persistence.ProductPersistence;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class ProductService {
    private final ProductPersistence productPersistence;
    private List<Product> products;

    public ProductService(ProductPersistence productPersistence) {

        this.productPersistence = productPersistence;
        this.products = new ArrayList<>();

        loadProducts();
    }
    public boolean registerVideoGame(
            String id,
            String title,
            double price,
            int quantity,
            String platform,
            String genre,
            String ageRating) {

        if (!validateCommonData(id, title, price, quantity)) {
            return false;
        }

        if (existsProduct(id)) {
            System.out.println("A product with that ID already exists.");
            return false;
        }

        if (isEmpty(platform)
                || isEmpty(genre)
                || isEmpty(ageRating)) {

            System.out.println(
                    "Platform, genre and age rating are required."
            );

            return false;
        }

        Product Product = new VideoGame(
                id,
                title,
                price,
                quantity,
                platform,
                genre,
                ageRating
        );

        products.add(Product);
        saveProducts();

        return true;
    }

    public boolean registerConsole(
            String id,
            String title,
            double price,
            int quantity,
            String brand,
            String model,
            String generation) {

        if (!validateCommonData(id, title, price, quantity)) {
            return false;
        }

        if (existsProduct(id)) {
            System.out.println("A product with that ID already exists.");
            return false;
        }

        if (isEmpty(brand)
                || isEmpty(model)
                || isEmpty(generation)) {

            System.out.println(
                    "Brand, model and generation are required."
            );

            return false;
        }

        Product Product = new Console(
                id,
                title,
                price,
                quantity,
                brand,
                model,
                generation
        );

        products.add(Product);
        saveProducts();

        return true;
    }

    public List<Product> listProducts() {
        return new ArrayList<>(products);
    }

    public Product findProduct(String id) {

        if (isEmpty(id)) {
            return null;
        }

        for (Product Product : products) {

            if (Product.getId().equalsIgnoreCase(id.trim())) {
                return Product;
            }
        }

        return null;
    }
    public boolean existsProduct(String id) {

        return findProduct(id) != null;
    }
    
    public boolean updateStock(String id, int newQuantity) {

        if (newQuantity < 0) {
            System.out.println(
                    "Stock quantity cannot be negative."
            );

            return false;
        }

        Product Product = findProduct(id);

        if (Product == null) {

            System.out.println(
                    "Product not found."
            );

            return false;
        }

        Product.setAvailableQuantity(newQuantity);

        saveProducts();

        return true;
    }

   
    public boolean increaseStock(String id, int quantity) {

        if (quantity <= 0) {
            return false;
        }

        Product Product = findProduct(id);

        if (Product == null) {
            return false;
        }

        int NewQuantity =
                Product.getAvailableQuantity() + quantity;

        Product.setAvailableQuantity(NewQuantity);

        saveProducts();

        return true;
    }

   
    public boolean decreaseStock(String id, int quantity) {

        if (quantity <= 0) {
            return false;
        }

        Product Product = findProduct(id);

        if (Product == null) {
            return false;
        }

        if (Product.getAvailableQuantity() < quantity) {

            System.out.println(
                    "Insufficient stock for product: "
                    + Product.getTitle()
            );

            return false;
        }

        int NewQuantity =
                Product.getAvailableQuantity() - quantity;

        Product.setAvailableQuantity(NewQuantity);

        saveProducts();

        return true;
    }

  
    public int getProductCount() {
        return products.size();
    }

    public void saveProducts() {
        productPersistence.saveProducts(products);
    }
    
    public void loadProducts() {
        products = productPersistence.loadProducts();
    }
}
