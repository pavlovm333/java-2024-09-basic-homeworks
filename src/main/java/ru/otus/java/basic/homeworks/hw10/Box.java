package ru.otus.java.basic.homeworks.hw10;

public class Box {
    private String size;
    private String color;
    private String objectInBox;
    private boolean boxCoverStatus; //false - крышка закрыта, true - крышка открыта

    public Box(String size, String color) {
        this.size = size;
        this.color = color;
        objectInBox = null; //в новой коробке ничего не лежит
        boxCoverStatus = false; //новая коробка закрыта
    }

    public boolean isCoverBoxOpen() {
        return boxCoverStatus;
    }

    public void openBox() {
        boxCoverStatus = true;
    }

    public void closeBox() {
        boxCoverStatus = false;
    }

    public void printBoxInfo() {
        System.out.print("Размер коробки: " + size + "; ");
        System.out.print("Цвет коробки: " + color + "; ");
        if (objectInBox != null) {
            System.out.print("У коробке лежит: " + objectInBox + "; ");
        }
        else {
            System.out.print("В коробке ничего не лежит; ");
        }
        if (boxCoverStatus) {
            System.out.println("Крышка открыта");
        } else {
            System.out.println("Крышка закрыта");
        }

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setObjectInBox (String objectInBox) {
        if (!boxCoverStatus) {
            System.out.println("Сначала надо открыть крышку");
        } else if ( this.objectInBox != null) {
            System.out.println("В коробке уже лежат: " + this.objectInBox);
        } else {
            this.objectInBox = objectInBox;
            System.out.println("Предмет " + objectInBox + " уложен в коробку");
        }
    }

    public String getObjectInBox () {
        String res = null;
        if (!boxCoverStatus) {
            System.out.println("Сначала надо открыть крышку");
        } else if (objectInBox == null) {
            System.out.println("В коробке ничего нет");
        } else {
            res = objectInBox;
            System.out.println("Предмет " + objectInBox + " извлечен из коробки");
            this.objectInBox = null;
        }
        return res;
    }
}
