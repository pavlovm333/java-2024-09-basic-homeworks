package ru.otus.java.basic.homeworks.hw19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Исходный массив целых чисел");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,245,678,34,-3,456,77,44,564,-100));
        System.out.println(arrayList);
        System.out.println();

        IntegerSearchTree integerSearchTree = new IntegerSearchTree(arrayList);
        List<Integer> arrList = ((SearchTree) integerSearchTree).getSortedList();
        System.out.println("Отсортрованный массив целых чисел, ссылка на который получена через метод getSortedList() интерфейса SearchTree");
        System.out.println(arrList);
        System.out.println();

        System.out.println("Поиск числа 678 через метод find() интерфейса SearchTree");
        System.out.println(((SearchTree) integerSearchTree).find(678));
        System.out.println("Поиск числа 1000 через метод find() интерфейса SearchTree");
        System.out.println(((SearchTree) integerSearchTree).find(1000));
        System.out.println();

        System.out.println("Вывод информации о дереве поиcка");
        integerSearchTree.printIntegerSearchTree();

    }
}
