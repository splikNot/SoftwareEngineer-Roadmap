package exercises;

import java.util.Scanner;
import java.util.Locale;
import util.CurrencyConverter;

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
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Entre o número do exercício:");
		int exercise = sc.nextInt();
		
		if (exercise == 1) {
			exercise1();
		}
		if (exercise == 2) {
			exercise2();
		}
		if (exercise == 3) {
			exercise3();
		}
		if (exercise == 4) {
			exercise4();
		}
		else {
			System.out.println("Nenhum exercício com essa numeração;");
		}
		sc.close();
	}
	

}
