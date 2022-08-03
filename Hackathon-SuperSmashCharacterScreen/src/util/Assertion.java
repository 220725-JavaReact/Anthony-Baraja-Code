package util;
import java.util.Arrays;

public class Assertion {
	
	public static void Equals(int expected, int actual)
    {
        Evaluate(expected == actual, "Equals Int Failed");
    }
	
	public static void EqualsString(String expected, String actual)
    {
		Evaluate(expected.equals(actual), "Equals String Failed");
    }
	
	public static boolean NotEquals(int expected, int actual)
    {
        return expected != actual;
    }
	
	public static void NonNegative(int testValue)
    {
		Evaluate(testValue > 0, "Int Value NonNegative Failed");
    }
	
	// Activity: arrayEquals
	public static void arrayEquals(String[] expected, String[] actual)
    {
		Evaluate(Arrays.equals(expected, actual), "Array Equals Failed");
    }
	
	private static void Evaluate(boolean condition, String message)
    {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

}
