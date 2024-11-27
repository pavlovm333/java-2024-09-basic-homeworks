package ru.otus.java.basic.homeworks.hw16;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Integer> arrList;
        arrList = getIntegerList(5, 12);
        System.out.println ("Список последовательных чисел со значениями от 5 до 12 включительно\n" + arrList + "\n");

        System.out.println ("Сумма элеметов массива \n" + arrList + " со значениями элементов > 5: " + getArrayListElementsSum(arrList) + "\n");

        LinkedList<Integer> linkList = new LinkedList<>(Arrays.asList(100, 23, 45, 9, 0));
        System.out.println("Исходный список из чисел : " + linkList);
        updateLinkedListElements(linkList, 10);
        System.out.println("Список с каждым заменным числом на 10 : " + linkList + "\n");

        LinkedList<Integer> linkList1 = new LinkedList<>(Arrays.asList(10, 32, 45, 9, 0));
        System.out.println("Исходный список из чисел : " + linkList1);
        increasingLinkedListElements(linkList1, 11);
        System.out.println("Список с каждым увеличенным числом на 11 : " + linkList1 + "\n");

        LinkedList<Employee> linkedEmployeesList = new LinkedList<>();
        linkedEmployeesList.add(new Employee("Вася Васечкин", 20));
        linkedEmployeesList.add(new Employee("Пётр Петров", 40));
        linkedEmployeesList.add(new Employee("Александр Александров", 50));
        linkedEmployeesList.add(new Employee("Николай Тапочкин", 25));

        System.out.println("Исходный список сотрудников : ");
        System.out.println(linkedEmployeesList);
        LinkedList<String> employeeNamesList= getEmployeeNamesList(linkedEmployeesList);
        System.out.println("Cписок имен сотрудников : " + employeeNamesList + "\n");

        System.out.println("Исходный список сотрудников : ");
        System.out.println(linkedEmployeesList);
        LinkedList<Employee> linkedOlderEmployeesList= getLinkedOlderEmployeesList(linkedEmployeesList, 35);
        System.out.println("Cписок сотрудников c возрастом >= 35 : ");
        System.out.println(linkedOlderEmployeesList);

        System.out.println("\nИсходный список сотрудников : ");
        System.out.println(linkedEmployeesList);
        checkAverageAgeEmployees (linkedEmployeesList, 35);


        System.out.println("\nИсходный список сотрудников : ");
        System.out.println(linkedEmployeesList);
        Employee youngestEmployee = getYoungestEmployee(linkedEmployeesList);
        System.out.println("Самый молодой сотрудник : " + youngestEmployee);
    }

    /*
    Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
     */
    public static ArrayList<Integer> getIntegerList(int min, int max) {
        if (min > max) {
            System.out.println("Значение параметра max " + max + " должно быть < значения min " + min);
            return null;
        }
        ArrayList<Integer> arrLst = new ArrayList<>();
        arrLst.ensureCapacity(max - min + 1);
        for (int i = 0; i < max - min + 1; i++) {
            arrLst.add(min + i);
        }
        return arrLst;
    }

    /*
    Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
     */
    public static int getArrayListElementsSum(List<Integer> arrList) {
        Iterator<Integer> iterator = arrList.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i > 5) {
                sum+=i;
            }
        }
        return sum;
    }

    /*
    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом;
     */
    public static void updateLinkedListElements(List<Integer> linkList, int newElementVal) {
        int idx = 0;
        int size = linkList.size();
        while (idx < size) {
            linkList.set(idx, newElementVal);
            idx+=1;
        }
    }

    /*
    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
     */
    public static void increasingLinkedListElements(List<Integer> linkList, int increasingVal) {
        Iterator<Integer> iterator = linkList.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            Integer elVal = iterator.next();
            linkList.set(idx, elVal + increasingVal);
            idx+=1;
        }
    }

    /*
    Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
     */
    public static LinkedList<String> getEmployeeNamesList (List<Employee> linkedEmployeesList) {
        LinkedList<String> employeeNamesList = new LinkedList<>();
        Iterator<Employee> iterator = linkedEmployeesList.iterator();
        while (iterator.hasNext()) {
            employeeNamesList.add(iterator.next().getName());
        }
        return employeeNamesList;
    }

    /*
    Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
     */
    public static LinkedList<Employee> getLinkedOlderEmployeesList (LinkedList<Employee> linkedEmployeesList, int minAge) {
        LinkedList<Employee> linkedOlderEmployeesList = new LinkedList<>();
        Iterator<Employee> iterator = linkedEmployeesList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getAge() >= minAge) {
                linkedOlderEmployeesList.add(employee);
            }
        }
        return linkedOlderEmployeesList;
    }

    /*
    Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент;
     */
    public static void checkAverageAgeEmployees (LinkedList<Employee> linkedEmployeesList, int minAverageAge) {
        int size = linkedEmployeesList.size();
        if (size == 0) {
            System.out.println("Список сотрудников пуст");
            return;
        }
        int sumAge = 0;
        int averageAge;
        Iterator<Employee> iterator = linkedEmployeesList.iterator();
        while (iterator.hasNext()) {
            sumAge+= iterator.next().getAge();
            }
        averageAge = sumAge/size;
        if (averageAge > minAverageAge) {
            System.out.println("Средний возраст сотрудников " + averageAge + " превышает " + minAverageAge);
        } else {
            System.out.println("Средний возраст сотрудников " + averageAge + " не превышает " + minAverageAge);
        }
    }

    /*
    Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
     */
    public static Employee getYoungestEmployee (LinkedList<Employee> linkedEmployeesList) {
        Employee youngestEmployee;
        Iterator<Employee> iterator = linkedEmployeesList.iterator();
        if (iterator.hasNext()) {
            youngestEmployee = iterator.next();
        } else
                return null;
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getAge() < youngestEmployee.getAge()) {
                youngestEmployee = employee;
            }
        }
        return youngestEmployee;
    }
}

