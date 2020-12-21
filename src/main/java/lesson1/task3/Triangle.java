package lesson1.task3;

public class Triangle extends Shape {
    private double leg;

    public Triangle(String name, double a, double b) {
        super(name, a, b);
        leg = Math.min(a, b);
    }

    public double getSquare() {
        return leg * leg / 2;
    }
}
