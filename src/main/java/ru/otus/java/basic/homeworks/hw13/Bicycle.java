package ru.otus.java.basic.homeworks.hw13;

public class Bicycle implements Moving {
    @Override
    public boolean Move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("По такой местности велосипед не едет");
            return false;
        }
        System.out.println("Путь в " + distance + " преодолен");
        return true;
    }
    public void getTransportInfo() {
        System.out.println("Велосипед");
    }
}
