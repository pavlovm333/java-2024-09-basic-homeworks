package ru.otus.java.basic.homeworks.hw12;

public class Cat {
    private final String name;
    private int appetite;
    private boolean isFull;

    public boolean isFull() {
        return isFull;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void info() {
        if (isFull) {
            System.out.println("Кот " + name + " наелся");
        } else System.out.println("Кот " + name + " голодный");
    }

    public void eatingTry (Plate plate) {
        isFull = plate.reduceFoodVolume(appetite);
    }
}
