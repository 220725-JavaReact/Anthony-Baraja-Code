package com.revature.businessLogic;

import com.revature.dataAccessLogic.CustomerDaoLogic;
import com.revature.dataAccessLogic.LineItemsDaoLogic;
import com.revature.dataAccessLogic.OrdersDaoLogic;
import com.revature.dataAccessLogic.ProductPCDaoLogic;
import com.revature.dataAccessLogic.StoreFrontDaoLogic;
import com.revature.models.Customer;

public class BusinessLogic {
	
	static ProductPCDaoLogic productPCDL;
	static LineItemsDaoLogic lineItemsDL;
	static OrdersDaoLogic ordersDL;
	static StoreFrontDaoLogic storeFrontDL;
	static CustomerDaoLogic customerDL;
	
	public BusinessLogic() {
		productPCDL = new ProductPCDaoLogic();
		lineItemsDL = new LineItemsDaoLogic();
		ordersDL = new OrdersDaoLogic();
		storeFrontDL = new StoreFrontDaoLogic();
		customerDL = new CustomerDaoLogic();
	}
	
	// Business Logic Functionalities
	
	public static void addCustomer(String name, String address, String email) {
		
		// Generate an ID for new customer
		int newId = customerDL.getAll().size() + 1;
		Customer newCustomer= new Customer(newId, name, address, email, null);
		customerDL.save(newCustomer);
	}
	
	public void printAllCustomers() {
		for(Customer customer: customerDL.getAll()){
			System.out.println(customer);
		}
	}
	
	
	// Helper Functions

}
