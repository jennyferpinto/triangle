// Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, 
// and return whether the triangle is equilateral, isosceles or scalene. We are looking for solutions that showcase problem solving 
// skills and structural considerations that can be applied to larger and potentially more complex problem domains.
// Include a brief discussion of your design decisions and implementation choices.
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
		Triangle t1 = new Triangle(4,4,4);
		Triangle t2 = new Triangle(3,4,4);
		Triangle t3 = new Triangle(2,4,4);
		
		System.out.println(Arrays.toString(t1.getDimensions()));
		System.out.println(t1.returnFormattedResults());

		System.out.println(Arrays.toString(t2.getDimensions()));
		System.out.println(t2.returnFormattedResults());

		System.out.println(Arrays.toString(t3.getDimensions()));
		System.out.println(t3.returnFormattedResults());
	}
}