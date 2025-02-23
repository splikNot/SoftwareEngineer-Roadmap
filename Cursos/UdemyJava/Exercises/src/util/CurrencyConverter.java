package util;
//import java.util.Locale;


public class CurrencyConverter {

	//static { Locale.setDefault(Locale.US); } 
	
	public static double tax = (6.0/100);
	
	public static double currencyCalculator(double price, double quantity) {
		double total = price*quantity;
		return total + tax*total;
	}
	
	
}
