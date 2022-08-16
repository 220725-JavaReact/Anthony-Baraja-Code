package com.revature.businessLogic;

import com.revature.dataAccessLogic.Dao;
import com.revature.dataAccessLogic.LineItemsDaoLogic;
import com.revature.dataAccessLogic.OrderLinkDaoLogic;
import com.revature.dataAccessLogic.OrdersDaoLogic;
import com.revature.dataAccessLogic.ProductPCDBDAO;
import com.revature.dataAccessLogic.StoreFrontDaoLogic;
import com.revature.models.Customer;
import com.revature.models.LineItems;
import com.revature.models.Order;
import com.revature.models.OrderLink;
import com.revature.models.ProductPC;
import com.revature.models.StoreFront;
import com.revature.userInterface.AsciiUI;
import com.revature.util.MyHashMap;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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
	private static OrdersDaoLogic orderDao = new OrdersDaoLogic();
	private static OrderLinkDaoLogic orderLinkDao = new OrderLinkDaoLogic();
	
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
	
	/**
	 * Return Customer's name by given customer's ID.
	 * @param customerId
	 * @return String name
	 */
	public String getCustomerNameById(int customerId) {
		return customerDao.get(customerId).getName();
	}
	
	/**
	 * Prints the Product details along with quantity amount with the proper response for low stock, to the console.
	 * @param productId
	 */
	public void printProductDetails(int productId) {
		ProductPC currentProduct = productDao.get(productId);
		LineItems currentLineItem = lineItemsDao.getByProdId(productId);
		
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Product: " + currentProduct.getName());
		System.out.println("Category: " + currentProduct.getCategory());
		System.out.println("Description: " + currentProduct.getDescription());
		System.out.println("Price: " + currentProduct.getPrice());
		
		if(currentLineItem.getQuantity() == 0) {
			System.out.println("Out of Stock");
		}else if (currentLineItem.getQuantity() == 1) {
			System.out.println("Only 1 Stock Left!!!");
		}else {
			System.out.println("Stock: " + currentLineItem.getQuantity());
		}
		
		System.out.println("----------------------------------------------------------");
	}
	
	/**
	 * Prints all the Products from the database. 
	 */
	public void printAllProducts() {
		for(ProductPC product: productDao.getAll()) {
			System.out.println(product);
		}
	}
	
	public void printAllProductsFormatted() {
		List<ProductPC> productsList = productDao.getAll();
		String prevProdName = "";
		String currentProdName = "";
		String prevProdType = "";
		String currentProdType = "";
		for(ProductPC product: productsList) {
			currentProdName = product.getName();
			if(!currentProdName.equals(prevProdName)) {
				
				prevProdName = currentProdName;
				currentProdType = product.getCategory();
				
				if(!currentProdType.equals(prevProdType)) {
					AsciiUI.printProductType(currentProdType);
				}
				
				System.out.println("----------------------------------------------------------");
				System.out.println(product.getName() + "  ||  Price: $" + getValueFormattedTwoDecimals(product.getPrice()));
				System.out.println("Overview: " + product.getDescription());
				System.out.println();
			}
			
			prevProdName = currentProdName;
			prevProdType = currentProdType;
		}
	}
	
	public void printAllProductsByStoreID(int store_id) {
		
		MyHashMap<Integer, ProductPC> storeIdMap = new MyHashMap<Integer, ProductPC>();
		int keyIndex = 1;
		
		for(ProductPC product: productDao.getAllByStoreId(store_id)) {
			//System.out.println("[" + product.getId() + "] " + product.getName());
			storeIdMap.put(keyIndex, product);
		}
	}
	
	/**
	 * Returns MyHashMap of ProductPCs by given store's ID.
	 * @param store_id
	 * @return
	 */
	public MyHashMap<Integer, ProductPC> mapProductsByStoreID(int store_id){
		MyHashMap<Integer, ProductPC> storeMap = new MyHashMap<Integer, ProductPC>();
		int keyIndex = 1;
		
		for(ProductPC product: productDao.getAllByStoreId(store_id)) {
			storeMap.put(keyIndex, product);
			keyIndex++;
		}
		
		return storeMap;
	}
	
	/**
	 * Prints to the console - Selections in order with the Product name and quantity amount.
	 * @param storeMap
	 */
	public void printAllProductsFromMap(MyHashMap<Integer, ProductPC> storeMap) {
		int storeSize = storeMap.size();
		String newProdType = "";
		String currentType = "";
		for(int index = 1; index <= storeSize; index++) {
			ProductPC currentProd = storeMap.get(index);
			int prodQty = lineItemsDao.get(currentProd.getId()).getQuantity();
			currentType = currentProd.getCategory();
			if(!currentType.equals(newProdType)) {
				AsciiUI.printProductType(currentType);
				newProdType = currentType;
			}
			String strStock = "  ||  Stock: ";
			if(prodQty == 0) {
				strStock = strStock + "OUT OF STOCK!";
			} else {
				strStock = strStock + prodQty + " left";
			}
			System.out.println("[" + index + "] " + currentProd.getName() + "  ||  Price: $" + currentProd.getPrice() +  strStock);
		}
	}
	
	public void printStoreFrontSelections() {
		for(StoreFront store: storeFrontDao.getAll()) {
			System.out.println("[" + store.getId() + "] " + store.getName());
		}
	}
	
	public boolean productSelectionIdIsValid(int userInput, int store_id) {
		//System.out.println(productDao.getAllProductStoreIdList(store_id));
		for(Integer product_id: productDao.getAllProductStoreIdList(store_id)) {
			if(userInput == product_id) {
				//System.out.println("User's product selection is valid: " + userInput);
				return true;
			}
		}
		
		return false;
	}
	
	public String getProductNameFromId(int userInput) {
		ProductPC product = productDao.get(userInput);
		return product.getName();
	}
	
	public int getLineItemIDFromProdId(int product_id) {
		LineItems lineItems = lineItemsDao.get(product_id);
		return lineItems.getId();
	}
	
	public int getLineItemQtyAmountFromProdId(int product_id) {
		int quantity = 0;
		
		LineItems lineItems = lineItemsDao.get(product_id);
		quantity = lineItems.getQuantity();
		
		return quantity;
	}
	
	public boolean checkUserQtyNotOverLineItemQtyLimit(int lineItemId, int qty) {
		LineItems currentLineItems = lineItemsDao.get(lineItemId);
		return qty < currentLineItems.getQuantity();
	}
	
	public boolean checkLineItemQtyAmountbyProdId(int product_id) {
		LineItems lineItems = lineItemsDao.get(product_id);
		return lineItems.getQuantity() != 0;
	}
	
	public void updateLineItemQuantity(int userQuantity, int product_id) {
		LineItems lineItem = lineItemsDao.get(product_id);
		lineItem.setQuantity(userQuantity);
		lineItemsDao.update(lineItem);
		
		ProductPC product = productDao.get(product_id);
		StoreFront store = storeFrontDao.get(product.getStoreId());
		System.out.println(product.getName() + " now has " + lineItem.getQuantity() + " in stock at " + store.getName());
	}
	
	public int setAndGetOrderData(int customerID, int storeID, int productID, int prodQty) {
		ProductPC currentProduct = productDao.get(productID);
		Double currentTotal = currentProduct.getPrice()*prodQty;
		
		orderLinkDao.save(new OrderLink(1, currentTotal));
		int currentOrderLink = orderLinkDao.getAll().size();
		
		LineItems currentLineItem = lineItemsDao.get(productID);
		int currentLineItemId = currentLineItem.getId();
		// Updating the inventory
		int currentLineItemQty = currentLineItem.getQuantity();
		currentLineItem.setQuantity(currentLineItemQty-prodQty);
		lineItemsDao.update(currentLineItem);
		
		orderDao.save(new Order(1, currentLineItemId, storeID, customerID, currentOrderLink, currentTotal));
		return orderDao.getAll().size();
	}
	
	public void printOrderDetails(int orderID) {
		Order currentOrder = orderDao.get(orderID);
		System.out.println("ORDER #" + currentOrder.getId());
		
		StoreFront currentStoreFront = storeFrontDao.get(currentOrder.getStore_id());
		System.out.println("STORE: " + currentStoreFront.getName() + "  ||  " + currentStoreFront.getAddress());
		
		LineItems currentLineItems = lineItemsDao.get(currentOrder.getLineItem_id());
		ProductPC currentProductPC = productDao.get(currentLineItems.getProductId());
		System.out.println("PC Component: " + currentProductPC.getCategory() + "  ||  " + currentProductPC.getName() + "  ||  qty:" + currentLineItems.getQuantity());
		
		System.out.println("Subtotal: " + currentOrder.getTotalPrice());
		
	}

	public void printOrderDetails(List<Order> currentOrdersList, ArrayList<Integer> orderQtyList) {
		
		int orderNumDisplay = orderLinkDao.getAll().size() + 1;
		System.out.println("ORDER #" + orderNumDisplay);
		
		int currentstoreFrontId = currentOrdersList.get(0).getStore_id();
		System.out.println("STORE: " + storeFrontDao.get(currentstoreFrontId).getName() + "  ||  " + storeFrontDao.get(currentstoreFrontId).getAddress());
		
		Double subTotal = 0.0;
		
		for(int i = 0; i < currentOrdersList.size(); i++) {
			System.out.println("----------------------------------------------------------");
			Order order = currentOrdersList.get(i);
			LineItems currentLineItem = lineItemsDao.get(order.getLineItem_id());
			ProductPC currentProductPC = productDao.get(currentLineItem.getProductId());
			int userQuantity = orderQtyList.get(i);
			Double currentLinePrice = currentProductPC.getPrice()*userQuantity;
			subTotal += currentLinePrice;
			System.out.println("PC Component: " + currentProductPC.getCategory() + "  ||  " + currentProductPC.getName() + "  ||  qty:" + userQuantity + "  ||  $" + currentLinePrice);
		}
		System.out.println("\nSubtotal = $" + subTotal);
		System.out.println("----------------------------------------------------------");
	}

	public List<Order> setTotalPriceToCurrentOrdersList(List<Order> currentOrdersList, int index, int userQuantity) {
		LineItems currentLineItem = lineItemsDao.get(currentOrdersList.get(index).getLineItem_id());
		ProductPC currentProduct = productDao.get(currentLineItem.getProductId());
		
		Double totalPrice = currentProduct.getPrice() * userQuantity;
		currentOrdersList.get(index).setTotalPrice(totalPrice);
		
		return currentOrdersList;
	}

	public void finalizeOrder(List<Order> currentOrdersList, ArrayList<Integer> orderQtyList) {
		System.out.println("Order record to database Started");
		Double grandTotal = 0.0;
		Double subTotal = 0.0;
		Double salesTax = 0.0;
		
		// Create order link record
		OrderLink currentOrderLink = new OrderLink(1, subTotal);
		orderLinkDao.save(currentOrderLink);
		int currentOrderLinkId = orderLinkDao.getAll().size();
		currentOrderLink = orderLinkDao.get(currentOrderLinkId);
		System.out.println("Current OrderLink Id: " + currentOrderLinkId);
		
		for(int i = 0; i < currentOrdersList.size(); i++) {
			Order order = currentOrdersList.get(i);
			
			order.setOrder_link(currentOrderLinkId);
			System.out.println(order);
			orderDao.save(order);
			System.out.println("   Order saved to database successfully");
			
			subTotal += order.getTotalPrice();
			salesTax = getLocationSaleTax(order);
			
			// Update line item product stock
			LineItems currentLineItem = lineItemsDao.get(order.getLineItem_id());
			System.out.println("Before LineItem update: " + currentLineItem);
			int newQtyAmount = currentLineItem.getQuantity() - orderQtyList.get(i); 
			currentLineItem.setQuantity(newQtyAmount);
			System.out.println("   After LineItem update: " + currentLineItem);
			lineItemsDao.update(currentLineItem);
		}
		
		// Calculate Grand Total
		System.out.println("Subtotal = $" + subTotal);
		double salesTaxValue = salesTax / 100 * subTotal;
		double salesTaxValueFrmt = getValueFormattedTwoDecimals(salesTaxValue);
		System.out.println("Sales Tax = $" + salesTaxValueFrmt);
		grandTotal = salesTaxValueFrmt + subTotal;
		double grandTotalFrmt = getValueFormattedTwoDecimals(grandTotal);
		System.out.println("Grand Total = $" + grandTotalFrmt);
		
		// Update order link record with calculated Grand Total
		System.out.println("Before Order Link update: " + currentOrderLink);
		currentOrderLink.setSubTotal(grandTotalFrmt);
		System.out.println("After Order Link update: " + currentOrderLink);
		orderLinkDao.update(currentOrderLink);		
		
		System.out.println("Order record to database submitted successfully!");
	}
	
	/**
	 * Returns the sales tax rate according to location from given order.
	 * @param order
	 * @return Double Sales Tax Rate
	 */
	public Double getLocationSaleTax(Order order) {
		Double salesTax = 0.0;
		StoreFront currentStore = storeFrontDao.get(order.getStore_id());
		String currentAddress = currentStore.getAddress();
		
		if (currentAddress.contains("San Fernando")) {
			salesTax = 10.250;
		}else if (currentAddress.contains("Los Angeles")) {
			salesTax = 9.500;
		}else if (currentAddress.contains("San Diego")) {
			salesTax = 7.750;
		}else if (currentAddress.contains("Venice")) {
			salesTax = 9.500;
		}
		
		return salesTax;
	}
	
	/**
	 * Returns double formatted by 2 decimal places.
	 * @param value
	 * @return Double
	 */
	public Double getValueFormattedTwoDecimals(Double value) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		String strResult = formatter.format(value);
		return Double.parseDouble(strResult);
	}

}
