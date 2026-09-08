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
}
