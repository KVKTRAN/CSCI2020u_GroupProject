package com.example.groupproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Group());

        GridPane gp = new GridPane();
        gp.setMinHeight(500);
        gp.setMinWidth(500);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setVgap(10);
        gp.setHgap(10);

        stage.setTitle("Group Project");

        ((Group) scene.getRoot()).getChildren().addAll(gp);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}