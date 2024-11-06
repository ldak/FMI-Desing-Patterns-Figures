package figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @Test
    void testPositiveSidesValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(-1, 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(1, -2);
        });
    }

    @Test
    void testDoubleOverflowValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(Double.MAX_VALUE, 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(1, Double.MAX_VALUE);
        });
    }

    @Test
    void testPerimeter() {
        Rectangle rectangle = new Rectangle(3, 4);
        assert(rectangle.getPerimeter() == 14);
    }

    @Test
    void testToString() {
        Rectangle rectangle = new Rectangle(3, 4);
        assert(rectangle.toString().equals("Rectangle 3.0 4.0"));
    }

    @Test
    void testClone() {
        Rectangle rectangle = new Rectangle(3, 4);
        Figure clone = rectangle.clone();
        assert(rectangle.toString().equals(clone.toString()));
        assert(rectangle != clone);
        assert(rectangle.getPerimeter() == clone.getPerimeter());
    }

}
