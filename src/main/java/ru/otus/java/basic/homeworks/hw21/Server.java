package ru.otus.java.basic.homeworks.hw21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final List<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String result;
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("Сервер запущен");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом :" + client.getPort() + " подключился!");
            ClientHandler clientHandler = new ClientHandler(client, inputStream, outputStream);
            clientHandlers.add(clientHandler);

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

        Double oprd1 = StrToDouble(array[0]);
        if (oprd1 == null) {
            return "Неверное значение 1-ого операнда: " + array[0];
        }

        Double oprd2 = StrToDouble(array[2]);
        if (oprd2 == null) {
            return "Неверное значение 2-ого операнда: " + array[2];
        }

        if (!array[1].matches("[-+*/]")) {
            return "Неверное значение операции: " + array[1];
        }

        switch (array[1]) {
            case "+" :
                return array[0] + " + " + array[2] + " = " + (oprd1 + oprd2);
            case "-" :
                return array[0] + " - " + array[2] + " = " + (oprd1 - oprd2);
            case "*" :
                return array[0] + " * " + array[2] + " = " + (oprd1 * oprd2);
            default :
                if (oprd2 == 0) return "Делить на 0 нельзя!";
                return array[0] + " / " + array[2] + " = " + (oprd1 / oprd2);
        }
    }

    private static Double StrToDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
