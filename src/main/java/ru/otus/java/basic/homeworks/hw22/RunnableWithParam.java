package ru.otus.java.basic.homeworks.hw22;

public class RunnableWithParam implements Runnable {
    private final double[] array;
    private final int shift;

    public RunnableWithParam(double[] array, int shift) {
        this.array = array;
        this.shift = shift;
    }

    @Override
    public void run() {
        for(int i = shift * 25_000_000; i < 25_000_000 * shift + 25_000_000; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}
