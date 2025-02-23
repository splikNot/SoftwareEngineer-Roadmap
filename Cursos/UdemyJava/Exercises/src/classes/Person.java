package classes;

public class Person {
	private String name;
	private int age;
	private double height;
	private char gender;
	private boolean ageFlag = true;
	
	
	
	public Person (String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
		checkAge();
	}
	
	public Person (double height, char gender) {
		this.name = null;
		this.age = 0;
		this.height = height;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public boolean getFlag() {
		return ageFlag;
	}
	
	public void setFlag(boolean flag) {
		ageFlag = flag;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void checkAge() {
		
		if (getAge() < 16) {
			setFlag(false);
		}
	}
	
	
}
