package com.gamezone.model;

/**
 * Class for Seller
 */
public class Seller extends Person {
    private String employeeCode;
    private String shift;

    /**
     * Constructor for Seller
     * @param id seller id
     * @param name seller name
     * @param phone seller phone
     * @param employeeCode seller code
     * @param shift seller shift
     */
    public Seller(String id, String name, String phone, String employeeCode, String shift) {
        super(id, name, phone);
        this.employeeCode = employeeCode;
        this.shift = shift;
    }

    /** @return employeeCode */
    public String getEmployeeCode() { return employeeCode; }
    /** @param employeeCode new code */
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

    /** @return shift */
    public String getShift() { return shift; }
    /** @param shift new shift */
    public void setShift(String shift) { this.shift = shift; }

    /** @return role */
    @Override
    public String getRole() {
        return "Seller";
    }
}