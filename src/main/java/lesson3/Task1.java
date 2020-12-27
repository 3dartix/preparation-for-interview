package lesson3;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
public class Task1 {

    static final Object monitor = new Object();
    static boolean check = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (monitor) {
                    while (true){
                        if(!check) {
                            monitor.wait();
                        }
                        Thread.sleep(1000);
                        System.out.println("ping");
                        check = false;
                        monitor.notify();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (monitor) {
                    while (true){
                        if(check) {
                            monitor.wait();
                        }
                        Thread.sleep(1000);
                        System.out.println("pong");
                        check = true;
                        monitor.notify();
                    }

                }
            }
        }).start();
    }
}
