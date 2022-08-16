package com.revature.models;

public class ProductPC {
	
	// Field
	private int id;
	private int storeId;
	private String name;
	private Double price;
	private String description;
	private String category;
	
	// Constructors
	public ProductPC(int id, int storeId, String name, Double price, String description, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.storeId = storeId;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		String display = String.format("ProductPC: id = %3d\n   storeId = %3d\n   name = %20s\n   price = %20f\n   description = %50s\n   category = %20s", id, storeId, name, price, description, category);
		return display;
		/*
		return "ProductPC [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", category=" + category + ", storeId=" + storeId + "]";
				*/
	}
	
}
