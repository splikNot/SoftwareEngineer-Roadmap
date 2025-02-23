package vectors;

import java.util.Locale;

public class MeanVector {
	
	public static double mean(double[] vector) {
		Locale.setDefault(Locale.US);
		
		double sum = Sum.sumVector(vector);
		
		double mean = sum/vector.length;
		
		return mean;
	
	}

}
