package simulation;

import java.util.Random;

public class LwhRandom {
	
	private static Random random = new Random();
	
	public static double uniform(){
		return random.nextDouble();
	}
	
	public static double uniform(double a, double b) {
		if(!(a < b))
			throw new IllegalArgumentException("invalid range [" + a + "," + b + "].");
		return a + uniform()*(b-a);
	}

}
