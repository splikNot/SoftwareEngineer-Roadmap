package util;

import classes.AbstractPerson;
import classes.BankAccount;
import classes.BoardingHouse;
import classes.Employees;
import classes.ImportedProduct;
import classes.JuridicPerson;
import classes.NaturalPerson;
import classes.Order;
import classes.Person;
import classes.Product;
import classes.Rectangle;
import classes.Student;
import classes.UsedProduct;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import vectors.Matrix;
import vectors.MeanVector;
import vectors.Sum;

public class Main {
	
	static {Locale.setDefault(Locale.US);}
	
	private static void exercise1(Scanner sc) {
		
		Rectangle rect;
		rect = new Rectangle();
		
		System.out.print("Entre a altura do retângulo: ");
		rect.height = sc.nextDouble();
		System.out.println();
		
		
		System.out.print("Entre o comprimento da base do retângulo: ");
		rect.width = sc.nextDouble();
		System.out.println();
	
		
		System.out.printf("Área do retângulo: %.3f%n", rect.area());
		System.out.printf("Perimetro do retângulo %.3f%n",rect.perimeter());
		System.out.printf("Diagonal do retângulo: %.3f%n", rect.diagonal());
	}
	
	private static void exercise2(Scanner sc) {
		Employees emp;
		emp = new Employees();
		
		System.out.print("Name: ");
		emp.name = sc.next();
		System.out.println();
		
		System.out.print("Gross salary: ");
		emp.grossSalary = sc.nextDouble();
		System.out.println();
		
		System.out.print("Tax: ");
		emp.tax = sc.nextDouble();
		System.out.println();
		
		System.out.print("Employee: " + emp + "\n");
		
		System.out.print("Which percentage to increase salary? ");
		double percentage = sc.nextDouble();
		emp.IncreseSalary(percentage);
		
		System.out.println();
		
		System.out.println("Updated data: " + emp);
				
	}
	
	private static void exercise3(Scanner sc) {
		
		Student student;
		student = new Student();

		System.out.print("Nome do aluno: ");
		student.name = sc.next();
		System.out.println();
		
		System.out.print("Nota 1: ");
		student.grade1 = sc.nextDouble();
		
		System.out.print("Nota 2: ");
		student.grade2 = sc.nextDouble();
		
		System.out.print("Nota 3: ");
		student.grade3 = sc.nextDouble();
		
		System.out.println();
		
		System.out.printf("FINAL GRADE = %.2f%n", student.Mean());
		
		if (student.Mean() >= 6) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAILED");
			double missingPoints = 6 - student.Mean();
			System.out.printf("Missing %.2f points.%n", missingPoints);
		}
		
	}
	
	private static void exercise4(Scanner sc) {
		
		System.out.print("What is the dollar price? ");
		double dollarPrice = sc.nextDouble();
		
		System.out.print("How many dollars will be bought? ");
		double quantity = sc.nextDouble();
		
		double total = CurrencyConverter.currencyCalculator(dollarPrice, quantity);
		
		System.out.printf("Amount to be paid in reais: R$ %.2f%n", total);
	}
	
	private static void exercise5(Scanner sc) {
		
		BankAccount acc = null;
		
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
		
		System.out.println();
		
		DisplayOptions.displayOptions();
		int userEntry = sc.nextInt();
		
		while (userEntry != 0) {
			
			System.out.println();
			
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
		
	}
	
	private static void exercise6(Scanner sc) {
				
		System.out.print("How many numbers to input? ");
		int n = sc.nextInt();
		double[] vectNumbers = CreateVector.create(n, sc);
		
		System.out.println();
		System.out.println("NEGATIVE NUMBERS: ");
		for (int i = 0; i < n; i++) {
			if (vectNumbers[i] < 0) {
				System.out.println(vectNumbers[i]);
			}
		}
	}
	
	private static void exercise7(Scanner sc) {
		
		System.out.print("What will be the vector length? ");
		int n = sc.nextInt();
		
		double vect[] = CreateVector.create(n, sc);
		double sum = Sum.sumVector(vect);
		double mean = MeanVector.mean(vect);
		
		System.out.println();
		System.out.print("VALUES = ");
		for (int i = 0; i < vect.length; i++) {
			System.out.print(vect[i] + "  ");
		}
		
		System.out.println();
		System.out.printf("SUM = %.2f %n", sum);
		System.out.printf("MEAN = %.2f %n",mean);
			
	}
	
	private static void exercise8(Scanner sc) {
		Person person;
		
		System.out.print("How many people to input? ");
		int n = sc.nextInt();
		Person[] personVector = new Person[n];
		
		for (int i = 0; i < n; i++) {
			
			System.out.printf("Person %d data: %n", i + 1);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Age: ");
			int age = sc.nextInt();
			
			System.out.print("Height: ");
			double height = sc.nextDouble();
			System.out.println();
			
			person = new Person(name, age, height);
			personVector[i] = person;	
		}
		
		double sumHeight = 0.0;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			
			sumHeight += personVector[i].getHeight();
			
			if (personVector[i].getFlag() == false) {
				count += 1;
			}
		}
		
		double meanHeight = sumHeight/n;
		double percentage = (double)count/n*100.0; 
		
		// Divisão entre inteiros em c++ retorna um inteiro.
		// necessario trocar o tipo de uma das váriaveis para funcionar
		
		System.out.printf("Average Height: %.2f%n", meanHeight);
		System.out.println();
		System.out.printf("People under sixteen: %.2f %% %n", percentage);
		
		for (int i = 0; i < n; i++) {
			
			if (personVector[i].getFlag() == false) {
				System.out.println(personVector[i].getName());
			}
		}		
	}
	
	private static void exercise9(Scanner sc) {
				
		System.out.print("What will be the dimension of the vectors? ");
		int n = sc.nextInt();
		System.out.println();
		
		System.out.println("Enter the coordinates of vector A: ");
		double[] vectA = CreateVector.create(n, sc);
		System.out.println();
		
		System.out.println("Enter the coordinates of vector B: ");
		double[] vectB = CreateVector.create(n, sc);
		System.out.println();
		
		double[] vectC = Sum.sumBetweenVectors(vectA, vectB);
		
		System.out.println("RESULTANT VECTOR: ");
		for (int i = 0; i < n; i++) {
			System.out.print(vectC[i] + " ");
		}
	}
	
	private static void exercise10(Scanner sc) {
		
		System.out.print("How many elements in the vector? ");
		int n = sc.nextInt();
		System.out.println();
		
		double[] vector = CreateVector.create(n, sc);
		
		double mean = MeanVector.mean(vector);
		
		System.out.println();
		System.out.printf("VECTOR AVERAGE = %.2f%n", mean);
		
		System.out.println("ELEMENTS THAT ARE BELOW AVERAGE:");
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] < mean) {
				System.out.println(vector[i]);
			}
		}
		
	}
	
	private static void exercise11(Scanner sc) {
				
		System.out.print("How many students in the class? ");
		int n = sc.nextInt();
		
		Student[] vector = new Student[n];
		
		for (int i = 0; i < n; i++) {
			
			System.out.printf("%dº Student: %n", i+1);
			
			System.out.print("Enter student name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Enter 1º grade: ");
			double grade1 = sc.nextDouble();
			
			System.out.print("Enter 2º grade: ");
			double grade2 = sc.nextDouble();
			
			vector[i] = new Student(name, grade1, grade2);
			System.out.println();
		}
		
		System.out.println("APPROVED STUDENTS:");
		for (int i=0; i < n; i++) {
			if (vector[i].finalMean() >= 6.0) {
				System.out.println(vector[i].getName());
			}
		}
		
	}
	
	private static void exercise12(Scanner sc) {
		
		System.out.print("How many people to analyse? ");
		int n = sc.nextInt();
		Person[] vector = new Person[n];
		
		for (int i = 0; i < n; i++) {
			
			System.out.printf("Heigth of the %dº person: ",i+1);
			double height = sc.nextDouble();
			
			System.out.printf("Gender of the %dº person: ",i+1);
			char gender = sc.next().charAt(0);
			
			System.out.println();
			
			Person person = new Person(height, gender);
			vector[i] = person;
		}
		
		int femaleCount = 0;
		int maleCount = 0;
		
		double femaleHeightSum = 0.00;
		double maleHeightSum = 0.00;
		
		double lowerHeight = 9.99;
		double greaterHeight = 0.00;
		
		for (int i = 0; i < n; i++) {
			Person temp = vector[i];
			
			if (temp.getGender() == 'F' || temp.getGender() == 'f') {
				femaleCount += 1;
				femaleHeightSum += temp.getHeight();
			}
			
			else if (temp.getGender() == 'M' || temp.getGender() == 'm') {
				maleCount += 1;
				maleHeightSum += temp.getHeight();
			}
			
			else {
				System.out.println("INCLUSION ERROR");
				System.exit(0);
			}
			
			
			if (temp.getHeight() > greaterHeight) {
				greaterHeight = temp.getHeight();
			}
			
			if (temp.getHeight() < lowerHeight) {
				lowerHeight = temp.getHeight();
			}		
		}
		
		System.out.printf("LOWER HEIGHT: %.2f %n", lowerHeight);
		System.out.printf("GREATER HEIGHT: %.2f %n", greaterHeight);
		System.out.println();
		
		System.out.printf("FEMALE HEIGHT AVERAGE: %.2f %n", femaleHeightSum/femaleCount);
		System.out.printf("MALE HEIGHT AVERAGE: %.2f %n", maleHeightSum/maleCount);
		System.out.println();
		
		System.out.printf("FEMALE COUNT: %d %n", femaleCount);
		System.out.printf("MALE COUNT: %d %n", maleCount);
		
	}
	
	private static void exercise13(Scanner sc) {
		
		System.out.print("How many rooms will be rented? ");
		final int n = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		BoardingHouse house = new BoardingHouse(10);
		
		for (int i=0 ; i<n ; i++) {
			
			System.out.printf("RENT #%d: %n", i+1);
			
			System.out.print("Name: ");		
			String name = sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.print("Room: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			if (house.getRoom(roomNumber) == null) {
				house.allocate(roomNumber, name, email);
			}
			else {
				System.out.println("BUSY ROOM!");
				System.out.println("Choose another room");
				i-=1;
			}
		}
		
		System.out.println("BUSY ROOMS:");
		for (int i=1 ; i<=10 ; i++) {
			if (house.getRoom(i) != null) {
				String name = house.getRoom(i).getName();
				String email = house.getRoom(i).getEmail();
				System.out.printf("#%d: %s, %s%n", i, name, email);
			}
		}
		
	}
	private static void exercise14(Scanner sc) {
		
		System.out.println("What is the matrix order?");
		int n = sc.nextInt();
		
		int[][] mat = Matrix.matrixGenerator(n, n, sc);
		
		int[] diagonal = Matrix.matrixDiagonal(mat);
		
		System.out.println();
		System.out.println("MAIN DIAGONAL: ");
		
		for (int number : diagonal) {
			System.out.print(number + " ");
		}
		System.out.println();
		
		int count = 0;
		
		for (int i=0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length ; j++) {
				if (mat[i][j] < 0) {
					count += 1;
				}
			}
		}
		
		System.out.printf("NEGATIVE NUMBERS = %d", count);
			
	}
	
	private static void exercise15(Scanner sc) {
		
		
		System.out.print("How many rows in the matrix? ");
		int m = sc.nextInt();
		
		System.out.print("How many columns? ");
		int n = sc.nextInt();
		
		System.out.println();
		
		int[][] matrix = Matrix.matrixGenerator(m, n, sc);
		
		
		System.out.println();
		System.out.print("Choose a number to meet your neighbors: ");
		int number = sc.nextInt();
		System.out.println();
		
		// Eu tava fazendo isso de um jeito tão burro
		// Que é plausivel eu refazer ao inves de deixar meu codigo
		
		
		for (int i=0 ; i < m ; i++){
			for (int j=0 ; j < n; j++) {
				if (matrix[i][j] == number) {
					
					System.out.printf("Position %d,%d:%n", i, j);
					
					// Não e a linha superior da matriz
					if (i > 0) {
						int up = matrix[i-1][j];
						System.out.println("Up: " + up);
					}
					// Nao esta na linha inferior
					if (i < matrix.length - 1) {
						int down = matrix[i+1][j];
						System.out.println("Down: " + down);
					}
					// Nao esta na primeira coluna
					if (j > 0) {
						int left = matrix[i][j-1];
						System.out.println("Left: " + left);
					}
					// Nao esta na última coluna
					if (j < matrix[i].length -1) {
						int right = matrix[i][j+1];
						System.out.println("Right: "+ right);
					}
					System.out.println();
				}
			}
		}
	}

	private static void exercise16(Scanner sc){
		
		Order order =  new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		System.out.println(order);

		OrderStatus os1 = OrderStatus.DELIVERED;

		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);
	}

	private static void exercise17(Scanner sc) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> productList = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		System.out.println();
		for (int i = 0; i < n; i++){
			System.out.printf("Product #%d%n", i+1);

			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);

			sc.nextLine();
			if (ch=='c' | ch=='C'){
				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Price: ");
				double price = sc.nextDouble();

				Product product = new Product(name, price); 

				productList.add(product);
			}

			else if (ch=='u' | ch=='U'){
				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Price: ");
				double price = sc.nextDouble();

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());

				Product product = new UsedProduct(name, price, manufactureDate);

				productList.add(product);
			}

			else if (ch=='i' | ch=='I'){
				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Price: ");
				double price = sc.nextDouble();

				System.out.print("Custom fee: ");
				double fee = sc.nextDouble();

				Product product = new ImportedProduct(name, price, fee);
				
				productList.add(product);
			}

			else{
				System.out.println("Invalid Entry!");
				System.out.println("Exiting now!");
				break;
			}
			System.out.println();
		}

		System.out.println("PRICE TAGS:");

		for (Product prod : productList){
			System.out.println(prod.priceTag());
		}
	}
	private static void exercise18(Scanner sc){

		List<AbstractPerson> payerList = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++){
			System.out.printf("Tax payer #%d data:%n", i +1);

			System.out.print("Natural Person or Legal Entity? (p/e) ");

			char ch = sc.next().charAt(0);

			if (ch == 'p' | ch == 'P'){
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.print("Anual income: ");
				double anualIncome= sc.nextDouble();

				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				NaturalPerson person = new NaturalPerson(name, anualIncome, healthExpenditures);
				payerList.add(person);
			}

			else if (ch == 'e' | ch == 'E') {
				System.out.print("Company name: ");
				sc.nextLine();
				String companyName = sc.nextLine();

				System.out.print("Anual company income: ");
				double anualIncome= sc.nextDouble();

				System.out.print("Number of employees: ");
				int employeesNumber = sc.nextInt();

				JuridicPerson company = new JuridicPerson(companyName, anualIncome, employeesNumber);
				payerList.add(company);

			}

			else{
				System.out.println("Invalid entry");
				System.out.println("EXITING NOW");
				break;
			}
		System.out.println("");
		}

		System.out.println("");
		System.out.println("TAXES PAID");
		double totalTaxes = 0.0;

		for (AbstractPerson payer : payerList){

			System.out.printf("%s $ %.2f%n", payer.getName(), payer.incomeTax());
			totalTaxes += payer.incomeTax(); 

		}
			
		System.out.println("");
		System.out.printf("TOTAL TAXES: $ %.2f%n", totalTaxes);
	}


	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter exercise number: ");
		int exercise = sc.nextInt();
		
		switch (exercise) {

		case 1:
		    exercise1(sc);

	    break;

		case 2:
		    exercise2(sc);
		    break;
		    
		case 3:
			exercise3(sc);
			break;
			
		case 4:
			exercise4(sc);
			break;
			
		case 5:
			exercise5(sc);
			break;
			
		case 6:
			exercise6(sc);
			break;
			
		case 7:
			exercise7(sc);
			break;
			
		case 8:
			exercise8(sc);
			break;
			
		case 9:
			exercise9(sc);
			break;
			
		case 10:
			exercise10(sc);
			break;
			
		case 11:
			exercise11(sc);
			break;
			
		case 12:
			exercise12(sc);
			break;
			
		case 13:
			exercise13(sc);
			break;
		
		case 14:
			exercise14(sc);
			break;
			
		case 15:
			// Matrizes
			exercise15(sc);
			break;
			
		case 16:
			// Tipos enumerados
			exercise16(sc);
			break;
		
		case 17:
			// Herança e polimorfismo
			exercise17(sc);
			break;

		case 18:
			// Abstração
			exercise18(sc);
			break;

		default:
			System.out.println("No exercise with this numbering!");
		    break;
		}

		sc.close();
	}

}
