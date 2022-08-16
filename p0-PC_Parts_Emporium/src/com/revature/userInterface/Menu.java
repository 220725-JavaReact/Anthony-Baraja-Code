package com.revature.userInterface;

import java.util.Scanner;

import com.revature.businessLogic.BusinessLogic;
import com.revature.models.ProductPC;
import com.revature.util.Logger;
import com.revature.util.MyHashMap;
import com.revature.util.Logger.LogLevel;

public class Menu {
	
	private static Logger logger = new Logger();
	private static BusinessLogic bl = new BusinessLogic();
	private static OrderUI orderUI = new OrderUI();
	private static StoreFrontInventoryUI storeUI = new StoreFrontInventoryUI();
	
	public static void showWelcomeText() {
		System.out.println("======================================");
		System.out.println("Welcome to the PC Parts Emporium!");
		AsciiUI.printComputerArt();
		System.out.println("This Store Console App will help with all your PC part(s) shopping needs, whether it's for building for upgrading a current system.");
		System.out.println("======================================\n");
	}
	
	/**
	 * Display Menu, execute options
	 */
	public static void presentMenu() {		
		
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		
		// menu interface
		// while the userInput is not "x" we loop, we present the menu again
		do {
			System.out.println("======================================");
			System.out.println("Main Menu");
			System.out.println("======================================");
			System.out.println("[1] Customer Query");
			System.out.println("[2] Order");
			System.out.println("[3] Inventory");
			System.out.println("[x] Exit Store");
			
			userInput = scanner.nextLine();
			
			//Logger.writeToFile("User input the following: " + userInput);
			logger.log(LogLevel.info, userInput);
			
			switch(userInput) {
			case "1":
				presentCustomerQueryMenu(scanner);
				break;
			case "2":
				presentOrderMenu(scanner);
				break;
			case "3":
				presentInventoryMenu(scanner);
				break;
			case "x":
				System.out.println("Closing Store Console App, Goodbye!");
				scanner.close();
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while(!(userInput.equals("x")));
		
	}
	
	// Display Customer Query Menu, execute options
	public static void presentCustomerQueryMenu(Scanner sc) {
		
		String userInput = "";
		
		do {
			System.out.println("======================================");
			System.out.println("Customer Query Menu");
			System.out.println("======================================");
			System.out.println("[1] View all customers");
			System.out.println("[2] Add customer");
			System.out.println("[3] Search for a customer");
			System.out.println("[x] Exit Customer Query Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				bl.printAllCustomers();
				break;
			case "2":
				System.out.println("Enter new customer name: ");
				String name = sc.nextLine();

				System.out.println("Enter new customer address: ");
				String address = sc.nextLine();

				System.out.println("Enter new customer email: ");
				String email = sc.nextLine();
				
				System.out.println("Enter new customer phone number, no hyphens (-): ");
				String phone = sc.nextLine();
				
				BusinessLogic.addCustomer(name, address, email, phone);
				break;
			case "3":
				//System.out.println("Feature Coming Soon!");
				System.out.println("Enter customer name: ");
				String nameInput = sc.nextLine();
				bl.printCustomerByName(nameInput);				
				break;
			case "x":
				System.out.println("Returning to Main Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
		
	}
	
	// Display Order Menu, execute options
	public static void presentOrderMenu(Scanner sc) {
		
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("Order Menu");
			System.out.println("======================================");
			System.out.println("[1] Place order");
			System.out.println("[2] View order history");
			System.out.println("[x] Exit Order Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				orderUI.placeOrderStart(sc);
				break;
			case "2":
				System.out.println("Feature Coming Soon!");
				break;
			case "x":
				System.out.println("Returning to Main Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
		
	}
	
	// Display Inventory Menu, execute options
	public static void presentInventoryMenu(Scanner sc) {
		
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("Inventory Menu");
			System.out.println("======================================");
			System.out.println("[1] View Inventory");
			System.out.println("[2] View Store Front Inventory");
			System.out.println("[3] Replenish Inventory");
			System.out.println("[x] Exit Order Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				bl.printAllProductsFormatted();
				break;
			case "2":
				storeUI.StoreFrontMenu(sc);
				break;
			case "3":
				presentStoreFrontSelections(sc);
				break;
			case "x":
				System.out.println("Returning to Main Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
		
	}
	
	// Prompt Store Front List, for Replenish Inventory functionality  
	public static void presentStoreFrontSelections(Scanner sc) {
		String userInput = "";
		int userProdSelect = 0;
		
		do {
			System.out.println("======================================");
			System.out.println("Store Front Selections");
			System.out.println("======================================");
			
			bl.printStoreFrontSelections();
			System.out.println("[x] Return to Main Menu");
			
			userInput = sc.nextLine(); // user made a store selection, userInput = id
			if(userInput.equals("x")) break;
			try {
				userProdSelect = Integer.parseInt(userInput);
				presentProductSelectionsPerLocation(sc, userProdSelect);
				return;
			} catch (NumberFormatException e) {
				System.out.println("Not a number, please try again");
			}

		} while (!(userInput.equals("x")));
	}
	
	public static void presentProductSelectionsPerLocation(Scanner sc, int store_id) {
		String userInput = "";
		int userProdSelect = 0;
		
		do {
			System.out.println("======================================");
			System.out.println("Product Selection Available at this Location");
			System.out.println("======================================");
			
			//bl.printAllProductsByStoreID(store_id);
			
			MyHashMap<Integer, ProductPC> storeMap = bl.mapProductsByStoreID(store_id);
			bl.printAllProductsFromMap(storeMap);
			
			System.out.println("[x] Return to Store Front Selections");
			
			userInput = sc.nextLine(); // user made a store selection, userInput = id
			if(!(userInput.equals("x"))){
				userProdSelect = Integer.parseInt(userInput);
				
				if(bl.productSelectionIdIsValid(userProdSelect, store_id)) {
					presentProductQuantityPromptForUpdate(sc, store_id, userProdSelect);
					return;
				} else {
					System.out.println("Not valid product selection, please choose another option");
				}
			}
			
		} while (!(userInput.equals("x")));
	}
	
	public static void presentProductQuantityPromptForUpdate(Scanner sc, int store_id, int product_id) {
		String userInput = "";
		int userQtyAmount = 0;
		
		do {
			System.out.println("======================================");
			System.out.println("Adjust Quantity Amount for " + bl.getProductNameFromId(product_id));
			System.out.println("======================================");
			
			System.out.println("Currently Quantity = " + bl.getLineItemQtyAmountFromProdId(product_id));
			System.out.println("Enter the adjusted value:");
			
			userInput = sc.nextLine();
			try {
				userQtyAmount = Integer.parseInt(userInput);
				bl.updateLineItemQuantity(userQtyAmount, product_id);
				return;
			} catch (NumberFormatException e) {
				System.out.println("Not a number, please try again");
			}
			
		} while (!(userInput.equals("x")));
	}

}
