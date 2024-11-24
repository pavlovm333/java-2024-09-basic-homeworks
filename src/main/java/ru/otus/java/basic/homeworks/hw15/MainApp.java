package ru.otus.java.basic.homeworks.hw15;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        try {
            arrayElementsSummarizing(new String [][] {{"1","1","1","1"}, {"2","2","2","2"}, {"3","3","3","3"}, {"4","4","4"}});
        }
        catch (AppArraySizeException|AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    static void arrayElementsSummarizing (String[][] arr) {
        if (arr.length != 4) {
            throw new AppArraySizeException ("Размерность переданного массива " + Arrays.deepToString(arr) + " не 4x4");
        }
        int sum = 0;
        for (int i = 0; i<arr.length;i++) {
            if (arr[i].length != 4) throw new AppArraySizeException("Размерность переданного массива " + Arrays.deepToString(arr) + " не 4x4");
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new AppArrayDataException ("В ячейке [" + i + "][" + j + "] находятся неверные данные \"" + arr[i][j] + "\"");
                }
            }
        }
        System.out.println("Сумма элемементов массива равна " + sum);
    }

}
