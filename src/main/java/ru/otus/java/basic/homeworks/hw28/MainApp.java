package ru.otus.java.basic.homeworks.hw28;

public class MainApp {
    public static void main(String[] args) {

        Box<Fruit> boxAnyFruit1 = new Box<>();
        Box<Apple> boxApple1 = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();

        Box<Fruit> boxAnyFruit2 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        boxApple1.addFruit(new Apple(1));
        boxApple1.addFruit(new Apple(2));
        boxApple1.addFruit(new Apple(2));

        boxAnyFruit1.addFruit(new Apple(2));
        boxAnyFruit1.addFruit(new Orange(3));

        boxOrange1.addFruit(new Orange(4));
        boxOrange1.addFruit(new Orange(3));

        boxApple2.addFruit(new Apple(1));
        boxApple2.addFruit(new Apple(2));
        boxApple2.addFruit(new Apple(2));

        boxAnyFruit2.addFruit(new Apple(2));
        boxAnyFruit2.addFruit(new Orange(3));

        boxOrange2.addFruit(new Orange(4));
        boxOrange2.addFruit(new Orange(3));

        System.out.println("Bec коробки 1 с яблоками: " + boxApple1.weight());
        System.out.println("Bec коробки 1 с фруктами (яблоки или апельсины): " + boxAnyFruit1.weight());
        System.out.println("Bec коробки 1 с апельсинами: " + boxOrange1.weight());

        System.out.println("Результат сравнения коробки 1 с яблоками и коробки 1 с фруктами (яблоки или апельсины): " + boxApple1.compare(boxAnyFruit1));
        System.out.println("Результат сравнения коробки 1 с яблоками и коробки 1 с апельсинами: " + boxApple1.compare(boxOrange1) + "\n");

        System.out.println("Пересыпаем из коробки 1 с яблоками в коробку 2 с яюблоками");
        boxApple1.empty(boxApple2);
        System.out.println("Bec коробки 1 с яблоками: " + boxApple1.weight());
        System.out.println("Bec коробки 2 с яблоками: " + boxApple2.weight() + "\n");

        System.out.println("Пересыпаем из коробки 1 с фруктами (яблоки или апельсины) в коробку 2 с фруктами (яблоки или апельсины)");
        boxAnyFruit1.empty(boxAnyFruit2);
        System.out.println("Bec коробки 1 с фруктами (яблоки или апельсины): " + boxAnyFruit1.weight());
        System.out.println("Bec коробки 2 с фруктами (яблоки или апельсины): " + boxAnyFruit2.weight() + "\n");

        System.out.println("Пересыпаем из коробки 1 с апельсинами в коробку 1 с фруктами (яблоки или апельсины)");
        boxOrange1.empty(boxAnyFruit1);
        System.out.println("Bec коробки 1 с апельсинами: " + boxOrange1.weight());
        System.out.println("Bec коробки 1 с фруктами (яблоки или апельсины): " + boxAnyFruit1.weight());
    }
}
