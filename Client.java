package com.viktor.leonov;
// симуляция подключениея не выходя за пределы IDE
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client { 
    public static void main(String[] args) throws IOException {
        Socket socket = null; // присваиваем null сокету клиента, пока что он не включен 
        // try 1.1
        try {  
            socket = new Socket("localhost", 8000); // подключаемся по локальному хосту (127.0.0.1) и порту 8000 
            System.out.println("Сокет клиента создан"); // выводим информационное сообщение в консоль
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.err.println("Ошибка в блоке try 1.1.");
        }
        if (socket != null) { // если что-то пошло не так
            socket.close(); 
        } else {
            System.err.println("null в сокете.");
        }
    }
}
