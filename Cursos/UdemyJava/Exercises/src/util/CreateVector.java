package util;

import java.util.Scanner;

public class CreateVector {
	
	public static double[] create(int n, Scanner sc) {

		double[] vect = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Type a number: ");
			vect[i] = sc.nextDouble();
		}
		
		return vect;

	}
	
}
