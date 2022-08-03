package businessLogic;

import util.Assertion;
import util.Test;

//import businessLogic.GameLogic;

public class GameLogicTest {
	
	// Test #1
	@Test
	public void getSmashCharListSize_SHOULD_BE_NON_ZERO() {
		
		//Arrange
        GameLogic gl = new GameLogic();

        //Act
        int actualSize = gl.getSmashCharListSize();

        //Assert
        Assertion.NonNegative(actualSize);
	}
	
	// Test #2
	@Test
	public void getCharNameAtIndex_SHOULD_RETURN_STRING_NAME_BOWSER() {
		
		//Arrange
		int bowserIndex = 0;
		String expectedName = "Bowser";
        GameLogic gl = new GameLogic();

        //Act
        String actualName = gl.getCharNameAtIndex(bowserIndex);

        //Assert
        Assertion.EqualsString(expectedName, actualName);
	}
		
	// Test #3
	@Test
	public void getCharWeigtAtIndex_SHOULD_RETURN_INT_WEIGHT_BOWSER() {
		
		//Arrange
		int bowserIndex = 0;
		int expectedWeight = 135;
        GameLogic gl = new GameLogic();

        //Act
        int actualWeight = gl.getCharWeigtAtIndex(bowserIndex);

        //Assert
        Assertion.Equals(expectedWeight, actualWeight);
	}
	
	// Test #4
	@Test
	public void getCharWeightType_SHOULD_RETURN_STRING_WEIGHT_TYPE() {
		
		//Arrange
		int bowserIndex = 0;
		String expectedWeightType = "Super HeavyWeight";
        GameLogic gl = new GameLogic();

        //Act
        int actualWeight = gl.getCharWeigtAtIndex(bowserIndex);
        String actualWeightType = gl.getCharWeightType(actualWeight);

        //Assert
        Assertion.EqualsString(expectedWeightType, actualWeightType);
	}

}
