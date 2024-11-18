package ru.otus.java.basic.homeworks.hw13;

public class Horse implements Moving {
    private final String name;
    private int energy;

    public Horse(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public boolean Move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.SWAMP) {
            System.out.println("По такой местности лошадь не скачет");
            return false;
        }
        if (energy < distance) {
            System.out.println("На путь в " + distance + " не хватит сил");
            return false;
        }
        energy = energy - distance;
        System.out.println("Путь в " + distance + " преодолен");
        return true;
    }

    @Override
    public void getTransportInfo() {
        System.out.println("Лошадь по кличке: " + name + "; запас сил: " + energy);
    }
}
