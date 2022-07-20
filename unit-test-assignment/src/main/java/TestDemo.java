import java.util.Random;

public class TestDemo {
	
	
	//Create a method that adds int a and int b, only if they are both positive.
	//Otherwise throw an exception.
	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0 ) {
			return a + b;
		} else 
			throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
	
	//Create a method that finds the square of a random number
	public int randomNumberSquared() {
		int c = getRandomInt();
		return c * c; 
	}
	
	
	//Find a random number between 1 and 10.
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
