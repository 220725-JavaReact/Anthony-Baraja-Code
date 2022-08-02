package com.revature.dataAccessLogic;

import java.util.ArrayList;
import java.util.List;
import com.revature.models.ProductPC;

public class ProductPCDaoLogic implements Dao<ProductPC> {
	
	// Fields
	List<ProductPC> ProductPC;

	public ProductPCDaoLogic() {
		
		this.ProductPC = new ArrayList<ProductPC>();
		
		// Hard coded data, need to replace with data source
		this.ProductPC.add(new ProductPC(0, "Intel Core i7-9000K", 299.99));
		this.ProductPC.add(new ProductPC(1, "ASUS B550-A ATX Motherboard", 189.99));
		this.ProductPC.add(new ProductPC(2, "Corsair Viper 32GB RAM", 145.99));
		this.ProductPC.add(new ProductPC(3, "EVGA NVIDIA GeForce RTX Graphics Card", 739.99));
		this.ProductPC.add(new ProductPC(4, "Samsung 950 Pro SSD", 149.99));
		this.ProductPC.add(new ProductPC(5, "Montech X3 Tempered Glass Mid-Tower Computer Case", 67.99));
		this.ProductPC.add(new ProductPC(6, "Cooler Master Hyper 212 CPU Air Cooler", 61.99));
		this.ProductPC.add(new ProductPC(7, "ASUS XONAR 5.1 Channel PCIe Sound Card", 48.99));
	}

	// CRUD Methods
	@Override
	public ProductPC get(int id) {
		// TODO Auto-generated method stub
		return this.ProductPC.get(id);
	}

	@Override
	public List<ProductPC> getAll() {
		// TODO Auto-generated method stub
		return this.ProductPC;
	}

	@Override
	public void save(ProductPC t) {
		// TODO Auto-generated method stub
		ProductPC newProduct = new ProductPC(t.getId(), t.getName(), t.getPrice());
		this.ProductPC.add(newProduct);
		System.out.println("Product: " + t.getName() + " saved successfully");
	}

	@Override
	public void update(ProductPC t) {
		int tId = t.getId();
		this.ProductPC.get(tId).setId(tId);
		this.ProductPC.get(tId).setName(t.getName());
		this.ProductPC.get(tId).setPrice(t.getPrice());
		
		System.out.println("Product ID " + tId + ", updated in the database");
	}

	@Override
	public void delete(ProductPC t) {
		this.ProductPC.remove(t.getId());
		System.out.println("Product ID " + t.getId() + ", deleted from the database");
	}

}
