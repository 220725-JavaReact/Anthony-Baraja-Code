package util;
import java.util.Arrays;

public class Assertion {
	
	public static boolean Equals(int expected, int actual)
    {
        return expected == actual;
    }
	
	public static boolean NotEquals(int expected, int actual)
    {
        return expected != actual;
    }
	
	// Activity: arrayEquals
	public static boolean arrayEquals(String[] expected, String[] actual)
    {
        return Arrays.equals(expected, actual);
    }

}
