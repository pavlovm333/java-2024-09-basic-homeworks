package ru.otus.java.basic.homeworks.hw3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        greetings();
        checkSign(0,1,0);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(10, 15, false);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        int result;
        while (true) {
            result = scanner.nextInt();
            if (result >= 1 && result <= 5) {
                break;
            }
            else {
                System.out.println("Повторите ввод");
            }
        }
        if (result == 1) {
            greetings();
        }
        else if (result == 2) {
            int a = generateInt(-100, 100);
            int b = generateInt(-100, 100);
            int c = generateInt(-100, 100);
            checkSign(a, b, c);
        }
        else if (result == 3) {
            selectColor();
        }
        else if (result == 4) {
            compareNumbers();
        }
        else {
            int initValue = generateInt(-100, 100);
            int delta = generateInt(-100, 100);
            boolean increment = generateInt(0, 2) == 1;
            addOrSubtractAndPrint(initValue, delta, increment);
        }
    }

    public static void greetings() {
        System.out.println("Вызов greetings()");
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
        System.out.println();
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println("Вызов checkSign(" + a + "," + b + "," + c + ")");
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();
    }

    public static void selectColor() {
        System.out.println("Вызов selectColor()");
        int data = 10;
        if (data <= 10) {
            System.out.println("Красный");
        }
        else if (data <= 20) {
            System.out.println("Жёлтый");
        }
        else {
            System.out.println("Зелёный");
        }
        System.out.println();
    }

    public static void compareNumbers() {
        System.out.println("Вызов compareNumbers()");
        int a = 10;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
        System.out.println();
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("Вызов addOrSubtractAndPrint(" + initValue + "," + delta + "," + increment + ")");
        if (increment) {
            System.out.println(initValue + delta);
        }
        else {
            System.out.println(initValue - delta);
        }
        System.out.println();
    }

    public static int generateInt(int min, int max) {
        return min + (int)(Math.random() * (max - min));
    }
}

