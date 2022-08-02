package com.revature.userInterface;

import java.util.Scanner;

import com.revature.businessLogic.BusinessLogic;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class Menu {
	
	private static Logger logger = new Logger();
	private static BusinessLogic bl = new BusinessLogic();
	
	public static void showWelcomeText() {
		System.out.println("======================================");
		System.out.println("Welcome to the PC Parts Emporium!");
		showAsciiArt();
		System.out.println("This app console will help with all your PC part(s) shopping needs, whether it's for building for upgrading a current system.");
		System.out.println("======================================\n");
	}
	
	public static void showAsciiArt() {
		System.out.println("                  .----.\r\n"
				+ "      .---------. | == |\r\n"
				+ "      |.-\"\"\"\"\"-.| |----|\r\n"
				+ "      ||       || | == |\r\n"
				+ "      ||       || |----|\r\n"
				+ "      |'-.....-'| |::::|\r\n"
				+ "      `\"\")---(\"\"` |___.|\r\n"
				+ "     /:::::::::::\\\" _  \"\r\n"
				+ "    /:::=======:::\\`\\`\\\r\n"
				+ "    `\"\"\"\"\"\"\"\"\"\"\"\"\"`  '-'");
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
				System.out.println("Feature Coming Soon!");
				break;
			case "x":
				System.out.println("Closing Store, Goodbye!");
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
				
				BusinessLogic.addCustomer(name, address, email);
				break;
			case "3":
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
				System.out.println("Feature Coming Soon!");
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
			System.out.println("[1] View inventory");
			System.out.println("[2] Replenish inventory");
			System.out.println("[x] Exit Order Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println("Feature Coming Soon!");
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

}
