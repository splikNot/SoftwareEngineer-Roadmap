package vectors;

import java.util.Locale;

public class Sum {
	
	public static double[] sumBetweenVectors(double[] vectA, double[] vectB) {
		
		Locale.setDefault(Locale.US);
		
		int n = vectA.length;
		double[] vectC = new double[n];
			
		//resultant vector
		for (int i = 0; i < n; i++) {
			vectC[i] = vectA[i] + vectB[i];
		}
			
		return vectC;
		
	}
	
	public static double sumVector(double[] vector) {
		
		double sum = 0.0;
		
		for (int i = 0; i< vector.length; i++) {
			sum += vector[i];
		}
		
		return sum;
	}
		
	
}
