package ru.otus.java.basic.homeworks.hw29;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        File file = new File(".");
        String[] sArray = file.list(new FileFilter());
        System.out.println("Список txt-файлов из корневого каталога проекта: \n" + Arrays.toString(sArray));
        System.out.println();

        System.out.println("Введите имя файла из списка и через пробел укажите последовательность символов");
        Scanner scanner = new Scanner(System.in);
        String[] element;

        while (true) {
            element = scanner.nextLine().split(" ",2);
            if (element.length != 2) {
                System.out.println("Некорректные данные. Поовторите ввод");
                continue;
            }

            if (element[1].equals(""))  {
                System.out.println("Не задана последовательность символов");
                continue;
            }

            if (Arrays.asList(sArray).contains(element[0])) {
                System.out.println("Выбран файл " + element[0] + " и указана последовательность \"" + element[1] + "\"");
                break;
            }

            System.out.println("Файла " + element[0] + " не существет в корневом каталоге. Повторите ввод");
        }
        countingPatternOccurrences(element[0], element[1]);
    }

    public static void countingPatternOccurrences (String filename, String pattern) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;
            int res = 0;
            while ((line = bufferedReader.readLine()) != null) {
                res += (line.length() - line.replace(pattern, "").length())/pattern.length();
            }
            System.out.println("Число последовательностей \"" + pattern + "\" в файле " + filename + " - " + res);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
