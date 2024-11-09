package ru.otus.java.basic.homeworks.hw11;

public class MainApp {

    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 13, 400, "кот");
        cat.info();
        System.out.println();

        Dog dog = new Dog("Шарик", 14, 300, "собака", 1);
        dog.info();
        System.out.println();

        Horse horse = new Horse("Стихия", 16, 600, "лошадь", 2);
        horse.info();
        System.out.println();

        int res;
        int distance;
        distance = 180;
        res = horse.run(distance);
        if (res == -1) {
            System.out.println(horse.getName() + " устала");
        } else {
            System.out.println(horse.getName() + " пробежала " + distance + " м. за " + res + " секунд");
        }
        horse.info();
        System.out.println();

        res = cat.run(distance);
        if (res == -1) {
            System.out.println(cat.getName() + " устал");
        } else {
            System.out.println(cat.getName() + " пробежал " + distance + " м. за " + res + " секунд");
        }
        cat.info();
        System.out.println();

        res = dog.run(distance);
        if (res == -1) {
            System.out.println(dog.getName() + " устал");
        } else {
            System.out.println(dog.getName() + " пробежал " + distance + " м. за " + res + " секунд");
        }
        dog.info();
        System.out.println();

        distance = 10;
        res = horse.swim(distance);
        if (res == -1) {
            System.out.println(horse.getName() + " устала");
        } else {
            System.out.println(horse.getName() + " проплыла " + distance + " м. за " + res + " секунд");
        }
        horse.info();
        System.out.println();

        res = dog.swim(distance);
        if (res == -1) {
            System.out.println(dog.getName() + " устал");
        } else {
            System.out.println(dog.getName() + " проплыл " + distance + " м. за " + res + " секунд");
        }
        dog.info();

    }

}
