package com.example.groupproject;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private PrintWriter out = null;
    private BufferedReader in = null;

    // Constructor
    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }

    public void run()
    {
        try {
            // get the outputstream of client
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // get the inputstream of client
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;

            String username = in.readLine();
            String servername = in.readLine();
            LoginApplication.addText(username + " has joined the server");
            while ((line = in.readLine()) != null) {

                LoginApplication.addText(line);
                String temp = LoginApplication.getText().replace("\n", "\t");
                out.println(temp);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    clientSocket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}