/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.persistence;

import com.gamezone.model.Console;
import com.gamezone.model.Product;
import com.gamezone.model.VideoGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jose Rodriguez
 */
public class ProductPersistence {
    private static final String FILE_PATH="data/products.txt";
    
    public ProductPersistence(){
        createDataFile();
    }
    
    private void createDataFile(){
        File File= new File(FILE_PATH);
        
        try{
            File Parent = File.getParentFile();
            
            if(Parent != null && !Parent.exists()){
                Parent.mkdirs();
            }
            
            if (!File.exists()){
                File.createNewFile();
            }
        }catch (IOException Exception){
            System.out.println("Error creating product data file: ");
        }
    }
    public void saveProducts(List<Product>Products){
        try (BufferedWriter writer= new BufferedWriter(new FileWriter(FILE_PATH))){
            for (Product Product : Products){
                if (Product instanceof VideoGame){
                    VideoGame Game= (VideoGame) Product;
                    
                    Writer.write(
                            "VIDEO_GAME;"
                            + clean(Game.getId()) + ";"
                            + clean(Game.getTitle()) + ";"
                            + Game.getPrice() + ";"
                            + Game.getAvailableQuantity() + ";"
                            + clean(Game.getPlatform()) + ";"
                            + clean(Game.getGenre()) + ";"
                            + clean(Game.getAgeRating())
                    );
                } else if (Product instanceof Console){
                    Console Console = (Console)Product;
                    
                    Writer.write(
                            "CONSOLE;"
                            + clean(Console.getId()) + ";"
                            + clean(Console.getTitle()) + ";"
                            + Console.getPrice() + ";"
                            + Console.getAvailableQuantity() + ";"
                            + clean(Console.getBrand()) + ";"
                            + clean(Console.getModel()) + ";"
                            + clean(Console.getGeneration())
                    );
                }
                Writer.newLine();
            }
        } catch (TOException Exception) {
            System.out.println("Error saving Products: " + Exception.getMessage());
        }
    }
    public List<Product> loadProducts() {

        List<Product> Products = new ArrayList<>();

        File File = new File(FILE_PATH);

        if (!File.exists()) {
            return Products;
        }

        try (BufferedReader Reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String Line;

            while ((Line = Reader.readLine()) != null) {

                if (Line.trim().isEmpty()) {
                    continue;
                }

                try {

                    Product Product = convertLineToProduct(Line);

                    if (Product != null) {
                        Products.add(Product);
                    }

                } catch (Exception Exception) {

                    System.out.println(
                            "Invalid product record ignored: "
                            + Line
                    );
                }
            }

        } catch (IOException Exception) {

            System.out.println(
                    "Error loading products: "
                    + Exception.getMessage()
            );
        }

        return Products;
    }

    private Product convertLineToProduct(String Line) {

        String[] Data = Line.split(";", -1);

        if (Data.length != 8) {
            return null;
        }

        String Type = Data[0];

        String Id = Data[1];
        String Title = Data[2];
        double Price = Double.parseDouble(Data[3]);
        int Quantity = Integer.parseInt(Data[4]);

        if ("VIDEO_GAME".equalsIgnoreCase(Type)) {

            return new VideoGame(
                    Id,
                    Title,
                    Price,
                    Quantity,
                    Data[5],
                    Data[6],
                    Data[7]
            );
        }

        if ("CONSOLE".equalsIgnoreCase(Type)) {

            return new Console(
                    Id,
                    Title,
                    Price,
                    Quantity,
                    Data[5],
                    Data[6],
                    Data[7]
            );
        }

        return null;
    }

    private String clean(String Value) {

        if (Value == null) {
            return "";
        }

        return Value.replace(";", ",");
    }
}
