package com.revature.dataAccessLogic;

import java.util.ArrayList;
import java.util.List;
import com.revature.models.Customer;
import com.revature.models.Order;

public class CustomerDaoLogic implements Dao<Customer> {
	
	// Fields
	List<Customer> CustomersList;
	static OrdersDaoLogic orders;

    // Constructor
	public CustomerDaoLogic() {
		
		this.CustomersList = new ArrayList<Customer>();
		
		// to help with database initializing
		List<Order> orderList0 = new ArrayList<Order>();
		orderList0.add(orders.get(0));
		List<Order> orderList1 = new ArrayList<Order>();
		orderList1.add(orders.get(1));
		
		// Hard coded data, need to replace with data source
		this.CustomersList.add(new Customer(0, "Anthony", "1234 Main St.", "anthony9000@hotmail.com", orderList0));
		this.CustomersList.add(new Customer(1, "Kyle", "452 Fake St.", "kyleOne@gmail.com", orderList1));
		this.CustomersList.add(new Customer(2, "Foxxy", "246 Real St.", "foxxyRoxxy@aol.com", null));
	}

	// CRUD Methods
	@Override
    public Customer get(int id) {
		return this.CustomersList.get(id);
    }

    @Override
    public List<Customer> getAll() {
        // Retrieve all Customers from the Data Source
        return this.CustomersList;
    }

    @Override
    public void save(Customer t) {
    	Customer newCustomer = new Customer(t.getId(), t.getName(), t.getAddress(), t.getEmail(), t.getOrdersList());
        this.CustomersList.add(newCustomer);
        // no return needed, print a success message if you want
    	System.out.println("Customer: " + t.getName() + " saved successfully");
    }

    @Override
    public void update(Customer t) {
    	int tId = t.getId();
    	this.CustomersList.get(tId).setId(tId);
    	this.CustomersList.get(tId).setName(t.getName());
    	this.CustomersList.get(tId).setAddress(t.getAddress());
    	this.CustomersList.get(tId).setEmail(t.getEmail());
    	this.CustomersList.get(tId).setOrdersList(t.getOrdersList());
    	
		System.out.println("Customer ID " + tId + ", updated in the database");
        
    }

    @Override
    public void delete(Customer t) {
        this.CustomersList.remove(t.getId());
        System.out.println("Customer ID " + t.getId() + ", deleted from the database");
    }
    
}
