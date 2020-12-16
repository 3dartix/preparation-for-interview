package lesson1.task2;

abstract class Car implements Control {
    private Engine engine;
    private String color;
    private String name;

    Car(Engine engine) {
        this.engine = engine;
    }

    public void move() {
        System.out.println("Car is moving");
    }

    public void open() {
        System.out.println("Car is open");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    public Engine getEngine() {
        return engine;
    }
}
