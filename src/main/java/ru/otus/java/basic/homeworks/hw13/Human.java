package ru.otus.java.basic.homeworks.hw13;

public class Human {
    private final String name;
    private int energy;
    private Moving currentTransport;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setCurrentTransport(Moving currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void setEmptyCurrentTransport() {
        currentTransport = null;
    }

    public Human(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public void info() {
        if (currentTransport == null) {
            System.out.println("Человек: " + name + "; запас сил: " + energy);
            System.out.println("Транспорт не выбран");
        } else {
            System.out.println("Человек: " + name + "; запас сил: " + energy);
            currentTransport.getTransportInfo();
        }
    }

    public boolean Move(int distance, TerrainType terrainType)  {
        System.out.println("Дистанция: " + distance + "; тип местности: " + terrainType.getName());
        if (!(currentTransport == null)) {
            if (currentTransport instanceof Bicycle) {
                if (energy < distance * 3 ) {
                    System.out.println("Не хватает сил крутить педали");
                    return false;
                }
                boolean res = currentTransport.Move(distance, terrainType);
                if (res) energy = energy - distance * 3;
                return res;
            } else {
                return currentTransport.Move(distance, terrainType);
            }

        }
        System.out.println("Путь в " + distance + " преодолен пешком");
        return true;
    }
}
