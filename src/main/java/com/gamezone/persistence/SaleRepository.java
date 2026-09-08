/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.persistence;

/**
 *
 * @author User
 */
import com.gamezone.model.Sale;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaleRepository {

    private final String fileName = "sales.txt";

    public void save(Sale sale) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(fileName, true))) {

            writer.println("DATE: " + sale.getDate());
            writer.println("CUSTOMER: " + sale.getCustomer().getName());
            writer.println("SELLER: " + sale.getSeller().getName());

            writer.println("PRODUCTS:");

            for (Product product : sale.getProducts()) {
                writer.println(
                        product.getId() + " | "
                        + product.getTitle() + " | "
                        + product.getPrice()
                );
            }

            writer.println("TOTAL: " + sale.calculateTotal());
            writer.println("--------------------------------");

        } catch (IOException e) {
            throw new RuntimeException("Error saving sale.", e);
        }
    }
}
