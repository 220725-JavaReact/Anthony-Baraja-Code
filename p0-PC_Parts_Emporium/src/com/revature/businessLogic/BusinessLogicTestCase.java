package com.revature.businessLogic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessLogicTestCase {

	@Test
	void getCustomerNameByIdTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testCustomerId = 1;
		String expectedName = "Anthony Baraja";
		
		// Act
		String actualName = bl.getCustomerNameById(testCustomerId);
		
		// Assert
		assertEquals(expectedName, actualName);
	}
	
	@Test
	void getCustomerNameByIdTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testCustomerId = 1;
		String expectedName = "Jimmy Carter";
		
		// Act
		String actualName = bl.getCustomerNameById(testCustomerId);
		
		// Assert
		assertNotEquals(expectedName, actualName);
	}
	
	@Test
	void productSelectionIdIsValidTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProductId = 42;
		int testStoreId = 3;
		Boolean expectedResult = true;
		
		// Act
		Boolean actualResult = bl.productSelectionIdIsValid(testProductId, testStoreId);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void productSelectionIdIsValidTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProductId = 26;
		int testStoreId = 4;
		Boolean expectedResult = true;
		
		// Act
		Boolean actualResult = bl.productSelectionIdIsValid(testProductId, testStoreId);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}
	
	@Test
	void getLineItemIDFromProdIdTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProductId = 15;
		int expectedResult = 15;
		
		// Act
		int actualResult = bl.getLineItemIDFromProdId(testProductId);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void getLineItemIDFromProdIdTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProductId = 17;
		int expectedResult = 15;
		
		// Act
		int actualResult = bl.getLineItemIDFromProdId(testProductId);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}
	
	@Test
	void getLineItemQtyAmountFromProdIdTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProductId = 17;
		int expectedResult = 3;
		
		// Act
		int actualResult = bl.getLineItemQtyAmountFromProdId(testProductId);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void getLineItemQtyAmountFromProdIdTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProductId = 20;
		int expectedResult = 3;
		
		// Act
		int actualResult = bl.getLineItemQtyAmountFromProdId(testProductId);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}
	
	@Test
	void checkUserQtyNotOverLineItemQtyLimitTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testLineItemId = 20;
		int testQty = 1;
		boolean expectedResult = true;
		
		// Act
		boolean actualResult = bl.checkUserQtyNotOverLineItemQtyLimit(testLineItemId, testQty);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void checkUserQtyNotOverLineItemQtyLimitTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testLineItemId = 20;
		int testQty = 8;
		boolean expectedResult = true;
		
		// Act
		boolean actualResult = bl.checkUserQtyNotOverLineItemQtyLimit(testLineItemId, testQty);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

}
