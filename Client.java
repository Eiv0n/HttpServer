package com.viktor.leonov;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        // try 1.1
        try {
            socket = new Socket("localhost", 8000);
            System.out.println("Сокет клиента создан");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.err.println("Ошибка в блоке try 1.1.");
        }
        if (socket != null) {
            socket.close();
        } else {
            System.err.println("null в сокете.");
        }
    }
}