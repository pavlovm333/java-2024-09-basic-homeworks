package ru.otus.java.basic.homeworks.hw32;

import java.util.Arrays;

public class ArrayOpetations {
    public int[] arrayCutting (int[] array) {
        for (int i = array.length - 1; i >= 0 ; i--) {
            if (array[i] == 1) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException("Входной массив не содержит единиц");
    }

    public boolean checkArrayElements (int [] array) {
        boolean exist_1 = false;
        boolean exist_2 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                exist_1 = true;
                continue;
            }
            if (array[i] == 2) {
                exist_2 = true;
                continue;
            }
            return false;
        }
        return exist_1 & exist_2;
    }
}
