package com.revature.models;

public class OrderLink {
	
	// Fields
	private int id;
	private Double subTotal;
	
	// Constructor
	public OrderLink(int id, Double subTotal) {
		super();
		this.id = id;
		this.subTotal = subTotal;
	}
	
	// Setters and Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	/**
	 * Prints the OrderLink Fields to the console. 
	 */
	@Override
	public String toString() {
		return "OrderLink [id=" + id + ", subTotal=" + subTotal + "]";
	}
}
