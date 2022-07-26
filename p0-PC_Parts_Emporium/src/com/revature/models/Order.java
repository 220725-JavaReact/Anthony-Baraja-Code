package com.revature.models;

public class Order {
    
    // Fields
	private int id;
	private int lineItem_id;
    private int store_id;
	private int customer_id;
	private int order_link;
    private Double totalPrice;

    // Constructor
    public Order(int id, int lineItem_id, int store_id, int customer_id, int order_link, Double totalPrice) {
		this.id = id;
		this.lineItem_id = lineItem_id;
		this.store_id = store_id;
		this.customer_id = customer_id;
		this.order_link = order_link;
		this.totalPrice = totalPrice;
	}

    // Getters and Setters
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLineItem_id() {
		return lineItem_id;
	}

	public void setLineItem_id(int lineItem_id) {
		this.lineItem_id = lineItem_id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public int getOrder_link() {
		return order_link;
	}

	public void setOrder_link(int order_link) {
		this.order_link = order_link;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	// To String Method
	@Override
	public String toString() {
		return "Order [id=" + id + ", lineItem_id=" + lineItem_id + ", store_id=" + store_id + ", customer_id="
				+ customer_id + ", order_link=" + order_link + ", totalPrice=" + totalPrice + "]";
	}
}
