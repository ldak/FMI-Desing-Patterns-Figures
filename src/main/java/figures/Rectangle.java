package figures;

public class Rectangle extends AbstractFigure{
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
        if (width > Double.MAX_VALUE / 2 || height > Double.MAX_VALUE / 2 || width > Double.MAX_VALUE - height) {
            throw new IllegalArgumentException("Sides are too big");
        }
        this.width = width;
        this.height = height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return "Rectangle " + width + " " + height;
    }
}
