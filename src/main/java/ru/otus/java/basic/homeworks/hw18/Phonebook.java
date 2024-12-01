package ru.otus.java.basic.homeworks.hw18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    HashMap<String, HashSet<String>> phonebook;

    Phonebook() {
        phonebook = new HashMap<>();
    }

    /*
    Метод add() должен позволять добавлять запись имя-телефон;
     */
    public void add (String name, String phone) {
        if (!phonebook.containsKey(name)) {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(phone);
            phonebook.put(name, hashSet);
            return;
        }
        Set<String> hashSet = phonebook.get(name);
        hashSet.add(phone);
    }

    /*
    Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
     */
    public void find (String name) {
        if (!phonebook.containsKey(name)) {
            System.out.println("\"" + name + "\" отсутствует в телефонном справочнике");
            return;
        }
        System.out.println("список телефонов, зарегистрированных на имя \"" + name + "\"");
        for(String phone: phonebook.get(name)) {
            System.out.println(phone);
        }
    }
    /*
    Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
     */
    public void containsPhoneNumber(String phone) {
        boolean searchRes = false;
        for (Map.Entry<String, HashSet<String>> entry: phonebook.entrySet()) {
            for (String setElement: entry.getValue()) {
                if (setElement.equals(phone) ) {
                    System.out.println("Номер " + phone + " принадлежит \"" + entry.getKey() + "\"");
                    if (!searchRes) searchRes = true;
                }
            }
        }
        if (!searchRes) System.out.println("Номер " + phone + " не найден в телефонном справочнике" );
    }
}
