package triangle;
import java.util.*;

public class Triangle {

	private int[] dimensions = new int[3];
	private Boolean isScalene = false;
	private Boolean isEquilateral = false;
	private Boolean isIsosceles = false;

	public Triangle(int a, int b, int c) {

		if ( a < 0 || b < 0 || c < 0 ) {
			throw new IllegalArgumentException("Dimensions must form a legal triangle!");
		} else {
			setDimensions(a, b, c);
		}
	}

	public int[] getDimensions() {
		return this.dimensions;
	}

	public void setDimensions(int a, int b, int c) {
		// assertion to check that the updated dimensions make a legal triangle

		if (isLegalTriangle(a, b, c)) {
			this.dimensions[0] = a;
			this.dimensions[1] = b;
			this.dimensions[2] = c;
			updateTriangleProperties();
		} else {
			throw new IllegalArgumentException("Dimensions must form a legal triangle!");
		}
	}

	private void updateTriangleProperties() {
		setEquilateralProperty(this.isEquilateral());
		setIsoscelesProperty(this.isIsosceles());
		setScaleneProperty(this.isScalene());
	}

	public Boolean getEquilateralProperty() {
		return this.isEquilateral;
	}

	private void setEquilateralProperty(Boolean b) {
		this.isEquilateral = b;
	}

	public Boolean getScaleneProperty() {
		return this.isScalene;
	}

	private void setScaleneProperty(Boolean b) {
		this.isScalene = b;
	}

	public Boolean getIsoscelesProperty() {
		return this.isIsosceles;
	}

	private void setIsoscelesProperty(Boolean b) {
		this.isIsosceles = b;
	}

	private Boolean isLegalTriangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isEquilateral() {
		if (this.dimensions[0] == this.dimensions[1] && this.dimensions[0] == this.dimensions[2]) {
			// can skip last combination of triangle sides due to mathematical property of transitivity 
			return true;
		}
		return false;
	}
	
	public Boolean isIsosceles() {
		if (this.isEquilateral) { // every equilateral triangle is isosceles so can skip additional check
			return true; 
		} else if (this.dimensions[0] == this.dimensions[1] || this.dimensions[0] == this.dimensions[2] || this.dimensions[1] == this.dimensions[2]) {
			return true;
		}
		return false;
	}

	public Boolean isScalene() {
		if (this.isEquilateral) { // if triangle is equilateral then it cannot be scalene so can skip additional check
			return false;
		} else if (this.dimensions[0] != this.dimensions[1] && this.dimensions[0] != this.dimensions[2] && this.dimensions[1] != this.dimensions[2]) {
			return true;
		}
		return false;
	}

	public String returnFormattedResults() {
		StringBuilder builder = new StringBuilder(); 

		builder.append(String.format("%s = %b, ", "equilateral", this.isEquilateral));
		builder.append(String.format("%s = %b, ", "isosceles",this.isIsosceles));
		builder.append(String.format("%s = %b", "scalene", this.isScalene));

		return builder.toString();
	}

	public static void main(String[] args) {

		int[] inputs = new int[3];

		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter 3 integers representing a triangle's dimensions: ");

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