package ru.otus.java.basic.homeworks.hw13;

public class OffRoadVehicle implements Moving {
    private final int fuelTankCapacity;
    private int currentFuelLlevel;

    public OffRoadVehicle(int fuelTankCapacity, int currentFuelLlevel) {
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
        System.out.println("Вездеход: объем топливного бака: " + fuelTankCapacity + "; текущий объем топлива: " + currentFuelLlevel);
    }
}



