package triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void testisTriangleThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            Triangle t = new Triangle(1,2,3);
        });
    }  

    @Test
    void negativeTriangleDimensionThrowsError() {
        assertThrows(IllegalArgumentException.class, ()-> {
            Triangle t = new Triangle(2,-2,2);
        });
    } 
    
    @Test
    void updateWithIllegalDimensionsThrowsError() {
        assertThrows(IllegalArgumentException.class, ()-> {
            Triangle t = new Triangle(3, 4, 5);
            t.setDimensions(1,2,4);
        });
    }

    @Test
    void testPropertiesUpdated() {
        Triangle t = new Triangle(3,4,5);
        
        assertEquals(true, t.getScaleneProperty(),  "should return true");
        assertEquals(false, t.getEquilateralProperty(),"should return false");
        assertEquals(false, t.getIsoscelesProperty(), "should return false");
       
        t.setDimensions(5,5,5);

        assertEquals(true, t.getEquilateralProperty(), "should return true");
        assertEquals(true, t.getIsoscelesProperty(), "should return true");
        assertEquals(false, t.getScaleneProperty(), "should return false");
    }
}
