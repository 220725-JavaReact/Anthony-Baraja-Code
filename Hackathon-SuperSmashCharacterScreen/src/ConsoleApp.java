import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import businessLogic.GameLogic;
import businessLogic.GameLogicTest;
import userInterface.Menu;
import util.Test;

public class ConsoleApp {
	public static void main(String[] args) {
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		// UNIT TEST SECTION
		//////////////////////////////////////////////////////////////////////////////////////////////
		//Class gameLogicClass = GameLogic.class;
		Class<GameLogic> gameLogicClass = GameLogic.class;
		Field[] allFields = gameLogicClass.getDeclaredFields();

		for (Field field : allFields) {
			System.out.println(field.getName());
		}
		
		//Class gameLogicTestClass = GameLogic.class;
		//Method[] allMethods = 
		//for (Method method : allMethods)
		
		System.out.println("Unit testing starting...");
		GameLogicTest gameLogicTest = new GameLogicTest();
		
		Class<GameLogicTest> gameLogicTestClass = GameLogicTest.class;
		
		int totalUnitTests = 0; //Will count how many unit tests we are running
		int totalPassedTests = 0; //Counts passed unit tests
		int totalIgnoredTests = 0; //Counts ignored unit tests
		int totalFailedTests = 0; //Counts failed unit tests
		
		Method[] gameLogicTestMethods = gameLogicTestClass.getDeclaredMethods();
		//Class carTestClass = CarTest.class;
		//Method[] carTestMethods = carTestClass.getDeclaredMethods();
		
		for (Method method : gameLogicTestMethods) {
			if(method.isAnnotationPresent(Test.class)) {
				totalUnitTests++;
				Test test = method.getAnnotation(Test.class);
				
				if(test.enable()) {
					System.out.print(method.getName());
					try {
						//Grabs the return result of that method
						try {
							method.invoke(gameLogicTest);
							
							System.out.println("...Passed");
							totalPassedTests++;
						} catch (InvocationTargetException e) {
							//TODO: handle exception
							System.out.println("..." + e.getTargetException().getMessage());
							totalFailedTests++;
						}
					} 
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				else {
					totalIgnoredTests++;
				}
				System.out.println(String.format("Total unit tests: %d\nTotal passed tests: %d\nTotal ignored tests: %d", totalUnitTests, totalPassedTests, totalIgnoredTests));
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////
		
		Menu.showWelcomeText();
		Menu.presentMainMenu();
	}

}
