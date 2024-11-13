package ru.otus.java.basic.homeworks.hw12;

public class Plate {
    private int maxFoodAmount;
    private int currFoodAmount;

    public int getMaxFoodAmount() {
        return maxFoodAmount;
    }

    public void setMaxFoodAmount(int maxFoodAmount) {
        this.maxFoodAmount = maxFoodAmount;
    }

    public Plate(int maxFoodAmount) {
        this.maxFoodAmount = maxFoodAmount;
        currFoodAmount = maxFoodAmount;
    }

    public int getCurFoodAmount() {
        return currFoodAmount;
    }

    public void addFoodVolume(int foodAmount) {
        if (foodAmount + currFoodAmount > maxFoodAmount) {
            currFoodAmount = maxFoodAmount;
        } else {
            currFoodAmount+= foodAmount;
        }
    }

    public boolean reduceFoodVolume(int foodAmount) {
        if (currFoodAmount - foodAmount >= 0) {
            currFoodAmount-= foodAmount;
            return true;
        }
        return false;
    }

}


