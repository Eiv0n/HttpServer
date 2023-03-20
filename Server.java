package com.viktor.leonov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) {
        ServerSocket server = null; // создаем сокет сервера 
        Socket soc = null; // создаем еще один сокет чтобы установить соединение с сервером 
        Scanner scan = new Scanner(System.in); // создаем объект класса Scanner, который считывает ввод с консоли
        String wordToStop1 = "stop"; // создаем переменную со стоп словом 
        // try 2.1
        try { // заключаем строки кода в блок try-catch, чтобы обработать исключения
            server = new ServerSocket(8000); // создаем сокет сервера с параметром, в котором указан номер порта, по котором будет происходить соединение.
            System.out.println("Сервер запущен и ждет подключения."); // выводим информационное сообщение в консоль
        } catch (IOException e) { // если выбрасывает исключение IOException, то делаем следующее:
            e.printStackTrace(); // выводим трассировку стека, чтобы понять, где что-то пошло не так
            System.err.println("Ошибка в блоке try 2.1"); // выводим информационное сообщение в консоль 
        }
        // try 2.2
        try { // второй блок try-catch 
            while (true) { // заключаем последущий код в бесконечный цикл while 
                assert soc != null; // если объект сокета снова null, то моментально выходим из цикла while, и сервер прекращает свою работу
                soc = server.accept(); // устанавливаем соединение с сокетом сервера 
                System.out.println("Соеденение установлено."); // выводим информационное сообщение в консоль
                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); // создаем объект, который считывает и буфферизирует символы,
                // которые проходят через него, т.е из входноого потока InputStreamReader
                PrintWriter pw = new PrintWriter(soc.getOutputStream()); // создаем объект, который выводит символы в выходной поток 
                pw.println("HTTP/1.1 200 OK"); // код ответа htt[ сервера, если все в порядке и сервер запущен
                pw.println("Content-Type: text/html; charset=utf-8"); // кодировка символов в привычном нам стандарте utf-8 
                pw.println();
                pw.println("<p>Итоговый проект за 9 класс</p>"); // сообщение которое мы выводим на серввер 
                pw.flush(); // очищает поток вывода для оптимизации работы
                String wordToStop2 = scan.nextLine(); // ввод стоп слова в консоль
                if (wordToStop2.equals(wordToStop1)) { // если стоп слово введенное в консоль идентично стоп слову указанному выше, то:
                    try { // третий блок try-catch
                        soc.close(); // сокет выключается
                        server.close(); // выключается сервер
                    } catch(IOException e){ // если выбрасывает исключение IOException, то делаем следующее:
                        e.printStackTrace(); // выводим трассировку стека, чтобы понять, где что-то пошло не так
                        System.err.println("Ошибка в блоке 2.1"); // выводим информационное сообщение в консоль
                    }
                }
            }
        } catch (Exception e) {  // если выбрасывает исключение IOException, то делаем следующее:
            e.printStackTrace(); // выводим трассировку стека, чтобы понять, где что-то пошло не так
            System.out.println("Пользователь разорвал соеденение."); // выводим информационное сообщение в консоль 
        }
    }
}
