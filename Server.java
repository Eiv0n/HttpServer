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
        ServerSocket server = null;
        Socket soc = null;
        Scanner scan = new Scanner(System.in);
        String wordToStop1 = "stop";
        // try 2.1
        try {
            server = new ServerSocket(8000);
            System.out.println("Сервер запущен и ждет подключения.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка в блоке try 2.1");
        }
        // try 2.2
        try {
            while (true) {
                assert soc != null;
                soc = server.accept();
                System.out.println("Соеденение установлено.");
                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                PrintWriter pw = new PrintWriter(soc.getOutputStream());
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-Type: text/html; charset=utf-8");
                pw.println();
                pw.println("<p>kslajfdalk</p>");
                pw.flush();
                String wordToStop2 = scan.nextLine();
                if (wordToStop2.equals(wordToStop1)) {
                    try {
                        soc.close();
                        server.close();
                    } catch(IOException e){
                        e.printStackTrace();
                        System.err.println("Ошибка в блоке 2.1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Пользователь разорвал соеденение.");
        }
    }
}
