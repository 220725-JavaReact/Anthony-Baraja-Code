package com.revature.models;

import java.util.List;

public class Order {
    
    // Fields
	private int id;
    private List<LineItems> lineItemsList;
    private int storeId;
    private Double totalPrice;

    // Constructor
    public Order(int id, List<LineItems> lineItemsList, int storeId, Double totalPrice) {
    	this.setId(id);
        this.lineItemsList = lineItemsList;
        this.storeId = storeId;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public List<LineItems> getLineItemsList() {
        return lineItemsList;
    }
    public void setLineItemsList(List<LineItems> lineItemsList) {
        this.lineItemsList = lineItemsList;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// To String Method
	@Override
	public String toString() {
		return "Order [id=" + id + ", lineItemsList=" + lineItemsList + ", storeId=" + storeId + ", totalPrice="
				+ totalPrice + "]";
	}
}
