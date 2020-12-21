package lesson1.task3;

public class Circle extends Shape {
    private double diameter;

    public Circle(String name, double a, double b) {
        super(name, a, b);
        diameter = Math.min(a, b);
    }

    public double getSquare() {
        return Math.PI * diameter;
    }
}
