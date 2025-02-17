package exercises;

import java.util.Locale;
import java.util.Scanner;
import util.CurrencyConverter;
import util.DisplayOptions;

public class Interface {
	
	public static void exercise1() {
		Scanner sc = new Scanner (System.in);
		
		Rectangle rect;
		rect = new Rectangle();
		
		System.out.println("Entre a altura do retângulo: ");
		System.out.println();
		rect.height = sc.nextDouble();
		
		System.out.println("Entre o comprimento da base do retângulo: ");
		System.out.println();
		rect.width = sc.nextDouble();
		
		System.out.printf("Área do retângulo: %.3f%n", rect.area());
		System.out.printf("Perimetro do retângulo %.3f%n",rect.perimeter());
		System.out.printf("Diagonal do retângulo: %.3f%n", rect.diagonal());
		sc.close();
	}
	
	public static void exercise2() {
		Employees emp;
		emp = new Employees();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name: ");
		emp.name = sc.next();
		System.out.println();
		
		System.out.print("Gross salary: ");
		emp.grossSalary = sc.nextDouble();
		System.out.println();
		
		System.out.print("Tax: ");
		emp.tax = sc.nextDouble();
		System.out.println();
		
		System.out.print("Employee: " + emp);
		
		System.out.print("Which percentage to increase salary?");
		double percentage = sc.nextDouble();
		emp.IncreseSalary(percentage);
		System.out.println();
		
		System.out.println("Updated data: " + emp);
	
		sc.close();
			
	}
	
	public static void exercise3() {
		
		Student student;
		student = new Student();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do aluno: ");
		student.name = sc.next();
		System.out.println();
		
		System.out.print("Nota 1: ");
		student.grade1 = sc.nextDouble();
		
		System.out.print("Nota 2: ");
		student.grade2 = sc.nextDouble();
		
		System.out.print("Nota 3: ");
		student.grade3 = sc.nextDouble();
		
		System.out.printf("FINAL GRADE = %.2f%n", student.Mean());
		
		if (student.Mean() >= 6) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAILED");
			double missingPoints = 6 - student.Mean();
			System.out.printf("Missing %.2f points.%n", missingPoints);
		}
		
		sc.close();
	}
	
	public static void exercise4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the dollar price?");
		double dollarPrice = sc.nextDouble();
		
		System.out.print("How many dollars will be bought?");
		double quantity = sc.nextDouble();
		
		double total = CurrencyConverter.currencyCalculator(dollarPrice, quantity);
		
		System.out.printf("Amount to be paid in reais: %.2f%n", total);
		sc.close();
	}
	
	public static void exercise5() {
		
		BankAccount acc = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter account number: ");
		int accNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter account holder: ");
		String holderName = sc.nextLine();

		System.out.print("Is there any initial deposit (y/n)?");
		char optionalDeposit = sc.next().charAt(0);
		
		if (optionalDeposit == 'y' || optionalDeposit == 'Y') {
			
			System.out.print("Enter initial deposit value: ");
			double depositValue = sc.nextDouble();
			sc.nextLine();
			
			acc = new BankAccount(accNumber, holderName, depositValue);		
		}
		
		else if (optionalDeposit == 'n' || optionalDeposit == 'N') {
			acc = new BankAccount(accNumber, holderName, 0);
		}
		
		else {
			System.out.println("Invalid Option.");
			System.out.println("Exiting now!");	
			System.exit(0);
		}
		
		
		DisplayOptions.displayOptions();
		int userEntry = sc.nextInt();
		
		while (userEntry != 0) {
			
			if (userEntry == 1) {
				acc.dataAccount();
			}
			
			if (userEntry == 2) {
				System.out.print("Enter a withdraw value: ");
				double withdrawValue = sc.nextDouble();
				acc.withDraw(withdrawValue);
				
				System.out.println("Updated account data: ");
				acc.dataAccount();
			}
			
			if (userEntry == 3) {
				System.out.print("Enter a deposit value: ");
				double depositValue = sc.nextDouble();
				acc.deposit(depositValue);
				
				System.out.println("Updated account data: ");
				acc.dataAccount();
			}	
			System.out.println();
			DisplayOptions.displayOptions();
			userEntry = sc.nextInt();	
		}
		
		if (userEntry == 0) {
			System.out.println("Good Bye!");
			System.exit(0);
		}
		
		sc.close();		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter exercise number:");
		int exercise = sc.nextInt();
		
		switch (exercise) {

		case 1:
		    exercise1();
		    break;

		case 2:
		    exercise2();
		    break;
		    
		case 3:
			exercise3();
			break;
			
		case 4:
			exercise4();
			break;
			
		case 5:
			exercise5();
			break;
			
		default:
			System.out.println("No exercise with this numbering!");
		    break;
		}

		sc.close();
	}
	

}
