package com.revature.userInterface;

import java.util.Scanner;

import com.revature.businessLogic.BusinessLogic;

public class OrderUI {
	
	private static BusinessLogic bl = new BusinessLogic();
	
	public void placeOrderStart(Scanner sc) {
		
		// Get User Inputs
		System.out.println("======================================");
		System.out.println("Select Customer: ");
		bl.printAllCustomerSelections();
		String customerId = sc.nextLine();
		int customerIdInt = Integer.parseInt(customerId);
		
		System.out.println();

		System.out.println("======================================");
		System.out.println("Select Store Front: ");
		bl.printStoreFrontSelections();
		String storeId = sc.nextLine();
		int storeIdInt = Integer.parseInt(storeId);
		
		System.out.println();

		System.out.println("======================================");
		System.out.println("Select Product: ");
		bl.printAllProductsByStoreID(storeIdInt);
		String productId = sc.nextLine();
		int productIdInt = Integer.parseInt(productId);
		
		System.out.println();
		
		System.out.println("======================================");
		System.out.println("Enter Quantity Amount of Product: ");
		int userQuantity = sc.nextInt();
		
		System.out.println();
		
		// Display Results
		System.out.println("======================================");
		System.out.println("PLACE HOLDER, FEATURE COMING SOON I SWEAR!!!");
		System.out.println("======================================");
		System.out.println("customerIdInt: " + customerIdInt + "\nstoreIdInt: " + storeIdInt + "\nproductIdInt: " + productIdInt + "\nuserQuantity: " + userQuantity);
		
		
		
	}

}
