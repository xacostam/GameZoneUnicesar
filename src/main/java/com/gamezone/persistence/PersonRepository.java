package com.gamezone.persistence;

import com.gamezone.model.Client;
import com.gamezone.model.Seller;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to save and load persons
 */
public class PersonRepository {

    /**
     * Load clients from file
     * @return list of clients
     */
    public List<Client> loadClients() {
        List<Client> clients = new ArrayList<>();
        try {
            File f = new File("clients.txt");
            if (f.exists()) {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String[] line = sc.nextLine().split(",");
                    clients.add(new Client(line[0], line[1], line[2], line[3]));
                }
                sc.close();
            }
        } catch (Exception e) {
            System.out.println("Error reading clients");
        }
        return clients;
    }

    /**
     * Load sellers from file
     * @return list of sellers
     */
    public List<Seller> loadSellers() {
        List<Seller> sellers = new ArrayList<>();
        try {
            File f = new File("sellers.txt");
            if (f.exists()) {
                Scanner sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String[] line = sc.nextLine().split(",");
                    sellers.add(new Seller(line[0], line[1], line[2], line[3], line[4]));
                }
                sc.close();
            }
        } catch (Exception e) {
            System.out.println("Error reading sellers");
        }
        return sellers;
    }

    /**
     * Save clients to file
     * @param clients list to save
     */
    public void saveClients(List<Client> clients) {
        try {
            FileWriter fw = new FileWriter("clients.txt");
            for (Client c : clients) {
                fw.write(c.getId() + "," + c.getName() + "," + c.getPhone() + "," + c.getEmail() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving clients");
        }
    }

    /**
     * Save sellers to file
     * @param sellers list to save
     */
    public void saveSellers(List<Seller> sellers) {
        try {
            FileWriter fw = new FileWriter("sellers.txt");
            for (Seller s : sellers) {
                fw.write(s.getId() + "," + s.getName() + "," + s.getPhone() + "," + s.getEmployeeCode() + "," + s.getShift() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving sellers");
        }
    }
}