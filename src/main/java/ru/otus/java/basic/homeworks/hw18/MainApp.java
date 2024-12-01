package ru.otus.java.basic.homeworks.hw18;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Александр Александров", "123456");
        phonebook.add("Александр Александров", "12345678");
        phonebook.add("Александр Александров", "123456");
        phonebook.add("Пётр Петров", "123456789");
        phonebook.add("Пётр Петров", "123456");
        phonebook.add("Пётр Петров", "1234567890");
        System.out.println();

        phonebook.find("Александр Александров");
        System.out.println();
        phonebook.find("Пётр Петров");
        System.out.println();
        phonebook.find("Алексей Алексеев");
        System.out.println();

        phonebook.containsPhoneNumber("123456");
        System.out.println();
        phonebook.containsPhoneNumber("12345689");
    }
}


