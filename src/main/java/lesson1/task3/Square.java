package lesson1.task3;

public class Square extends Shape {
    private double x;

    public Square(String name, double a, double b) {
        super(name, a, b);
        x = Math.min(a, b);
    }

    public double getSquare() {
        return x * x;
    }
}
