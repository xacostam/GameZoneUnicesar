/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

public class Seller extends Person {
    private String employeeCode;
    private String workShift;

    public Seller(String name, String identification, String phone,
                  String employeeCode, String workShift) {
        super(name, identification, phone);
        this.employeeCode = employeeCode;
        this.workShift = workShift;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }
    
    
}
