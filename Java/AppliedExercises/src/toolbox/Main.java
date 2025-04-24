package toolbox;

import abstractions.Order;
import abstractions.Post;
import abstractions.Worker;
import entities.Account;
import entities.Client;
import entities.Comment;
import entities.Department;
import entities.Employee;
import entities.OrderItem;
import entities.OutSourcedEmployee;
import entities.Product;
import entities.enums.OrderStatus;
import entities.enums.WorkerLevel;
import entities.exceptions.WithdrawException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    static {Locale.setDefault(Locale.US);}

    public static void appliedExercise1(Scanner sc) throws ParseException{

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data: ");
    
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        // WorkerLever é um tipo enumerado, então precisa ser passado no construtor como tal
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        // WorkerLevel.valueOf(workerLevel)
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
        new Department(departmentName));

        
        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i=0 ; i < n ; i++){

            System.out.printf("Enter contract #%d data: %n", i+1);
            
            System.out.print("Date (DD,MM,YYYY): ");
            // Transformar a String em data
            Date contractDate = sdf.parse(sc.next());
            
            System.out.print("Value per hour: ");
            double value = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, value, hours);
            worker.addContract(contract);

            System.out.println();
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        
        // Convertendo a string para inteiros
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + workerName);
        System.out.println("Department: " + worker.getDepartament().getName());

        System.out.printf("Income for %s: %.2f%n", monthAndYear, worker.income(year, month));

    }

    private static void appliedExercise2() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        

        Comment c1 = new Comment("Cansado demais");
        Comment c2 = new Comment("Jogar Rocket League ou Need for Speed?");
        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"),
        "Boring", "É carnaval e estou no tédio", 12);

        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1);
    }

    public static void appliedExercise3(Scanner sc) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        

        System.out.println("Enter client data: ");

        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        System.out.println();

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");

        // Não faz sentido o status precisar ser inserido se um pedido não pode existir sem ser iniciado.
        // Moscou Hélio
        System.out.print("Status: ");
        String status = sc.next();
        //WorkerLevel.valueOf(workerLevel)
        
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        LocalDateTime moment = LocalDateTime.now();

        Order order = new Order(client, moment ,OrderStatus.valueOf(status));
        
        for (int i=0; i<n ; i++){
            System.out.println();

            System.out.printf("Enter #%d item data:%n", i+1);
            sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantityProduct = sc.nextInt();

            OrderItem orderItem = new OrderItem(product, quantityProduct);
            order.addItem(orderItem);

        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);
    }

    public static void appliedExercise4(Scanner sc){

        List<Employee> employeeList = new ArrayList<>();



        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        System.out.println();


        for (int i = 0; i < n; i++){

            System.out.printf("Employee #%d data:%n", i+1 );
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 'y' | ch == 'Y'){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                Employee emp = new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge);
                employeeList.add(emp);
            }

            else if (ch == 'n' | ch == 'N'){
                Employee emp = new Employee(name, hours, valuePerHour);
                employeeList.add(emp);
                
            }

            else{
                System.out.println("Invalid Entry!");
                System.out.println("Exiting now");
                break;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("PAYMENTS");

        for (Employee emp : employeeList){
            System.out.printf("%s - $ %.2f%n", emp.getName(), emp.payment());
        }

    }

    private static void appliedExercise5(Scanner sc){

        try {
            System.out.println("Enter account data:");
        
            System.out.print("Number: ");
            int number = sc.nextInt();

            System.out.print("Holder: : ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();
            
            System.out.print("Withdraw limit: ");
            Double limit = sc.nextDouble();

            Account acc = new Account(holder, number, balance, limit);

            System.out.println();

        
            System.out.print("Enter amount to withdraw: ");
            Double newWithdraw = sc.nextDouble();

            acc.withdraw(newWithdraw);
            System.out.printf("New balance: %.2f%n8021", acc.getBalance());
        }
        
        // NO programa principal eu apenas trato as exceçoes
        catch (WithdrawException e){
            System.out.println("Above withdraw limit: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpect Value");
        }


    }


    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws ParseException {

        Scanner sc  = new Scanner(System.in);

        System.out.print("Enter exercise number: ");
        int exercise = sc.nextInt();

        switch (exercise) {

        case 1:
            appliedExercise1(sc);
            break;
        
        case 2:
            appliedExercise2();
            break;
        
        case 3:
            appliedExercise3(sc);
            break;

        case 4:
            // Herança
            appliedExercise4(sc);
            break;
        
        case 5:
            // Tratamento de Exceções
            appliedExercise5(sc);
            break;

        default:
            System.out.println("No exercise with this numbering");
            break;
        }

        sc.close();

    }

}
