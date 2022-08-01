package com.revature.models;

public class CoreComponents {
	
	// Field Variables
	private String name;
	private Double price;
	
	// Constructors
	public CoreComponents(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public CoreComponents() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
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
		return "CoreComponents [name=" + name + ", price=" + price + "]";
	}

}
