package com.gamezone.model;

/**
 * Class for Client
 */
public class Client extends Person {
    private String email;

    /**
     * Constructor for Client
     * @param id client id
     * @param name client name
     * @param phone client phone
     * @param email client email
     */
    public Client(String id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
    }

    /** @return email */
    public String getEmail() { return email; }
    /** @param email new email */
    public void setEmail(String email) { this.email = email; }

    /** @return role */
    @Override
    public String getRole() {
        return "Client";
    }
}