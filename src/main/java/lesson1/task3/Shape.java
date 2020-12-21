package lesson1.task3;

import lombok.Data;

@Data
abstract class Shape {
    private String name;
    protected double a;
    protected double b;

    public Shape(String name, double a, double b) {
        this.name = name;
        this.a = a;
        this.b = b;
    }

    public abstract double getSquare();
}
