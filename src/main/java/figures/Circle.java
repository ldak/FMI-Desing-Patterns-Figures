package figures;

public class Circle extends AbstractFigure{
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        if (radius > Double.MAX_VALUE / (2 * Math.PI)) {
            throw new IllegalArgumentException("Perimeter is too large");
        }
        this.radius = radius;
    }


    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        return "Circle " + this.radius;
    }

}
