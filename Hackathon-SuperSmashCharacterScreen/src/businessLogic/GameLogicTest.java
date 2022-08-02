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
			String expectedName = "Bowsers";
	        GameLogic gl = new GameLogic();

	        //Act
	        String actualName = gl.getCharNameAtIndex(bowserIndex);

	        //Assert
	        Assertion.EqualsString(expectedName, actualName);
		}

}
