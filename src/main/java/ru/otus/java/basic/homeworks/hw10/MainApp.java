package ru.otus.java.basic.homeworks.hw10;

import java.time.Year;

public class MainApp {
    public static void main(String[] args) {
        User user = new User ("Алексеев", "Алексей", "Алексеевич", 2000, "aleksey@aleksey.ru");
        user.printUserInfo();

        System.out.println();

        System.out.println("Вывод информации о пользователях старше 40 лет");
        User[] users = new User[10];
        users[0] = new User ("Алексеев", "Алексей", "Алексеевич", 1970, "aleksey@aleksey.ru");
        users[1] = new User ("Алексеев1", "Алексей", "Алексеевич", 1975, "aleksey@aleksey.ru");
        users[2] = new User ("Алексеев2", "Алексей", "Алексеевич", 1980, "aleksey@aleksey.ru");
        users[3] = new User ("Алексеев3", "Алексей", "Алексеевич", 1985, "aleksey@aleksey.ru");
        users[4] = new User ("Алексеев4", "Алексей", "Алексеевич", 1990, "aleksey@aleksey.ru");
        users[5] = new User ("Алексеев5", "Алексей", "Алексеевич", 1995, "aleksey@aleksey.ru");
        users[6] = new User ("Алексеев6", "Алексей", "Алексеевич", 2000, "aleksey@aleksey.ru");
        users[7] = new User ("Алексеев7", "Алексей", "Алексеевич", 2005, "aleksey@aleksey.ru");
        users[8] = new User ("Алексеев8", "Алексей", "Алексеевич", 2010, "aleksey@aleksey.ru");
        users[9] = new User ("Алексеев9", "Алексей", "Алексеевич", 2015, "aleksey@aleksey.ru");

        for (User x:users) {
            if (Year.now().getValue() - x.getBirthYear() >  40)
                x.printUserInfo();
        }

        System.out.println();
        System.out.println("Создание черной коробки");
        Box box = new Box("Большой","Черный");
        box.printBoxInfo();

        System.out.println();
        System.out.println("Перекраска в зелёный");
        box.setColor("Зелёный");
        box.printBoxInfo();

        System.out.println();
        System.out.println("Пробуем положить часы в коробку");
        box.setObjectInBox("часы");
        box.printBoxInfo();

        System.out.println();
        System.out.println("Открываем крышку и пробуем положить часы в коробку");
        box.openBox();
        box.setObjectInBox("часы");
        box.printBoxInfo();

        System.out.println();
        System.out.println("Закрываем коробку");
        box.closeBox();
        box.printBoxInfo();

        String obj;
        System.out.println();
        System.out.println("Пробуем извлечь предмет");
        obj = box.getObjectInBox();
        System.out.println("Извлеченный предмет: " + obj);
        box.printBoxInfo();

        System.out.println();
        System.out.println("Открываем крышку и пробуем извлечь предмет");
        box.openBox();
        obj = box.getObjectInBox();
        System.out.println("Извлеченный предмет: " + obj);
        box.printBoxInfo();

    }
}

