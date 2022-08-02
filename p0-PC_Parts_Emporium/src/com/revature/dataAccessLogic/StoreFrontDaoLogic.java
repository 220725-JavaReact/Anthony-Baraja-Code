package com.revature.dataAccessLogic;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Order;
import com.revature.models.ProductPC;
import com.revature.models.StoreFront;

public class StoreFrontDaoLogic implements Dao<StoreFront> {
	
	// Fields
	List<StoreFront> StoreFrontList;
	static ProductPCDaoLogic prodPCs;
	static OrdersDaoLogic orders;
	
	public StoreFrontDaoLogic() {
		this.StoreFrontList = new ArrayList<StoreFront>();
		
		// to help with database initializing
		List<ProductPC> prodPCList0 = new ArrayList<ProductPC>();
		prodPCList0.add(prodPCs.get(0));
		prodPCList0.add(prodPCs.get(2));
		prodPCList0.add(prodPCs.get(4));
		List<ProductPC> prodPCList1 = new ArrayList<ProductPC>();
		prodPCList1.add(prodPCs.get(1));
		prodPCList1.add(prodPCs.get(3));
		prodPCList1.add(prodPCs.get(5));
		
		List<Order> orderList0 = new ArrayList<Order>();
		orderList0.add(orders.get(0));
		List<Order> orderList1 = new ArrayList<Order>();
		orderList1.add(orders.get(1));
		
		this.StoreFrontList.add(new StoreFront(0, "PC Emporium - Los Angeles", "437 Wilshire Blvd", prodPCList0, orderList0));
		this.StoreFrontList.add(new StoreFront(1, "PC Emporium - Phoenix", "789 Heats Avenue", prodPCList1, orderList1));
	}

	@Override
	public StoreFront get(int id) {
		return this.StoreFrontList.get(id);
	}

	@Override
	public List<StoreFront> getAll() {
		return this.StoreFrontList;
	}

	@Override
	public void save(StoreFront t) {
		StoreFront newStoreFront = new StoreFront(t.getId(), t.getName(), t.getAddress(), t.getProductsList(), t.getOrdersList());
        this.StoreFrontList.add(newStoreFront);
    	System.out.println("StoreFront ID: " + t.getId() + " saved successfully");
	}

	@Override
	public void update(StoreFront t) {
		int tId = t.getId();
    	this.StoreFrontList.get(tId).setId(tId);
    	this.StoreFrontList.get(tId).setName(t.getName());
    	this.StoreFrontList.get(tId).setAddress(t.getAddress());
    	this.StoreFrontList.get(tId).setProductsList(t.getProductsList());
    	this.StoreFrontList.get(tId).setOrdersList(t.getOrdersList());
    	
		System.out.println("StoreFront ID " + tId + ", updated in the database");
		
	}

	@Override
	public void delete(StoreFront t) {
		this.StoreFrontList.remove(t.getId());
		System.out.println("StoreFront ID " + t.getId() + ", deleted from the database");
		
	}

}
