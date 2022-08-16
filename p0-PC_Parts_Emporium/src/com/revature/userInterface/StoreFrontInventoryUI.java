package com.revature.userInterface;

import java.util.Scanner;

import com.revature.businessLogic.BusinessLogic;
import com.revature.models.ProductPC;
import com.revature.util.MyHashMap;

public class StoreFrontInventoryUI {
	
	private static BusinessLogic bl = new BusinessLogic();
	
	public void StoreFrontMenu(Scanner sc) {
		String userInput = "";
		int userProdSelect = 0;
		
		do {
			System.out.println("======================================");
			System.out.println("Store Front Selections");
			System.out.println("======================================");
			
			bl.printStoreFrontSelections();
			System.out.println("[x] Return to Main Menu");
			
			userInput = sc.nextLine();
			if(userInput.equals("x")) break;
			try {
				userProdSelect = Integer.parseInt(userInput);
				presentProductSelectionsPerLocation(sc, userProdSelect);
				userInput = "x";
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
			System.out.println("Products Available at this Location\nSelect a PC Component for more details");
			System.out.println("======================================");
			
			MyHashMap<Integer, ProductPC> storeMap = bl.mapProductsByStoreID(store_id);
			bl.printAllProductsFromMap(storeMap);
			
			System.out.println("[x] Return to Store Front Selections");
			
			userInput = sc.nextLine();
			if(userInput.equals("x")) break;
			
			userProdSelect = Integer.parseInt(userInput);
			int userProdId = storeMap.get(userProdSelect).getId();
			
			if(bl.productSelectionIdIsValid(userProdId, store_id)) {
				bl.printProductDetails(userProdId);
			}
			
		} while (!(userInput.equals("x")));
	}

}
