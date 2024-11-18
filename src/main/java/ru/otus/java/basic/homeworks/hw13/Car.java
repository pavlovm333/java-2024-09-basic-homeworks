package ru.otus.java.basic.homeworks.hw13;

public class Car implements Moving {
    private final int fuelTankCapacity;
    private int currentFuelLlevel;

    public Car(int fuelTankCapacity, int currentFuelLlevel) {
        this.fuelTankCapacity = fuelTankCapacity;
        this.currentFuelLlevel = currentFuelLlevel;
    }

    public int getCurrentFuelLlevel() {
        return currentFuelLlevel;
    }

    public void setCurrentFuelLlevel(int currentFuelLlevel) {
        if (currentFuelLlevel >= fuelTankCapacity) {
            this.currentFuelLlevel = fuelTankCapacity;
        } else {
            this.currentFuelLlevel = currentFuelLlevel;
        }
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    @Override
    public boolean Move(int distance, TerrainType terrainType) {
        if (terrainType == TerrainType.DENSE_FORST || terrainType ==TerrainType.SWAMP) {
            System.out.println("По такой местности машина не перемещается");
            return false;
        }
        if (currentFuelLlevel < distance * 2) {
            System.out.println("На путь в " + distance + " не хватит топлива");
            return false;
        }
        currentFuelLlevel = currentFuelLlevel - distance * 2;
        System.out.println("Путь в " + distance + " преодолен");
        return true;
    }

    @Override
    public void getTransportInfo() {
        System.out.println("Автомобиль: объем топливного бака: " + fuelTankCapacity + "; текущий объем топлива: " + currentFuelLlevel);
    }
}
