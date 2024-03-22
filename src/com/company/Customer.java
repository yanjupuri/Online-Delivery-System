package com.company;

import java.util.Date;

public class Customer extends WebUser {
    private String customerName = "--name required--";
    private int customerId = 0;


    public Customer(String customerName, int customerId, String password, Date registerDate){
        super(customerName, password, registerDate);
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void displayInformation(){
        System.out.println("Username: " + getCustomerName());
        System.out.println("Password: " + getPassword());
        System.out.println("User ID: " + getCustomerId());
        System.out.println("Registered date: " + getRegisterDate());
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerId() {
        return customerId;
    }
}
