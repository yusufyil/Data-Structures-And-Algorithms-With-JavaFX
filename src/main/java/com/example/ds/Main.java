package com.example.ds;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final int stageWidth = 1920;
        final int stageHeight = 1080;
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}