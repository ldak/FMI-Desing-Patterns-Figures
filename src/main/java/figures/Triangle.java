package figures;

public class Triangle extends AbstractFigure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Not a triangle");
        }
        if (a > Double.MAX_VALUE - b && a + b > Double.MAX_VALUE - c) {
            throw new IllegalArgumentException("Perimeter is too large");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle " + a + " " + b + " " + c;
    }
}
