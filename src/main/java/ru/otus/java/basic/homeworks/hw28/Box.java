package ru.otus.java.basic.homeworks.hw28;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit (T fruit) {
        fruits.add(fruit);
    }
    
    public int weight() {
        int total = 0;
        for (T fruit : fruits) {
            total += fruit.getWeight();
        }
        return total;
    }

    public boolean compare (Box<?> another) {
        return weight() == another.weight();
    }

    public void empty (Box<? super T> another) {
        for (T fruit : fruits) {
            another.addFruit(fruit);
        }
        fruits.clear();
    }
}
