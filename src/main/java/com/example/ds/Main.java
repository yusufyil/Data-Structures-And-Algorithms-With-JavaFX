package com.example.ds;


import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final int stageWidth = 1920;
        final int stageHeight = 1080;
        WelcomeScreen welcomeScreen = new WelcomeScreen(stageWidth, stageHeight);
        stage = welcomeScreen.getWelcomeStage();
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}