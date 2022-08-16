import java.util.concurrent.ThreadLocalRandom;

public class DriverTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i = 1; i <= 109; i++) {
			System.out.println("(DEFAULT, " + i + ", " + getRandomValue(2, 8) + "),");
		}
		

	}
	
	public static int getRandomValue(int Min, int Max)
    {
  
        // Get and return the random integer
        // within Min and Max
        return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }

}
