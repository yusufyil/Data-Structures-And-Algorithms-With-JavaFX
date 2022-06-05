package com.example.ds;


import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * @author yusufyildirim
 * @version v1.0.0.0
 * @github yusufyil
 **/
public class Main extends Application {
    /**
     * This is Main class for starting welcome screen and rest of the project*/
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