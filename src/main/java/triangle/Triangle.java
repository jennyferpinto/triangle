// Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, 
// and return whether the triangle is equilateral, isosceles or scalene. We are looking for solutions that showcase problem solving 
// skills and structural considerations that can be applied to larger and potentially more complex problem domains.
// Include a brief discussion of your design decisions and implementation choices.
package main.java.triangle;
import java.util.*;

public class Triangle {

	private int[] t = new int[3];

	public Triangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			this.t[0] = a;
			this.t[1] = b;
			this.t[2] = c;
		} else {	
		throw new java.lang.Error("Not a triangle!");
		}
	}

	public int[] getDimensions() {
		return t;
	}

	public boolean isEquilateral() {
		if (t[0] == t[1] && t[0] == t[2]) {
			return true;
		}
		return false;
	}

	// every equilateral triangle is isosceles, but not every isosceles triangle is equilateral. 
	public boolean isIsosceles() {
		
		if (this.isEquilateral()) {
			return true;
		} else {
			if (t[0] == t[1] || t[0] == t[2]) {
				return true;
			}
		}
		return false;
	}

	public boolean isScalene() {
		if (t[0] != t[1] && t[0] != t[2]) {
			return true;
		}
		return false;
	}

	// public String checkTriangle() {
	// 	this.isIsosceles();
	// 	this.isScalene();

	// 	if (this.isEquilateral()) {

	// 	}
	// }

	public static void main(String[] args) {
		Triangle t = new Triangle(3,4,5);
		// Triangle t = new Triangle(3,4,4);
		System.out.println(Arrays.toString(t.getDimensions()));
		System.out.println("Is it equilateral? " + t.isEquilateral());
		System.out.println("Is it scalene? " + t.isScalene());
		System.out.println("Is it isosceles? " + t.isIsosceles());
	}
}