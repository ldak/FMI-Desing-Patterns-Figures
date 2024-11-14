package figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    void testSidesValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(1, 2, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(3, 2, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(1, 3, 2);
        });
    }

    @Test
    void testPositiveSidesValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(-1, 2, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(3, -2, 1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(1, 3, -2);
        });
    }

    @Test
    void testDoubleOverflowValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(3, Double.MAX_VALUE, Double.MAX_VALUE);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(Double.MAX_VALUE, 3, Double.MAX_VALUE);
        });
    }

    @Test
    void testPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        assert(triangle.getPerimeter() == 12);
    }

    @Test
    void testToString() {
        Triangle triangle = new Triangle(3, 4, 5);
        assert(triangle.toString().equals("Triangle 3.0 4.0 5.0"));
    }

    @Test
    void testClone() {
        Triangle triangle = new Triangle(3, 4, 5);
        Figure clone = triangle.clone();
        assert(triangle.toString().equals(clone.toString()));
        assert(triangle != clone);
        assert(triangle.getPerimeter() == clone.getPerimeter());
    }

}
