package figures.factories;

import figures.Circle;
import figures.Figure;
import figures.Rectangle;
import figures.Triangle;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import static org.junit.jupiter.api.Assertions.*;

public class StringFigureFactoryTest {

    @Test
    public void testCreateTriangle() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "Triangle 2.0 2.0 3.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Triangle.class, figure);
        assertEquals(input, figure.toString());
        assertEquals(7, figure.getPerimeter());
    }

    @Test
    public void testCreateTriangleWithSpaces() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "Triangle 2.0  2.0 3.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Triangle.class, figure);
        assertEquals("Triangle 2.0 2.0 3.0", figure.toString());
        assertEquals(7, figure.getPerimeter());
    }

    @Test
    public void testCreateTriangleWithTabs() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "Triangle 2.0\t2.0\t3.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Triangle.class, figure);
        assertEquals("Triangle 2.0 2.0 3.0", figure.toString());
        assertEquals(7, figure.getPerimeter());
    }

    @Test
    public void testCreateTriangleWithInvalidSides() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "triangle 2.0 2.0 0.0";

        assertThrows(IllegalArgumentException.class, () -> factory.createFigure(input));
    }

    @Test
    public void testCreateTriangleWithInvalidInput() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "triangle 2.0 2.0";

        assertThrows(IllegalArgumentException.class, () -> factory.createFigure(input));
    }

    @Test
    public void testCreateRectangle() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "rectangle 2.0 3.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertEquals("Rectangle 2.0 3.0", figure.toString());
        assertEquals(10, figure.getPerimeter());
    }

    @Test
    public void testCreateRectangleWithSpaces() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "rectangle 2.0  3.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertEquals("Rectangle 2.0 3.0", figure.toString());
        assertEquals(10, figure.getPerimeter());
    }

    @Test
    public void testCreateRectangleWithTabs() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "rectangle 2.0\t3.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Rectangle.class, figure);
        assertEquals("Rectangle 2.0 3.0", figure.toString());
        assertEquals(10, figure.getPerimeter());
    }

    @Test
    public void testCreateRectangleWithInvalidSides() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "rectangle 2.0 0.0";

        assertThrows(IllegalArgumentException.class, () -> factory.createFigure(input));
    }

    @Test
    public void testCreateRectangleWithInvalidInput() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "rectangle 2.0";

        assertThrows(IllegalArgumentException.class, () -> factory.createFigure(input));
    }

    @Test
    public void testCreateCircle() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "circle 2.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Circle.class, figure);
        assertEquals("Circle 2.0", figure.toString());
        assertEquals(2*2*Math.PI, figure.getPerimeter());
    }

    @Test
    public void testCreateCircleWithSpaces() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "circle  2.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Circle.class, figure);
        assertEquals("Circle 2.0", figure.toString());
        assertEquals(2*2*Math.PI, figure.getPerimeter());
    }

    @Test
    public void testCreateCircleWithTabs() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "circle\t2.0";

        Figure figure = factory.createFigure(input);

        // Assert
        assertInstanceOf(Circle.class, figure);
        assertEquals("Circle 2.0", figure.toString());
        assertEquals(2*2*Math.PI, figure.getPerimeter());
    }

    @Test
    public void testCreateCircleWithInvalidRadius() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "circle 0.0";

        assertThrows(IllegalArgumentException.class, () -> factory.createFigure(input));
    }

    @Test
    public void testCreateCircleWithInvalidInput() {
        // Arrange
        StringFigureFactory factory = new StringFigureFactory(new FigureReflectionFacade());
        String input = "circle";

        assertThrows(IllegalArgumentException.class, () -> factory.createFigure(input));
    }
}
