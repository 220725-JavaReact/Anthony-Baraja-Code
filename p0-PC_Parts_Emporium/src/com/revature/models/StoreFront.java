package com.revature.models;

import java.util.List;

public class StoreFront {

    // Fields
    private int id;
    private String name;
    private String address;
    private List<ProductPC> productsList;
    private List<Order> ordersList;
    
    // Constructor
    public StoreFront(int id, String name, String address, List<ProductPC> productsList, List<Order> ordersList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.productsList = productsList;
        this.ordersList = ordersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and Setters
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

    public List<ProductPC> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductPC> productsList) {
        this.productsList = productsList;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }
}
