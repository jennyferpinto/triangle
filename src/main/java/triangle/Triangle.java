package triangle;
import java.util.*;

public class Triangle {

	private int[] t = new int[3];
	private Boolean isScalene = false;
	private Boolean isEquilateral = false;
	private Boolean isIsosceles = false;

	public Triangle(int a, int b, int c) {
		// check to see if dimensions make a legal triangle before calling constructors
		if (a + b > c && a + c > b && b + c > a) {
			this.t[0] = a;
			this.t[1] = b;
			this.t[2] = c;
			this.isEquilateral = isEquilateral(this);
			this.isIsosceles =  isIsosceles(this);
			this.isScalene = isScalene(this);
		} else {	
		throw new java.lang.Error("Not a triangle!");
		}
	}

	public int[] getDimensions() {
		return t;
	}

	public Boolean getEquilateralProperty() {
		return isEquilateral;
	}

	public Boolean getScaleneProperty() {
		return isScalene;
	}

	public Boolean getIsoscelesProperty() {
		return isIsosceles;
	}

	private Boolean isEquilateral(Triangle triangle) {
		if (triangle.t[0] == triangle.t[1] && triangle.t[0] == triangle.t[2]) {
			return true;
		}
		return false;
	}
	
	private Boolean isIsosceles(Triangle triangle) {
		if (triangle.isEquilateral) { // every equilateral triangle is isosceles
			return true; 
		} else if (triangle.t[0] == triangle.t[1] || triangle.t[0] == triangle.t[2] || triangle.t[1] == triangle.t[2]) {
			return true;
		}
		return false;
	}

	private Boolean isScalene(Triangle triangle) {
		if (triangle.isEquilateral) { // if triangle is isoscles then can't be equilateral
			return false;
		} else if (triangle.t[0] != triangle.t[1] && triangle.t[0] != triangle.t[2] && triangle.t[1] != triangle.t[2]) {
			return true;
		}
		return false;
	}

	public String returnFormattedResults() {
		StringBuilder builder = new StringBuilder();

		builder.append(String.format("%s = %b, ", "equilateral", this.isEquilateral));
		builder.append(String.format("%s = %b, ", "isosceles", this.isIsosceles));
		builder.append(String.format("%s = %b", "scalene", this.isScalene));

		return builder.toString();
	}

	public static void main(String[] args) {

		int[] inputs = new int[3];

		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter 3 numbers representing a triangle's dimensions: ");

		for (int i = 0; i < 3; i++) {
			int x = reader.nextInt();
			inputs[i] = x;
		}

		Triangle t = new Triangle(inputs[0], inputs[1], inputs[2]);

		System.out.println(Arrays.toString(t.getDimensions()));
		System.out.println(t.returnFormattedResults());

		reader.close();
	}
}