package com.gamezone.service;

import com.gamezone.model.Client;
import com.gamezone.model.Seller;
import com.gamezone.persistence.PersonRepository;
import java.util.List;

/**
 * Service for persons
 */
public class PersonService {
    private PersonRepository repo;

    /**
     * Constructor
     * @param repo repository
     */
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    /**
     * Register client
     * @param id client id
     * @param name client name
     * @param phone client phone
     * @param email client email
     */
    public void registerClient(String id, String name, String phone, String email) {
        List<Client> clients = repo.loadClients();
        clients.add(new Client(id, name, phone, email));
        repo.saveClients(clients);
    }

    /**
     * Register seller
     * @param id seller id
     * @param name seller name
     * @param phone seller phone
     * @param code seller code
     * @param shift seller shift
     */
    public void registerSeller(String id, String name, String phone, String code, String shift) {
        List<Seller> sellers = repo.loadSellers();
        sellers.add(new Seller(id, name, phone, code, shift));
        repo.saveSellers(sellers);
    }

    /**
     * List clients
     * @return client list
     */
    public List<Client> listClients() {
        return repo.loadClients();
    }

    /**
     * List sellers
     * @return seller list
     */
    public List<Seller> listSellers() {
        return repo.loadSellers();
    }

    /**
     * Find client by id
     * @param id client id
     * @return Client or null
     */
    public Client findClientById(String id) {
        List<Client> clients = repo.loadClients();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId().equals(id)) {
                return clients.get(i);
            }
        }
        return null;
    }

    /**
     * Find seller by id
     * @param id seller id
     * @return Seller or null
     */
    public Seller findSellerById(String id) {
        List<Seller> sellers = repo.loadSellers();
        for (int i = 0; i < sellers.size(); i++) {
            if (sellers.get(i).getId().equals(id)) {
                return sellers.get(i);
            }
        }
        return null;
    }
}