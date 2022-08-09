package com.revature.businessLogic;

import com.revature.dataAccessLogic.Dao;
import com.revature.dataAccessLogic.LineItemsDaoLogic;
import com.revature.dataAccessLogic.ProductPCDBDAO;
import com.revature.dataAccessLogic.StoreFrontDaoLogic;
import com.revature.models.Customer;
import com.revature.models.LineItems;
import com.revature.models.ProductPC;
import com.revature.models.StoreFront;
import com.revature.dataAccessLogic.CustomerDBDAOLogic;

public class BusinessLogic {
	
	//static ProductPCDaoLogic productPCDL;
	//static LineItemsDaoLogic lineItemsDL;
	//static OrdersDaoLogic ordersDL;
	//static StoreFrontDaoLogic storeFrontDL;
	//static CustomerDaoLogic customerDL;
	
	//private static Dao<ProductPC> productDao = new ProductPCDBDAO();
	private static ProductPCDBDAO productDao = new ProductPCDBDAO();
	private static LineItemsDaoLogic lineItemsDao = new LineItemsDaoLogic();
	private static Dao<StoreFront> storeFrontDao = new StoreFrontDaoLogic();
	//private static Dao<Customer> customerDao = new CustomerDBDAOLogic();
	private static CustomerDBDAOLogic customerDao = new CustomerDBDAOLogic();
	
	// Business Logic Functionalities
	
	public static void addCustomer(String name, String address, String email, String phone) {
		
		// Generate an ID for new customer
		int newId = customerDao.getAll().size() + 1;
		Customer newCustomer= new Customer(newId, name, address, email, phone);
		customerDao.save(newCustomer);
	}
	
	public void printAllCustomers() {
		for(Customer customer: customerDao.getAll()){
			System.out.println(customer);
		}
	}
	
	public void printAllCustomerSelections() {
		for(Customer customer: customerDao.getAll()){
			System.out.println("[" + customer.getId() + "] " + customer.getName());
		}
	}
	
	public void printCustomerByName(String name) {
		Customer fetchedCustomer = customerDao.getCustomerByName(name);
		if(fetchedCustomer == null) {
			System.out.println("No Customer was found.");
		}else {
			System.out.println(fetchedCustomer);
		}
	}
	
	public void printAllProducts() {
		for(ProductPC product: productDao.getAll()) {
			System.out.println(product);
		}
	}
	
	public void printAllProductsByStoreID(int store_id) {
		for(ProductPC product: productDao.getAllByStoreId(store_id)) {
			//System.out.println(product);
			System.out.println("[" + product.getId() + "] " + product.getName());
		}
	}
	
	public void printStoreFrontSelections() {
		for(StoreFront store: storeFrontDao.getAll()) {
			System.out.println("[" + store.getId() + "] " + store.getName());
		}
	}
	
	public boolean productSelectionIdIsValid(int userInput, int store_id) {
		System.out.println(productDao.getAllProductStoreIdList(store_id));
		for(Integer product_id: productDao.getAllProductStoreIdList(store_id)) {
			if(userInput == product_id) {
				System.out.println("User's product selection is valid: " + userInput);
				return true;
			}
		}
		
		return false;
	}
	
	public String getProductNameFromId(int userInput) {
		ProductPC product = productDao.get(userInput);
		return product.getName();
	}
	
	public int getLineItemQtyAmountFromProdId(int product_id) {
		int quantity = 0;
		
		LineItems lineItems = lineItemsDao.get(product_id);
		quantity = lineItems.getQuantity();
		
		return quantity;
	}
	
	public void updateLineItemQuantity(int userQuantity, int product_id) {
		LineItems lineItem = lineItemsDao.get(product_id);
		lineItem.setQuantity(userQuantity);
		lineItemsDao.update(lineItem);
		
		ProductPC product = productDao.get(product_id);
		StoreFront store = storeFrontDao.get(product.getStoreId());
		System.out.println(product.getName() + " now has " + lineItem.getQuantity() + " in stock at " + store.getName());
	}
	
	
	// Helper Functions

}
