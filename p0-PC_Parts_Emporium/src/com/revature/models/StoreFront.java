package com.revature.models;

public class StoreFront {

    // Fields
    private int id;
    private String name;
    private String address;
    
    // Constructor
    public StoreFront(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

	// To String
    @Override
	public String toString() {
		return "StoreFront [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
