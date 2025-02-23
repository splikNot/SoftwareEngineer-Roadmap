package util;
import java.util.Locale;
//import java.util.Scanner;


public class DisplayOptions {
	
	static { Locale.setDefault(Locale.US); }
	
	public static void displayOptions() {
		System.out.println("How can I help?");
		System.out.println("(1) Account balance");
		System.out.println("(2) Withdraw");
		System.out.println("(3) Deposit");
		System.out.println("(0) Exit");
	}

}
