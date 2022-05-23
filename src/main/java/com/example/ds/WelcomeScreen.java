package com.example.ds;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;

public class WelcomeScreen {
    Stage welcomeStage;
    Scene scene;
    AnchorPane anchorPane;
    private int width;
    private int height;

    public WelcomeScreen() {
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane, this.width, this.height);
        this.welcomeStage = new Stage();
        this.welcomeStage.setScene(this.scene);
        this.setUpScreen();
    }
    public WelcomeScreen(int screenWidth, int screenHeight){
        this();
        this.width = screenWidth;
        this.height = screenHeight;
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #10866f");
        //welcome message
        Label header = new Label("Welcome to data structures and algorithms education program!");
        header.setStyle("-fx-font-size: 25");
        header.setLayoutX(350);
        anchorPane.getChildren().add(header);

        //creating button for stack data type
        Button stackButton = new Button();
        stackButton.setText("Stack Data Type");
        Font stackFont = Font.font("Courier New", FontWeight.BOLD, 36);
        stackButton.setFont(stackFont);
        stackButton.setStyle("-fx-background-color: #0CE672");
        stackButton.setPrefWidth(390);
        stackButton.setPrefHeight(60);
        stackButton.setLayoutX(100);
        stackButton.setLayoutY(100);
        stackButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("stack.");
        });
        anchorPane.getChildren().add(stackButton);

        //creating button for Array data type
        Button arrayButton = new Button();
        arrayButton.setText("Array Data Type");
        Font arrayFont = Font.font("Courier New", FontWeight.BOLD, 36);
        arrayButton.setFont(arrayFont);
        arrayButton.setStyle("-fx-background-color: #0CE672");
        arrayButton.setPrefWidth(390);
        arrayButton.setPrefHeight(60);
        arrayButton.setLayoutX(100 + 390 + 65);
        arrayButton.setLayoutY(100);
        arrayButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("array.");
        });
        anchorPane.getChildren().add(arrayButton);

        //creating button for Array data type
        Button binaryButton = new Button();
        binaryButton.setText("Binary s. Tree");
        Font binaryFont = Font.font("Courier New", FontWeight.BOLD, 36);
        binaryButton.setFont(binaryFont);
        binaryButton.setStyle("-fx-background-color: #0CE672");
        binaryButton.setPrefWidth(390);
        binaryButton.setPrefHeight(60);
        binaryButton.setLayoutX(100 + 390 + 125 + 390);
        binaryButton.setLayoutY(100);
        binaryButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("bst.");
        });
        anchorPane.getChildren().add(binaryButton);

        //creating button for Queue data type
        Button queueButton = new Button();
        queueButton.setText("Queue Data Type");
        Font queueFont = Font.font("Courier New", FontWeight.BOLD, 36);
        queueButton.setFont(queueFont);
        queueButton.setStyle("-fx-background-color: #0CE672");
        queueButton.setPrefWidth(390);
        queueButton.setPrefHeight(60);
        queueButton.setLayoutX(100);
        queueButton.setLayoutY(590);
        queueButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("queue.");
        });
        anchorPane.getChildren().add(queueButton);

        //creating button for Queue data type
        Button hashButton = new Button();
        hashButton.setText("Hash Table");
        Font hashFont = Font.font("Courier New", FontWeight.BOLD, 36);
        hashButton.setFont(hashFont);
        hashButton.setStyle("-fx-background-color: #0CE672");
        hashButton.setPrefWidth(390);
        hashButton.setPrefHeight(60);
        hashButton.setLayoutX(100 + 390 + 125 + 390);
        hashButton.setLayoutY(590);
        hashButton.setOnMouseClicked(mouseEvent -> {
            System.out.println("hash.");
        });
        anchorPane.getChildren().add(hashButton);

        //creating an imageview for marun logo
        URL urlToImage = getClass().getResource("marunlogo.png");
        Image image = new Image(String.valueOf(urlToImage));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        imageView.setLayoutX(100 + 390 + 125);
        imageView.setLayoutY(300);
        anchorPane.getChildren().add(imageView);



        this.welcomeStage.setTitle("Welcome!");
        this.welcomeStage.setWidth(this.width);
        this.welcomeStage.setHeight(this.height);
        welcomeStage.show();
    }
    public Stage getWelcomeStage(){
        return this.welcomeStage;
    }
}
