package ru.vasilyev.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private int counter;
    private int counter2;
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
                // throw new IllegalStateException();
            }
        };
        thread0.start();
        final MainConcurrency mainConcurrency = new MainConcurrency();

        new Thread(() -> {
            for (int i = 0; i < THREADS_NUMBER; i++) {
                mainConcurrency.inc2();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainConcurrency.inc();

            }
        }).start();

        System.out.println(thread0.getState());

        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);


        Thread thread = new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                mainConcurrency.inc();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                mainConcurrency.inc2();
            }
        });
        thread.start();
        threads.add(thread);

        Thread.sleep(5000);
        System.out.println(mainConcurrency.counter);
    }

    private void inc() {
        synchronized (this) {
            counter++;

        }

    }

    private void inc2() {
        synchronized (this) {
            counter2--;

        }
    }
}