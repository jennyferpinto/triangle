package main.java.triangle;

public class Tests {

    @Test
    public void isScaleneReturnsTrue() {
        Triangle t = new Triangle(3,4,5); 
        // assert statements
        assertEquals(true, t.isScalene(), "should return true");
        assertEquals(false, t.isEquilateral(), "should return false");
        assertEquals(false, t.isIsosceles(), "should return false");
    }
}
