package com.revature.dataAccessLogic;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.LineItems;
import com.revature.models.Order;

public class OrdersDaoLogic implements Dao<Order> {
	
	// Fields
	List<Order> OrdersList;
	static LineItemsDaoLogic lineItems;
	
	public OrdersDaoLogic() {
		this.OrdersList = new ArrayList<Order>();
		
		// to help with database initializing
		List<LineItems> lineItems0 = new ArrayList<LineItems>();
		lineItems0.add(lineItems.get(0));
		lineItems0.add(lineItems.get(3));
		List<LineItems> lineItems1 = new ArrayList<LineItems>();
		lineItems1.add(lineItems.get(1));
		lineItems1.add(lineItems.get(2));
		lineItems1.add(lineItems.get(4));
		
		this.OrdersList.add(new Order(0, lineItems0, 0, 345.99));
		this.OrdersList.add(new Order(1, lineItems1, 1, 599.99));
	}

	@Override
	public Order get(int id) {
		return this.OrdersList.get(id);
	}

	@Override
	public List<Order> getAll() {
		return this.OrdersList;
	}

	@Override
	public void save(Order t) {
		Order newOrdersList = new Order(t.getId(), t.getLineItemsList(), t.getStoreId(), t.getTotalPrice());
		this.OrdersList.add(newOrdersList);
		System.out.println("OrdersList ID: " + t.getId() + " saved successfully");
		
	}

	@Override
	public void update(Order t) {
		int tId = t.getId();
		this.OrdersList.get(tId).setId(tId);
		this.OrdersList.get(tId).setLineItemsList(t.getLineItemsList());
		this.OrdersList.get(tId).setStoreId(t.getStoreId());
		this.OrdersList.get(tId).setTotalPrice(t.getTotalPrice());
		
		System.out.println("OrdersList ID " + tId + ", updated in the database");	
	}

	@Override
	public void delete(Order t) {
		this.OrdersList.remove(t.getId());
		System.out.println("OrdersList ID " + t.getId() + ", deleted from the database");
		
	}

}
