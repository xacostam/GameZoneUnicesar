/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.ui;

/**
 *
 * @author User
 */
import com.gamezone.model.Customer;
import com.gamezone.model.Sale;
import com.gamezone.model.Seller;
import com.gamezone.persistence.SaleRepository;
import com.gamezone.service.SaleService;
import java.time.LocalDate;

public class SaleUI {

    public static void main(String[] args) {

        
        Customer customer = new Customer(
                "Juan Perez",
                "123456789",
                "3001234567",
                "juan@gmail.com"
        );

       
        Seller seller = new Seller(
                "Carlos Gomez",
                "987654321",
                "3109876543",
                "EMP001",
                "Morning"
        );

   
        VideoGame game = new VideoGame(
                "PlayStation 5",
                "Action",
                "18+",
                "VG001",
                "God of War",
                250000,
                5
        );

        Console console = new Console(
                "Sony",
                "PlayStation 5",
                "9th Generation",
                "C001",
                "PlayStation 5",
                2500000,
                2
        );

       
        Sale sale = new Sale(
                LocalDate.now(),
                customer,
                seller
        );

        sale.addProduct(game);
        sale.addProduct(console);

     
        SaleRepository saleRepository = new SaleRepository();

    
        SaleService saleService = new SaleService(saleRepository);

        // Register sale
        saleService.registerSale(sale);

        System.out.println("Sale registered successfully.");
        System.out.println("Total: " + sale.calculateTotal());
        System.out.println(
                "Game stock: " + game.getAvailableQuantity()
        );
        System.out.println(
                "Console stock: " + console.getAvailableQuantity()
        );
    }
}
