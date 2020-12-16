package lesson1.task2;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        LightWeightCar lightWeightCar = new LightWeightCar(new Engine());
        lightWeightCar.open();
        lightWeightCar.move();
        lightWeightCar.stop();

        Lorry lorry = new Lorry(new Engine());
        lorry.open();
        lorry.move();
        lorry.stop();
    }
}
