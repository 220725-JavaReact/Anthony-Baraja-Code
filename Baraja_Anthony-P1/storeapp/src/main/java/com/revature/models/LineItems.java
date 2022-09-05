package com.revature.models;

public class LineItems {
    
    // Fields
    private int id;
    private int product_id;
    private int quantity;
    
    // Constructor
    public LineItems(int id, int product_id, int quantity) {
    	this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and Setters
    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	// To String Method
    @Override
	public String toString() {
		return "LineItems [id=" + id + ", product_id=" + product_id + ", quantity=" + quantity + "]";
	}
}
