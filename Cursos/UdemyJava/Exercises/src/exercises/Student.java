package exercises;

public class Student {
	public String name;
	public double grade1;
	public double grade2;
	public double grade3;

	
	public double Mean() {
		double mean = ((grade1*30 + grade2*35 + grade3*35)/100);
		return mean;
	}
}
