package com.example.groupproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable  {
    private Socket socket = null;
    private PrintWriter out;
    private BufferedReader in;
    public String user;
    public String serverName;

    public Client(int port, String u,String serverName) throws IOException {
        user = u;
        this.serverName = serverName;
        socket = new Socket("localhost", port);

    }
    @Override
    public void run() {
        try {

            // writing to server
            out = new PrintWriter( socket.getOutputStream(), true);

            // reading from server
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(this.user);
            out.println(this.serverName);
            String line;

            while ((line = in.readLine()) != null) {
                if(!line.equals("")){
                    line = line.replace("\t","\n");
                    LoginApplication.setText(line);
                }


            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exit() {
        try {
            socket.close();
            out.close();
            in.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void sendMessage(String m){
        out.println(m);
    }


}
