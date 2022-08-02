package com.revature.models;

import java.util.List;

public class Customer {
    
	// Fields
    private int id;
    private String name;
    private String address;
    private String email;
    private List<Order> ordersList;
    
    // Constructor
    public Customer(int id, String name, String address, String email, List<Order> ordersList) {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.ordersList = ordersList;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    // To String Method
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", ordersList="
                + ordersList + "]";
    }
}
