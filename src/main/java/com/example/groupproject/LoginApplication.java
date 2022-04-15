package com.example.groupproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginApplication extends Application {

    static TextArea messageLog;
    static String messagestr = "";
    String servername = "";
    String username = "";
    public static Stage stage;

    public void start(Stage s){

        stage = s;
        Button btnNewServer = new Button("Create New Server");
        Button btnJoinServer = new Button("Join Server");
        VBox vbox = new VBox();

        Label lblServerName = new Label("Server Name:");
        Label lblPassword = new   Label("Password:    ");
        Label lblUserName = new   Label("Username:    ");
        TextField txtServerName = new TextField();
        TextField txtPassword = new TextField();
        TextField txtUserName = new TextField();

        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(15, 12, 15, 12));
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setStyle("-fx-background-color: #336699;");
        hbox1.getChildren().addAll(lblServerName,txtServerName);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(15, 12, 15, 12));
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setStyle("-fx-background-color: #336699;");
        hbox2.getChildren().addAll(lblPassword,txtPassword);

        HBox hbox3 = new HBox();
        hbox3.setPadding(new Insets(15, 12, 15, 12));
        hbox3.setSpacing(10);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.setStyle("-fx-background-color: #336699;");
        hbox3.getChildren().addAll(lblUserName,txtUserName);

        Button btnCreate = new Button("Create Server");
        Button btnJoin = new Button("Join");

        VBox vbox2 = new VBox();
        vbox2.setSpacing(10);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setStyle("-fx-background-color: #336699;");
        vbox2.getChildren().addAll(hbox1,hbox2);

        Scene scene1 = new Scene(vbox, 400, 250);
        Scene scene2 = new Scene(vbox2, 400, 250);

        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #336699;");
        vbox.getChildren().addAll(btnNewServer,btnJoinServer);

        btnNewServer.setOnAction(e -> {
            vbox2.getChildren().add(btnCreate);
            stage.setScene(scene2);
        });
        btnJoinServer.setOnAction(e -> {
            vbox2.getChildren().addAll(hbox3, btnJoin);
            stage.setScene(scene2);
        });

        btnJoin.setOnAction(e -> {
            try {
                Main.JoinServer(txtServerName.getText(),txtPassword.getText(),txtUserName.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            loadChatApp(txtServerName.getText(),txtUserName.getText());
        });

        btnCreate.setOnAction(e -> {
            try {
                Main.newServer(txtServerName.getText(),txtPassword.getText());
            }  catch (IOException ex) {
                ex.printStackTrace();
            }
            loadServer(txtServerName.getText(),txtUserName.getText());
        });

        stage.setTitle("Group Think (TM)");
        stage.setScene(scene1);
        stage.show();
    }
    public void startApp(){
        launch();
    }

    public void loadChatApp(String servername,String username){
        this.username = username;
        this.servername = servername;

        Label lblServerName = new Label(servername);
        messageLog = new TextArea();
        messageLog.setEditable(false);
        TextField txtInput = new TextField();
        txtInput.setPrefWidth(400);
        Button btnSend = new Button("send");
        btnSend.setOnAction(e -> {
            String temp = username + ": " + txtInput.getText();
            txtInput.setText("");
            Main.client.sendMessage(temp);
        });
        Label lblUsername = new Label("Logged in as: " + username);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().addAll(txtInput,btnSend);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #336699;");
        vbox.getChildren().addAll(lblServerName,messageLog,hbox,lblUsername);

        Scene scene = new Scene(vbox, 500, 500);
        stage.setTitle("Group Think (TM)");
        stage.setScene(scene);
        stage.show();
    }
    public void loadServer(String servername,String username){
        this.username = username;
        this.servername = servername;

        Label lblServerName = new Label(servername);
        messageLog = new TextArea();
        messageLog.setEditable(false);
        TextField txtInput = new TextField();
        txtInput.setPrefWidth(400);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #336699;");
        vbox.getChildren().addAll(lblServerName,messageLog);

        Scene scene = new Scene(vbox, 500, 500);
        stage.setTitle("Group Think (TM)");
        stage.setScene(scene);
        stage.show();
    }
    public static void setText(String s){
        messagestr = s;
        messageLog.setText(messagestr);
    }
    public static void addText(String s){
        messagestr += s + "\n";
        messageLog.setText(messagestr);
    }
    public static String getText(){
        return messagestr;
    }

    public static void main(String[] args){
        launch();
    }
}
