package ru.otus.java.basic.homeworks.hw5;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        arraysElementsSum(new int[]{1,2,3,4}, new int[]{111,222,333,444,555,666}, new int[]{11,22,33,44,55});
        System.out.println();
        arraysPointExists(new int[]{1,20,-7,-10,-2});
        System.out.println();
        arraySortedCheck(new int[]{7,6,5,5,2}, false);
        System.out.println();
        arrayMirroring(new int[]{7,6,5,2});
    }

    public static void arraysElementsSum(int[] ... members) {
        int maxLength = 0;
        for (int i = 0; i < members.length; i++ ) {
            if (members[i].length > maxLength) {
                maxLength= members[i].length;
            }
        }
        int[] resultedArray = new int[maxLength];
        for (int i = 0; i < members.length; i++ ) {
            for (int j = 0; j < members[i].length; j++ ) {
                resultedArray[j] += members[i][j];
            }
        }
        System.out.println("Массив с суммами элементов - " + Arrays.toString(resultedArray));
    }

    public static void arraysPointExists(int[] arr) {
        int sumLeft = arr[0];
        int sumRight = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            sumRight = sumRight + arr[i];
        }

        do {
            if (sumLeft == sumRight) {
                break;
            }
            j++;
            sumLeft = sumLeft + arr[j];
            sumRight = sumRight - arr[j];
            }
        while(j < arr.length - 1);
        if (j == arr.length - 1) {
            System.out.println("Точка не найдена");
        }
        else {
            System.out.println("Точка находится между элементами " + arr[j] + " и " + arr[j + 1]);
        }
    }

    public static void arraySortedCheck(int[] arr, boolean ascending ) {  //ascending = true - по возрастанию
        boolean res = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (((ascending) && (arr[i] > arr[i + 1])) || ((!ascending) && (arr[i] < arr[i + 1])))  {
                res = false;
                break;
            }
        }
        if (res) {
            if (ascending) {
                System.out.println("Массив отсортирован по возрастанию значений элементов");
            } else {
                System.out.println("Массив отсортирован по убыванию значений элементов");
            }
        } else {
            System.out.println("Массив не отсортирован или порядок сортировки не соответствует выбранному");
        }
    }

    public static void arrayMirroring(int[] arr) {
        System.out.println("Исходный массив - " + Arrays.toString(arr));
        int a;
        for (int i = 0; i < arr.length/2; i++) {
            a = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = a;
        }
        System.out.println("Перевернутый массив - " + Arrays.toString(arr));
    }
}

