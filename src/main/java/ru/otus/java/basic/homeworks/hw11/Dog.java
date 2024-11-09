package ru.otus.java.basic.homeworks.hw11;

public class Dog extends Animal{
    private int swimVelocity;
    public Dog(String name, int runVelocity, int endurance, String type, int swimVelocity) {
        super(name, runVelocity, endurance, type);
        this.swimVelocity = swimVelocity;
    }

    public int getSwimVelocity() {
        return swimVelocity;
    }

    public void setSwimVelocity(int swimVelocity) {
        if (swimVelocity>=0) {this.swimVelocity = swimVelocity;}
    }

    public int swim(int distance) {
        int res;
        if (endurance < distance*2) {
            endurance = 0;
            res = -1;
        } else {
            endurance-= distance*2;
            res = distance/swimVelocity;
        }
        return res;
    }
}