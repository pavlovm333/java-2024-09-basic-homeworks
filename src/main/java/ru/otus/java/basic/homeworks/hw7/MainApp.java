package ru.otus.java.basic.homeworks.hw7;

public class MainApp {

    public static void main(String[] args) {
        int[][] arr = {{-1,2,4}, {6,0,-13}};
        System.out.println("Исходный массив:");
        print2Darr(arr);
        System.out.println("Сумма всех элемнов массива, больших 0 : " + sumOfPositiveElemetns(arr));
        System.out.println();

        printSquare(6);
        System.out.println();
        System.out.println();

        System.out.println("Исходный массив:");
        int[][] arr1 = {{10,2,4,8,9}, {6,1,-1, 7,8}, {-1,2,4,8,9}, {-1,2,4,8,9}, {-1,2,4,8,9}};
        print2Darr(arr1);
        zeroingDiagonals(arr1);
        System.out.println("Массив, с зануленными диагоналями:");
        print2Darr(arr1);
        System.out.println();

        System.out.println("Исходный массив:");
        int[][] arr2 = {{10,2,4,8,9}, {6,1,-1,7,8}, {-1,2,4,8,9}, {-1,2,4,8,9}, {-1,2,4,8,9}};
        print2Darr(arr2);
        System.out.println("Максимальный элемент массива: " + findMax(arr2));
        System.out.println();

        System.out.println("Исходный массив:");
        int[][] arr3 = {{10,2,4,8,9}, {6,-2}, {-1,2,4,8,9}, {-1,2,4,8,9}, {-1,2,4,8,9}};
        print2Darr(arr3);
        System.out.println("Сумма элеметнов второго столбца: " + secondColumnElementsSum(arr3));
        System.out.println();
    }

    public static void print2Darr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int sumOfPositiveElemetns(int[][] arr) {
        int res = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > 0) {
                    res += anInt;
                }
            }
        }
        return res;
    }

    public static void printSquare(int size) {
        System.out.println("Квадрат из " + size + "X" + size + " звездочек:");
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void zeroingDiagonals(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (i==j || i==arr[i].length-1-j) {
                    arr[i][j]= 0;
                }
            }
        }
    }

    public static int findMax(int[][] array) {
        int res = array[0][0];
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt > res) {
                    res = anInt;
                }
            }
        }
        return res;
    }

    public static int secondColumnElementsSum(int[][] array) {
        int sum = 0;
        for (int[] ints : array) {
            if (ints.length < 2) {
                return -1;
            }
            sum += ints[1];
        }
        return sum;
    }
}
