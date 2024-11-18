package ru.otus.java.basic.homeworks.hw13;

public class App {
    public static void main(String[] args) {
        Human human = new Human("Путешественник", 200);

        Car car = new Car(100, 100);
        Bicycle bicycle = new Bicycle();
        Horse horse = new Horse("Рыжуха", 300);
        OffRoadVehicle offRoadVehicle = new OffRoadVehicle(100, 100);

        human.info();
        human.Move(10, TerrainType.FLATLAND);
        System.out.println();

        human.setCurrentTransport(car);
        human.info();
        System.out.println();
        human.Move(10, TerrainType.SWAMP);
        human.info();
        System.out.println();
        human.Move(10, TerrainType.FLATLAND);
        human.info();
        System.out.println();

        human.setEmptyCurrentTransport();
        human.info();
        System.out.println();

        human.setCurrentTransport(bicycle);
        human.info();
        human.Move(10, TerrainType.SWAMP);
        System.out.println();
        human.info();
        human.Move(10, TerrainType.FLATLAND);
        human.info();
        System.out.println();

        human.setCurrentTransport(horse);
        human.info();
        human.Move(100, TerrainType.DENSE_FORST);
        human.info();
        System.out.println();

        human.setCurrentTransport(offRoadVehicle);
        human.info();
        System.out.println();
        human.Move(10, TerrainType.SWAMP);
        human.info();
    }

}
