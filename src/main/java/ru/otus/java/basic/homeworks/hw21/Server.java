package ru.otus.java.basic.homeworks.hw21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        String result;
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("Сервер запущен");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом :" + client.getPort() + " подключился!");

            outputStream.writeUTF("Синтаксис выражения: <операнд 1><пробел><+|-|*|/><пробел><операнд 2>");
            outputStream.flush();

            String userInput = inputStream.readUTF();
            if (userInput.equals("exit")) {
                System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
                client.close();
                continue;
            } else {
                result = operCalc(userInput);
            }

            outputStream.writeUTF(result);
            outputStream.flush();
            System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
            client.close();
        }
    }

    private static String operCalc(String userInput) {
        String[] array = userInput.trim().split(" ");
        if (!(array.length == 3)) {
            return "Введено некорректное выражение";
        }

        Double oprd1;
        Double oprd2;

        try {
            oprd1 = Double.valueOf(array[0]);
        } catch (NumberFormatException e) {
            return "Некорректное значения первого операнда: " + array[0];
        }

        try {
            oprd2 = Double.valueOf(array[2]);
        } catch (NumberFormatException e) {
            return "Некорректное значения первого операнда: " + array[2];
        }

        switch (array[1]) {
            case "+" :
                return array[0] + " + " + array[2] + " = " + (oprd1 + oprd2);
            case "-" :
                return array[0] + " - " + array[2] + " = " + (oprd1 - oprd2);
            case "*" :
                return array[0] + " * " + array[2] + " = " + (oprd1 * oprd2);
            case "/" :
                if (oprd2 == 0) return "Делить на 0 нельзя!";
                return array[0] + " / " + array[2] + " = " + (oprd1 / oprd2);
            default :
                return "\"" + array[1] + "\" - неверное значение операции:";
        }
    }
}
