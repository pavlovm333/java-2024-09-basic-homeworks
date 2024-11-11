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
        this.currFoodAmount = maxFoodAmount;
    }

    public int getCurFoodAmount() {
        return currFoodAmount;
    }

    public void AddFoodVolume(int FoodAmount) {
        if (FoodAmount + currFoodAmount > maxFoodAmount) {
            currFoodAmount = maxFoodAmount;
        } else {
            currFoodAmount+= FoodAmount;
        }
    }

    public boolean ReduceFoodVolume(int FoodAmount) {
        if (currFoodAmount - FoodAmount >= 0) {
            currFoodAmount-= FoodAmount;
            return true;
        }
        return false;
    }

}


