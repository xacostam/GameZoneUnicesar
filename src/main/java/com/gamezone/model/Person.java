package com.gamezone.model;

/**
 * Abstract class for Person
 */
public abstract class Person {
    private String id;
    private String name;
    private String phone;

    /**
     * Constructor for Person
     * @param id person id
     * @param name person name
     * @param phone person phone
     */
    public Person(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    /** @return id */
    public String getId() { return id; }
    /** @param id new id */
    public void setId(String id) { this.id = id; }

    /** @return name */
    public String getName() { return name; }
    /** @param name new name */
    public void setName(String name) { this.name = name; }

    /** @return phone */
    public String getPhone() { return phone; }
    /** @param phone new phone */
    public void setPhone(String phone) { this.phone = phone; }

    /** @return role string */
    public abstract String getRole();

    public Person() {
    }
    
}
