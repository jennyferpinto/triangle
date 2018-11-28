package triangle;
import java.util.*;

public class Triangle {

	private int[] t = new int[3];
	private Boolean isScalene = false;
	private Boolean isEquilateral = false;
	private Boolean isIsosceles = false;

	public Triangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			this.t[0] = a;
			this.t[1] = b;
			this.t[2] = c;
			this.isEquilateral = this.isEquilateral();
			this.isIsosceles =  this.isIsosceles();
			this.isScalene = this.isScalene();
		} else {	
			throw new IllegalArgumentException("Dimensions must form a legal triangle!");
		}
	}

	public int[] getDimensions() {
		return this.t;
	}

	public void setDimensions(int[] arr) {
		this.t[0] = arr[0];
		this.t[1] = arr[1];
		this.t[2] = arr[2];
	}

	public Boolean getEquilateralProperty() {
		return this.isEquilateral;
	}

	public void setEquilateralProperty(Boolean b) {
		this.isEquilateral = b;
	}

	public Boolean getScaleneProperty() {
		return this.isScalene;
	}

	public void setScaleneProperty(Boolean b) {
		this.isScalene = b;
	}

	public Boolean getIsoscelesProperty() {
		return this.isIsosceles;
	}

	public void setIsoscelesProperty(Boolean b) {
		this.isIsosceles = b;
	}

	public Boolean isEquilateral() {
		if (this.t[0] == this.t[1] && this.t[0] == this.t[2]) {
			// can skip last combination of triangle sides due to mathematical property of transitivity 
			return true;
		}
		return false;
	}
	
	public Boolean isIsosceles() {
		if (this.isEquilateral) { // every equilateral triangle is isosceles so can skip additional check
			return true; 
		} else if (this.t[0] == this.t[1] || this.t[0] == this.t[2] || this.t[1] == this.t[2]) {
			return true;
		}
		return false;
	}

	public Boolean isScalene() {
		if (this.isEquilateral) { // if triangle is equilateral then it cannot be scalene so can skip additional check
			return false;
		} else if (this.t[0] != this.t[1] && this.t[0] != this.t[2] && this.t[1] != this.t[2]) {
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