package com.revature.models;

public class ProductPC {
	
	// Field
	private int id;
	private String name;
	private Double price;
	
	// Constructors
	public ProductPC(int id, String name, double price) {
		this.setId(id);
		this.name = name;
		this.price = price;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	// To String for Display
	@Override
	public String toString() {
		return "CoreComponents [id="+ id + ", name=" + name + ", price=" + price + "]";
	}
}
