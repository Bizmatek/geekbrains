package ru.geekbrains.pavel_loginov.java2.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept();
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            System.out.println(" Server has been started...");
            System.out.println("Client connected");

            Runnable t1 = (() -> {
                send(out);
            });
            new Thread(t1).start();

            while (true) {
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(DataOutputStream out) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = null;
            while (true) {
                if (scanner.hasNext()) {
                    str = scanner.next();
                    out.writeUTF(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}