package com.example.groupproject;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private int port;
    private ServerSocket server = null;
    private boolean isActive = false;
    private String password;
    private String name;

    public Server(int p,String name,String password) {
        try {
            port = p;
            this.name = name;
            this.password = password;
            server = new ServerSocket(port);
            server.setReuseAddress(true);
            isActive = true;
        }
         catch (IOException i) {
             i.printStackTrace();
         }
    }

    public boolean isRunning() {
        return isActive;
    }

    public void close() {
        isActive = false;
        System.out.println("Server has closed in the close() method");
    }

    public void run() {
        System.out.println("Start server: " + port);

        try {
            while (isActive) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
                ClientHandler client = new ClientHandler(socket);
                new Thread(client).start();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                    System.out.println("Server has closed in run() method");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
