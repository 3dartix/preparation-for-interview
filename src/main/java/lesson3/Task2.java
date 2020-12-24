package lesson3;

import lombok.extern.java.Log;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Log
public class Task2 {

    static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for(int i=0; i<200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }
        Thread.sleep(1000);

        System.out.println("Counter:" + counter.getCounter());
    }


    static class Counter {
        private long counter = 0L;

        public void increaseCounter() {
            lock.lock();
            counter++;
            lock.unlock();
        }

        public long getCounter() {
            return counter;
        }
    }

    static class CounterThread extends Thread {
        private Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for(int i=0; i < 1000; i++) {
                counter.increaseCounter();
            }
        }
    }

}