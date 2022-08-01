package com.revature.userInterface;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.CoreComponents;
import com.revature.util.Logger;
import com.revature.util.Logger.LogLevel;

public class Menu {
	
	private static Logger logger = new Logger();
	
	public static void showWelcomeText() {
		System.out.println("======================================");
		
		System.out.println("Welcome to the PC Warehouse Store!");
		
		System.out.println("======================================");
	}
	
	public static void presentMenu() {
		
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		
		// Starting PC Parts List
		ArrayList<CoreComponents> drinkList = new ArrayList<CoreComponents>();
		drinkList.add(new CoreComponents("Intel Core i9", 349.99));
		drinkList.add(new CoreComponents("Asus AM4 ATX Motherboard", 203.99));
		drinkList.add(new CoreComponents("Corsair SF 600W", 99.99));
		
		// menu interface
		// while the userInput is not "x" we loop, we present the menu again
		do {
			System.out.println("======================================");
			System.out.println("Welcome to the PC Warehouse Store!");
			System.out.println("[1] Display List");
			System.out.println("[2] Create and Add an Item to the list");
			System.out.println("[x] Exit Store");
			
			userInput = scanner.nextLine();
			
			//Logger.writeToFile("User input the following: " + userInput);
			logger.log(LogLevel.info, userInput);
			
			switch(userInput) {
			case "1":
				System.out.println("The Item currently listed are:");
				System.out.println();
				for(CoreComponents currentDrink: drinkList) {
					//System.out.println(currentDrink.getName() + " priced at: " + currentDrink.price);
					System.out.printf("%s priced at: $%.2f \n", currentDrink.getName(), currentDrink.getPrice());
				}
				System.out.println();
				break;
			case "2":
				// Get User's Item Name
				System.out.println("Enter new Item name: ");
				String name = scanner.nextLine();
				
				// Get User's Item Price
				System.out.println("Enter the Item's price: ");
				String priceString = scanner.nextLine();
				try {
					double priceDouble = Double.parseDouble(priceString);//Integer.parseInt(priceString);
					if(priceDouble > 0) {
						CoreComponents newDrink = new CoreComponents(name, priceDouble);
						drinkList.add(newDrink);
						System.out.println("Item successfully added!");
					} else {
						System.out.println("Invalid Price, try again please.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println("Exception message is: " + e.getMessage());
					logger.log(LogLevel.error, "User input failed: " + priceString);
					System.out.println("Invalid Input, Item not added");
					//e.printStackTrace();
				}

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

}
