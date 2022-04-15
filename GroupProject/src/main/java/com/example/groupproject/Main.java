package com.example.groupproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static ArrayList<String[]> serverDirectory = new ArrayList<String[]>();
    public static LoginApplication window;
    public static Client client;

    public static void newServer(String name,String password) throws IOException {
        readServers();

        String[] newServer = {name,password};
        Server server = new Server(5001,name,password);
        serverDirectory.add(newServer);
        FileWriter writer = new FileWriter("src/main/resources/com/example/groupproject/serverDirectory.csv");
        String collect = "";
        for(int i = 0;i<serverDirectory.size();i++){
            collect += serverDirectory.get(i)[0] + "," + serverDirectory.get(i)[1] + "\n";
        }
        writer.write(collect);
        writer.close();

        new Thread(server).start();

    }
    public static void JoinServer(String name,String password,String username) throws IOException {
        readServers();

        for(int i = 0; i < serverDirectory.size();i++){
            if(name.equals(serverDirectory.get(i)[0]) && password.equals(serverDirectory.get(i)[1])){
                client = new Client(5001, username,name);
                new Thread(client).start();
                break;
            }
        }
    }

    public static void main(String[] args) {

        window = new LoginApplication();
        window.startApp();

    }

    public static void readServers() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/example/groupproject/serverDirectory.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] row = line.split(splitBy);
            serverDirectory.add(row);
        }
    }

}
