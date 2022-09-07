import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.businessLogic.BusinessLogic;

public class BusinessLogicTest {

    @Test
    void getCustomerNameByIdTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		String testCustomerName = "Anthony";
		String expectedResult = "<div id=\"customer\"><p><h4>Name: Anthony Baraja</h4><ul><li>Address: 1234 Main St, Los Angeles, CA 90016</li><li>Email: anthony9000@hotmail.com</li><li>Phone: 6364489591</li></ul></p></div>";
		
		// Act
		String actualResult = bl.displaySearchedCustomer(testCustomerName);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}

    @Test
    void getCustomerNameByIdTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		String testCustomerName = "Anthony";
		String expectedResult = "<div id=\"customer\"><p><h4>Name: Foxxy</h4><ul><li>Address: 1234 Main St, Los Angeles, CA 90016</li><li>Email: anthony9000@hotmail.com</li><li>Phone: 6364489591</li></ul></p></div>";
		
		// Act
		String actualResult = bl.displaySearchedCustomer(testCustomerName);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

    @Test
    void setOrderPriceTestEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProdId = 1;
        int testQtyNum = 1;
		Double expectedResult = 89.99;
		
		// Act
		Double actualResult = bl.setOrderPrice(testProdId, testQtyNum);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}

    @Test
    void setOrderPriceTestNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProdId = 1;
        int testQtyNum = 1;
		Double expectedResult = 189.99;
		
		// Act
		Double actualResult = bl.setOrderPrice(testProdId, testQtyNum);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

    @Test
    void setOrderPriceTestNotEqualsTwo() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProdId = 1;
        int testQtyNum = 1;
		Double expectedResult = 289.99;
		
		// Act
		Double actualResult = bl.setOrderPrice(testProdId, testQtyNum);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

    @Test
    void setOrderPriceTestNotEqualsThree() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProdId = 1;
        int testQtyNum = 1;
		Double expectedResult = 389.99;
		
		// Act
		Double actualResult = bl.setOrderPrice(testProdId, testQtyNum);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

    @Test
    void setOrderPriceTestNotEqualsFour() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testProdId = 1;
        int testQtyNum = 1;
		Double expectedResult = 9000.99;
		
		// Act
		Double actualResult = bl.setOrderPrice(testProdId, testQtyNum);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

    @Test
    void getNewOrderLinkIdNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int expectedResult = 0;
		
		// Act
		int actualResult = bl.getNewOrderLinkId();
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}

    @Test
    void checkUserQtyNotOverLineItemQtyLimitEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testLineItemId = 60;
        int testQty = 100;
		boolean expectedResult = false;
		
		// Act
		boolean actualResult = bl.checkUserQtyNotOverLineItemQtyLimit(testLineItemId, testQty);
		
		// Assert
		assertEquals(expectedResult, actualResult);
	}

    @Test
    void checkUserQtyNotOverLineItemQtyLimitNotEquals() {
		
		// Arrange
		BusinessLogic bl = new BusinessLogic();
		int testLineItemId = 60;
        int testQty = 100;
		boolean expectedResult = true;
		
		// Act
		boolean actualResult = bl.checkUserQtyNotOverLineItemQtyLimit(testLineItemId, testQty);
		
		// Assert
		assertNotEquals(expectedResult, actualResult);
	}
    
}
