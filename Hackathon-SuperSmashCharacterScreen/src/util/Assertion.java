package util;
import java.util.Arrays;

public class Assertion {
	
	public static boolean Equals(int expected, int actual)
    {
        return expected == actual;
    }
	
	public static boolean EqualsString(String expected, String actual)
    {
		System.out.println();
		System.out.println("EqualsString test: " + expected.equals(actual));
		return expected.equals(actual);
    }
	
	public static boolean NotEquals(int expected, int actual)
    {
        return expected != actual;
    }
	
	public static boolean NonNegative(int testValue)
    {
        return testValue > 0;
    }
	
	// Activity: arrayEquals
	public static boolean arrayEquals(String[] expected, String[] actual)
    {
        return Arrays.equals(expected, actual);
    }

}
