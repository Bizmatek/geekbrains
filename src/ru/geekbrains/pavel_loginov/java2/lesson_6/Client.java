package ru.geekbrains.pavel_loginov.java2.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String IP_ADDR = "localhost";
    private static final int PORT = 8189;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        try (Socket socket = new Socket(IP_ADDR, PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        ) {

            Runnable t1 = (() -> {
                try {
                    this.listen(in);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            new Thread(t1).start();
            send(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(DataInputStream in) throws IOException {
        while (true) {
            String message = in.readUTF();
            System.out.println(message);
        }
    }

    public void send(DataOutputStream out) throws IOException {
        String str = null;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNext()) {
                    str = scanner.next();
                    out.writeUTF(str);
                }
            }
        }
    }
}
