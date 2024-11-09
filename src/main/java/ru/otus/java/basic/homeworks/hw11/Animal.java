package ru.otus.java.basic.homeworks.hw11;

public class Animal {
    private final String name;
    private int runVelocity;
    int endurance;
    private final String type;

    public Animal (String name, int runVelocity, int endurance, String type) {
        this.name = name;
        this.runVelocity = runVelocity;
        this.endurance = endurance;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getRunVelocity() {
        return runVelocity;
    }

    public void setRunVelocity(int runVelocity) {
        if (runVelocity >=0) {
            this.runVelocity = runVelocity;
        }
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        if (endurance >=0) {
            this.endurance = endurance;
        }
    }

    public void info() {
        System.out.println(type + "; кличка: " + name + "; скорость бега(м/c): " + runVelocity + "; уровеь выносливости: " + endurance);
    }

    public int run(int distance) {
        int res;
        if (endurance < distance) {
            endurance = 0;
            res = -1;
        } else {
            endurance-= distance;
            res = distance/runVelocity;
        }
        return res;
    }

}