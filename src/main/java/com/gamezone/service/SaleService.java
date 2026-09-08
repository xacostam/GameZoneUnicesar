/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.service;

import com.gamezone.model.Sale;
import com.gamezone.persistence.SaleRepository;

public class SaleService {

    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void registerSale(Sale sale) {

        if (sale == null) {
            throw new IllegalArgumentException("Sale cannot be null.");
        }

        if (sale.getProducts().isEmpty()) {
            throw new IllegalArgumentException(
                    "A sale must contain at least one product."
            );
        }

        // First verify that all products have enough stock
        for (Product product : sale.getProducts()) {

            if (product.getAvailableQuantity() <= 0) {
                throw new IllegalArgumentException(
                        "Insufficient stock for product: "
                        + product.getTitle()
                );
            }
        }

        // Discount one unit of each acquired product
        for (Product product : sale.getProducts()) {

            product.setAvailableQuantity(
                    product.getAvailableQuantity() - 1
            );
        }

        // Save the sale
        saleRepository.save(sale);
    }
}