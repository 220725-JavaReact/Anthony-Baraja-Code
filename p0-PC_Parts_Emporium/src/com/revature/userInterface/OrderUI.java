package com.revature.userInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.businessLogic.BusinessLogic;
import com.revature.models.Order;
import com.revature.models.OrderLink;
import com.revature.models.ProductPC;
import com.revature.util.MyHashMap;

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
		///////////////////////////////////////////////////////////////////////////
		OrderLink currentOrderLink = new OrderLink(1, 0.0);
		List<Order> currentOrdersList = new ArrayList<Order>();
		ArrayList<Integer> orderQtyList = new ArrayList<Integer>();
		int index = 0;
		
		// Load the first Order # first
		currentOrdersList.add(new Order(index, 0, storeIdInt, customerIdInt, currentOrderLink.getId(), 0.0));
		
		// Actual Order(s) loop begin, adding multiple Orders
		placeOrderLoopProductPrompt(sc, currentOrdersList, index, orderQtyList);
		
		///////////////////////////////////////////////////////////////////////////		
	}
	
	public void placeOrderLoopProductPrompt(Scanner sc, List<Order> currentOrdersList, int index, ArrayList<Integer> orderQtyList) {
		Order currentOrder = currentOrdersList.get(index);
		
		System.out.println("======================================");
		System.out.println("Select Product: ");
		MyHashMap<Integer, ProductPC> storeMap = bl.mapProductsByStoreID(currentOrder.getStore_id());
		bl.printAllProductsFromMap(storeMap);
		
		int userProductId = sc.nextInt();
		int productId = storeMap.get(userProductId).getId();
		bl.printProductDetails(productId);
		
		if(bl.checkLineItemQtyAmountbyProdId(productId)) {
			currentOrdersList.get(index).setLineItem_id(bl.getLineItemIDFromProdId(productId));
			placeOrderLoopQuantityPrompt(sc, currentOrdersList, index, orderQtyList);
		}else {
			System.out.println("That Product is currently out of stock, please choose a valid product...");
			placeOrderLoopProductPrompt(sc, currentOrdersList, index, orderQtyList);
		}
	}
	
	public void placeOrderLoopQuantityPrompt(Scanner sc, List<Order> currentOrdersList, int index, ArrayList<Integer> orderQtyList) {
		
		System.out.println("\n======================================");
		System.out.println("Enter Quantity Amount: ");
		
		int userQuantity = sc.nextInt();
		
		// check if user qty is not over the stock limit of that line item
		if(bl.checkUserQtyNotOverLineItemQtyLimit(currentOrdersList.get(index).getLineItem_id(), userQuantity)) {
			List<Order> updatedOrdersList = bl.setTotalPriceToCurrentOrdersList(currentOrdersList, index, userQuantity);
			orderQtyList.add(userQuantity);
			bl.printOrderDetails(updatedOrdersList, orderQtyList);
			currentOrdersList = updatedOrdersList;
			
			String userInput = "";
			sc.nextLine();
			
			do {
				System.out.println("======================================");
				System.out.println("Please select the following options:");
				System.out.println("======================================");
				System.out.println("[1] Keep Shopping");
				System.out.println("[2] Finalize Order");
				System.out.println("[x] Cancel and Exit Order");
				
				userInput = sc.nextLine();
				
				switch(userInput) {
				case "1":  // Keep Shopping
					index++;
					Order newOrder = new Order(index, 0, currentOrdersList.get(0).getStore_id(), currentOrdersList.get(0).getCustomer_id(), currentOrdersList.get(0).getOrder_link(), 0.0);
					currentOrdersList.add(newOrder);
					placeOrderLoopProductPrompt(sc, currentOrdersList, index, orderQtyList);
					userInput = "x";
					break;
				case "2":  // Finalize Order
					bl.finalizeOrder(currentOrdersList, orderQtyList);
					userInput = "x";
					break;
				case "x":  // Cancel and Exit Order
					System.out.println("Canceling Order, Going back to Order Menu");
					break;
				default:
					System.out.println("Wrong input. Please try again using one of the valid options.");
					break;
				}
			} while (!(userInput.equals("x")));
			
		}else {
			System.out.println("That Quantity amount is over the stock available for that product, please enter a valid amount...");
			placeOrderLoopQuantityPrompt(sc, currentOrdersList, index, orderQtyList);
		}
	}
	
	/**
	 * Display the 
	 * @param sc - Scanner
	 */
	public void orderHistoryMenu(Scanner sc) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("Order History Menu");
			System.out.println("======================================");
			System.out.println("[1] View All Past Orders");
			System.out.println("[2] View By a Customer");
			System.out.println("[3] View By a Store Front");
			System.out.println("[x] Exit Order History Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				//System.out.println("Feature Coming Soon!");
				System.out.println();
				bl.printAllOrderHistory();
				System.out.println();
				break;
			case "2":
				
				// Get User Inputs
				System.out.println("\n======================================");
				System.out.println("Select Customer: ");
				bl.printAllCustomerSelections();
				String customerId = sc.nextLine();
				int customerIdInt = Integer.parseInt(customerId);
				
				orderHistoryByCustomerMenu(sc, customerIdInt);
				break;
			case "3":
				//System.out.println("Feature Coming Soon!");
				System.out.println("\n======================================");
				System.out.println("Select a Store Front: ");
				bl.printStoreFrontSelections();
				String storeId = sc.nextLine();
				int storeIdInt = Integer.parseInt(storeId);
				
				orderHistoryByStoreMenu(sc, storeIdInt);
				break;
			case "x":
				System.out.println("Returning to Order Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
	}
	
	private void orderHistoryByStoreMenu(Scanner sc, int storeId) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("Order History By Store Front");
			System.out.println("======================================");
			System.out.println("[1] View By Order #");
			System.out.println("[2] View By Total Price");
			System.out.println("[x] Exit Order History Customer Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println();
				orderHistoryByStoreByOrderNums(sc, storeId, "orderNum");
				System.out.println();
				break;
			case "2":
				orderHistoryByStoreByTotalPrice(sc, storeId, "price");
				break;
			case "x":
				System.out.println("Returning to Order History Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
		
	}

	private void orderHistoryByStoreByTotalPrice(Scanner sc, int storeId, String orderPick) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("By Order History Store Front - By Total Price $$$");
			System.out.println("======================================");
			System.out.println("[1] In Ascending Order");
			System.out.println("[2] In Descending Order");
			System.out.println("[x] Back to Order History Customer Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println();
				bl.printAllCustomerOrderHistory("ASC", storeId, orderPick, "customer");
				System.out.println();
				break;
			case "2":
				System.out.println();
				bl.printAllCustomerOrderHistory("DESC", storeId, orderPick, "customer");
				System.out.println();
				break;
			case "x":
				System.out.println("Returning to Order History Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
		
	}

	private void orderHistoryByStoreByOrderNums(Scanner sc, int storeId, String orderPick) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("By Order History Store Front - By Order #");
			System.out.println("======================================");
			System.out.println("[1] In Ascending Order");
			System.out.println("[2] In Descending Order");
			System.out.println("[x] Back to Order History Customer Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println();
				bl.printAllCustomerOrderHistory("ASC", storeId, orderPick, "store");
				System.out.println();
				break;
			case "2":
				System.out.println();
				bl.printAllCustomerOrderHistory("DESC", storeId, orderPick, "store");
				System.out.println();
				break;
			case "x":
				System.out.println("Returning to Order History Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
	}

	public void orderHistoryByCustomerMenu(Scanner sc, int customerId) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("Order History By Customer");
			System.out.println("======================================");
			System.out.println("[1] View By Order #");
			System.out.println("[2] View By Total Price");
			System.out.println("[x] Exit Order History Customer Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println();
				orderHistoryByCustomerByOrderNums(sc, customerId, "orderNum");
				System.out.println();
				break;
			case "2":
				orderHistoryByCustomerByTotalPrice(sc, customerId, "price");
				break;
			case "x":
				System.out.println("Returning to Order History Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
	}
	
	private void orderHistoryByCustomerByTotalPrice(Scanner sc, int customerId, String orderPick) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("By Order History Customer - By Total Price $$$");
			System.out.println("======================================");
			System.out.println("[1] In Ascending Order");
			System.out.println("[2] In Descending Order");
			System.out.println("[x] Back to Order History Customer Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println();
				bl.printAllCustomerOrderHistory("ASC", customerId, orderPick, "customer");
				System.out.println();
				break;
			case "2":
				System.out.println();
				bl.printAllCustomerOrderHistory("DESC", customerId, orderPick, "customer");
				System.out.println();
				break;
			case "x":
				System.out.println("Returning to Order History Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
		
	}

	public void orderHistoryByCustomerByOrderNums(Scanner sc, int customerId, String orderPick) {
		String userInput = "";
		
		do {

			System.out.println("======================================");
			System.out.println("By Order History Customer - By Order #");
			System.out.println("======================================");
			System.out.println("[1] In Ascending Order");
			System.out.println("[2] In Descending Order");
			System.out.println("[x] Back to Order History Customer Menu");
			
			userInput = sc.nextLine();
			
			switch(userInput) {
			case "1":
				System.out.println();
				bl.printAllCustomerOrderHistory("ASC", customerId, orderPick, "customer");
				System.out.println();
				break;
			case "2":
				System.out.println();
				bl.printAllCustomerOrderHistory("DESC", customerId, orderPick, "customer");
				System.out.println();
				break;
			case "x":
				System.out.println("Returning to Order History Menu");
				break;
			default:
				System.out.println("Wrong input. Please try again using one of the valid options.");
				break;
			}
			
		} while (!(userInput.equals("x")));
	}

}
