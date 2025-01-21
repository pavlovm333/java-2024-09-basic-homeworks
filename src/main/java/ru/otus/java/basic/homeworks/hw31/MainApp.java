package ru.otus.java.basic.homeworks.hw31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    private static int count = 0;
    public static void main(String[] args) {
        ExecutorService serv = Executors.newFixedThreadPool(3);
        serv.execute(() -> { printC(); });
        serv.execute(() -> { printA(); });
        serv.execute(() -> { printB(); });
        serv.shutdown();
    }

    public static synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (count != 0) {
                    MainApp.class.wait();
                }
                System.out.print("A");
                count++;
                MainApp.class.notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (count != 1) {
                    MainApp.class.wait();
                }
                System.out.print("B");
                count++;
                MainApp.class.notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (count != 2) {
                    MainApp.class.wait();
                }
                System.out.print("C");
                count = 0;
                MainApp.class.notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
