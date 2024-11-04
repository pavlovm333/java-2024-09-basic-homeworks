package ru.otus.java.basic.homeworks.hw10;

public class User {
    private String surname;
    private String name;
    private String middleName;
    private int birthYear;
    private String email;

    public User (String surname, String name, String middleName, int birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void printUserInfo() {
        System.out.println("ФИО: " + surname + " " + name + " " + middleName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
    }

    public int getBirthYear() {
        return birthYear;
    }

}
