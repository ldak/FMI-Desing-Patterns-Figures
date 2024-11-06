package figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleTest {

    @Test
    void testPositiveSidesValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(-1);
        });
    }

    @Test
    void testDoubleOverflowValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(Double.MAX_VALUE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(Double.POSITIVE_INFINITY);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle((Double.MAX_VALUE / (2 * Math.PI)) * 2);
        });
    }

    @Test
    void testPerimeter() {
        Circle circle = new Circle(3);
        assert(circle.getPerimeter() == 3 * 2 * Math.PI);
    }

    @Test
    void testToString() {
        Circle circle = new Circle(3);
        assert(circle.toString().equals("Circle 3.0"));
    }

    @Test
    void testClone() {
        Circle circle = new Circle(3);
        Figure clone = circle.clone();
        assert(circle.toString().equals(clone.toString()));
        assert(circle != clone);
        assert(circle.getPerimeter() == clone.getPerimeter());
    }
}
