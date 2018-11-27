package triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class Tests {

    @Test
    public void scaleneIsTrue() {
        Triangle t = new Triangle(3,4,5);
        assertEquals(true, t.getScaleneProperty(),  "should return true");
        assertEquals(false, t.getEquilateralProperty(),"should return false");
        assertEquals(false, t.getIsoscelesProperty(), "should return false");
    }

    @Test
    public void equilateralAndIsoscelesisTrue() {
        Triangle t = new Triangle(5,5,5); 

        assertEquals(true, t.getEquilateralProperty(), "should return true");
        assertEquals(true, t.getIsoscelesProperty(), "should return true");
        assertEquals(false, t.getScaleneProperty(), "should return false");
    }

    @Test
    public void isoscelesIsTrue() {
        Triangle t = new Triangle(3,4,4); 

        assertEquals(true, t.getIsoscelesProperty(), "should return true");
        assertEquals(false, t.getEquilateralProperty(), "should return false");
        assertEquals(false, t.getScaleneProperty(), "should return false");
    }
}
