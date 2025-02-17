package exercises;

public class Triangle {
	
	public double base;
	public double height;
	
	public double area() {
		double area = (base*height)/2;
		return area;
		}
	
	public double diagonal() {
		double hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
		return hipotenusa;
	}
	
	public double perimeter() {
		return base + height + diagonal(); 
	}
	
	
	
	
	
	}