package com.revature.dataAccessLogic;

import java.util.ArrayList;
import java.util.List;
import com.revature.models.LineItems;

public class LineItemsDaoLogic implements Dao<LineItems> {
	
	// Fields
	List<LineItems> lineItemsList;
	static ProductPCDaoLogic products;
	
	// Constructor
	public LineItemsDaoLogic() {
		this.lineItemsList = new ArrayList<LineItems>();
		
		this.lineItemsList.add(new LineItems(0, products.get(0), 15));
		this.lineItemsList.add(new LineItems(1, products.get(1), 8));
		this.lineItemsList.add(new LineItems(2, products.get(2), 23));
		this.lineItemsList.add(new LineItems(3, products.get(3), 7));
		this.lineItemsList.add(new LineItems(4, products.get(4), 4));
		this.lineItemsList.add(new LineItems(5, products.get(5), 8));
	}

	// CRUD Methods
	@Override
	public LineItems get(int id) {
		return this.lineItemsList.get(id);
	}

	@Override
	public List<LineItems> getAll() {
		return this.lineItemsList;
	}

	@Override
	public void save(LineItems t) {
		LineItems newLineItems = new LineItems(t.getId(), t.getProduct(), t.getQuantity());
        this.lineItemsList.add(newLineItems);
    	System.out.println("LineItems ID: " + t.getId() + " saved successfully");

	}

	@Override
	public void update(LineItems t) {
		int tId = t.getId();
    	this.lineItemsList.get(tId).setId(tId);
    	this.lineItemsList.get(tId).setProduct(t.getProduct());
    	this.lineItemsList.get(tId).setQuantity(t.getQuantity());
    	
		System.out.println("LineItems ID " + tId + ", updated in the database");

	}

	@Override
	public void delete(LineItems t) {
		this.lineItemsList.remove(t.getId());
        System.out.println("LineItems ID " + t.getId() + ", deleted from the database");

	}

}
