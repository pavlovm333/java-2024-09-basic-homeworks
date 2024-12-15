package ru.otus.java.basic.homeworks.hw22;

public class TimeMeasuring {
    private static long time;

    public static void stamp() {
        time = System.currentTimeMillis();
    }

    public static long stampsDiff() {
        return System.currentTimeMillis() - time;
    }
}
