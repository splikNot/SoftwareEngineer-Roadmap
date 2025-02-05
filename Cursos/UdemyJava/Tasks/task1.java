// Exercicio 1: Saída de Dados

package learningProject;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		String product1 = "Computer";
		String product2 = "Office desk";
		
		int age = 37;
		int code = 1234;
		char gender = 'M';
		
		double price1 = 2100.0;
		double price2 = 650.00;
		double measure = 53.234567;
		
		System.out.println("Products");
		System.out.printf("%s, which price is $ %.2f %n", product1, price1);
		System.out.printf("%s, which price is $ %.2f %n", product2, price2);
		
		System.out.printf("Record: %d years old, code %d and gender: %c %n %n", age, code, gender);
		
		System.out.printf("Measue with eigth decimal places: %f %n", measure);
		System.out.printf("Rounded (three decimal places): %.3f %n", measure);
		Locale.setDefault(Locale.US);
		System.out.printf("US decimal point: %.3f", measure);
	}

}
