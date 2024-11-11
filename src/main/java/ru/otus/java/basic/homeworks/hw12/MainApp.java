package ru.otus.java.basic.homeworks.hw12;

public class MainApp {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("Барсик", 10), new Cat("Бармалей", 15),
                new Cat("Бегемот", 20), new Cat("Шнурок", 7)};

        Plate plate = new Plate(25);

        cat[0].eatingTry(plate);
        cat[0].info();
        System.out.println("Осталось единиц еды - " + plate.getCurFoodAmount());

        cat[1].eatingTry(plate);
        cat[1].info();
        System.out.println("Осталось единиц еды - " + plate.getCurFoodAmount());

        cat[2].eatingTry(plate);
        cat[2].info();
        System.out.println("Осталось единиц еды - " + plate.getCurFoodAmount());

        plate.addFoodVolume(100);
        System.out.println("Осталось единиц еды - " + plate.getCurFoodAmount());
        cat[3].eatingTry(plate);
        cat[3].info();

    }
}
