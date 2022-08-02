package com.revature.models;

public class LineItems {
    
    // Fields
    private int id;
    private ProductPC product;
    private int quantity;
    
    // Constructor
    public LineItems(int id, ProductPC product, int quantity) {
    	this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and Setters
    public ProductPC getProduct() {
        return product;
    }

    public void setProduct(ProductPC product) {
        this.product = product;
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
		return "LineItems [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}
}
