package ru.otus.java.basic.homeworks.hw20;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        File file = new File(".");
        String[] sArray = file.list(new FileFilter());
        System.out.println("Список txt-файлов из корневого каталога проекта: \n" + Arrays.toString(sArray));
        System.out.println();

        System.out.println("Введите имя файла из списка");
        Scanner scanner = new Scanner(System.in);
        String filename;

        while (true) {
            filename = scanner.nextLine();
            if (Arrays.asList(sArray).contains(filename)) {
                System.out.println("Выбран файл " + filename);
                break;
            }
            System.out.println("Файла " + filename + " не существет в корневом каталоге. Выберите файл еще раз");
        }

        System.out.println("Содержимое выбранного файл " + filename + ":");
        printTxtFileContent(filename);
        System.out.println();

        System.out.println("Введите строку для записи в выбранный файл " + filename + ":");
        String s = scanner.nextLine();
        System.out.println("Введена строка " + s);

        addSringToTxtFile ("./" + filename, s);

        System.out.println("Содержимое выбранного файл " + filename + ":");
        printTxtFileContent(filename);
    }

    public static void printTxtFileContent (String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             InputStreamReader in = new InputStreamReader(bis, "windows-1251")) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addSringToTxtFile (String filename, String s) {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filename, true))) {
            byte[] buffer = s.getBytes("windows-1251");
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


