package ru.otus.java.basic.homeworks.hw22;

public class MainApp {
    private static double[] array = new double[100_000_000];

    public static void main(String[] args) throws InterruptedException {
        TimeMeasuring.stamp();
        fillArray();
        System.out.println("Время выполнения 1-ой реализации (сек.): " + TimeMeasuring.stampsDiff()/1000d);

        TimeMeasuring.stamp();
        Runnable r0 = new RunnableWithParam(array, 0);
        Thread thread0 = new Thread(r0);
        thread0.start();

        Runnable r1 = new RunnableWithParam(array, 1);
        Thread thread1 = new Thread(r1);
        thread1.start();

        Runnable r2 = new RunnableWithParam(array, 2);
        Thread thread2 = new Thread(r2);
        thread2.start();

        Runnable r3 = new RunnableWithParam(array, 3);
        Thread thread3 = new Thread(r3);
        thread3.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Время выполнения 2-ой реализации (сек.): " + TimeMeasuring.stampsDiff()/1000d);

    }

    public static void fillArray() {
        for(int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

}
