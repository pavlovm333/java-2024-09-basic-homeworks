package ru.otus.java.basic.homeworks.hw21;

import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8080);
                ExampleClient client = new ExampleClient(socket.getInputStream(), socket.getOutputStream()) )  {
                client.recieve();

                System.out.println("Введите выражение:");
                String userMessage = scanner.nextLine();
                if (userMessage.equals("exit")) {
                    client.send(userMessage);
                    break;
                }
                client.send(userMessage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

