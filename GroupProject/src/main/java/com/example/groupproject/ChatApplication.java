package com.example.groupproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApplication{
    TextArea messageLog;
    static String messagestr = "";
    String servername = "";
    String username = "";

    public void startApp(String servername,String username){
        this.servername = servername;
        this.username = username;

    }
    public void start(Stage stage){

        Label lblServerName = new Label("Fool's Server");
        messageLog = new TextArea();
        messageLog.setEditable(false);
        TextField txtInput = new TextField();
        txtInput.setPrefWidth(400);
        Button btnSend = new Button("send");
        btnSend.setOnAction(e -> {  messagestr += txtInput.getText() + "\n";
            txtInput.setText("");
            messageLog.setText(messagestr);});
        Label lblUsername = new Label("Logged in as: ");

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

}
