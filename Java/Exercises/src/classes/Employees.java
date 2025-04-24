package classes;

public class Employees {
	public String name = "";
	public double grossSalary = 0;
	public double tax = 0;
	
	public double NetSalary() {
		double netSalary = grossSalary - tax;
		return netSalary;
	}
	
	public void IncreseSalary(double percentage) {
		double increase = grossSalary + (percentage/100)*grossSalary;
		grossSalary = increase;
	}
	
	public String toString() {
		return name + ", $" + String.format("%.2f", NetSalary());
	}
	
}
