package businessLogic;

import util.Assertion;
import util.Test;

//import businessLogic.GameLogic;

public class GameLogicTest {
	
	// Test #1
	@Test
	public void SMASH_CHAR_LIST_SIZE_SHOULD_BE_NON_ZERO() {
		
		//Arrange
        int expectedSize = 1;
        GameLogic gl = new GameLogic();

        //Act
        int actualSize = gl.getSmashCharListSize();

        //Assert
        Assertion.NotEquals(expectedSize, actualSize);
	}

}
