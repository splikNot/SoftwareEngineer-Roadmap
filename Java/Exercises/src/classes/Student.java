package classes;

public class Student {
	public String name;
	public double grade1 = 0.0;
	public double grade2 = 0.0;
	public double grade3 = 0.0;
	
	
	public Student() {
		
	}
	
	public Student(String name, double grade1, double grade2) {
		this.name = name;
		this.grade1 = grade1;
		this.grade2 = grade2;
	}

	public double finalMean() {
		double finalGrade = (grade1 + grade2) / 2;
		return finalGrade;
	}
	
	public double Mean() {
		double mean = ((grade1*30 + grade2*35 + grade3*35)/100);
		return mean;
	}
	
	public String getName() {
		return name;
	}
}
