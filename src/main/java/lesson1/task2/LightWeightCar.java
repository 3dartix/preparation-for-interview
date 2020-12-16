package lesson1.task2;

public class LightWeightCar extends Car {
    public LightWeightCar(Engine engine) {
        super(engine);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
