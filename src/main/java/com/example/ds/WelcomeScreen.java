package com.example.ds;

import com.example.ds.ArrayDataStructure.Array;
import com.example.ds.BinarySearchTreeDataStructure.BinarySearchTree;
import com.example.ds.QueueDataStructure.Queue;
import com.example.ds.StackDataStrcuture.Stack;
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
    }
    public WelcomeScreen(int screenWidth, int screenHeight){
        this();
        this.width = screenWidth;
        this.height = screenHeight;
        this.setUpScreen();
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
        stackButton.setText("Stack Data St.");
        Font stackFont = Font.font("Courier New", FontWeight.BOLD, 36);
        stackButton.setFont(stackFont);
        stackButton.setStyle("-fx-background-color: #0CE672");
        stackButton.setPrefWidth(390);
        stackButton.setPrefHeight(60);
        stackButton.setLayoutX(100);
        stackButton.setLayoutY(100);
        stackButton.setOnMouseClicked(mouseEvent -> {
            Stack stack = new Stack(this.width, this.height);
            Stage stackStage = stack.getStackStage();
            stackStage.show();
        });
        stackButton.setOnMouseEntered(mouseEvent -> {
            stackButton.setStyle("-fx-background-color: #91f3b8");
        });
        stackButton.setOnMouseExited(mouseEvent -> {
            stackButton.setStyle("-fx-background-color: #0CE672");
        });
        anchorPane.getChildren().add(stackButton);

        //creating button for Array data type
        Button arrayButton = new Button();
        arrayButton.setText("Array Data St.");
        Font arrayFont = Font.font("Courier New", FontWeight.BOLD, 36);
        arrayButton.setFont(arrayFont);
        arrayButton.setStyle("-fx-background-color: #0CE672");
        arrayButton.setPrefWidth(390);
        arrayButton.setPrefHeight(60);
        arrayButton.setLayoutX(100 + 390 + 65);
        arrayButton.setLayoutY(100);
        arrayButton.setOnMouseClicked(mouseEvent -> {
            Array array = new Array(this.width, this.height);
            Stage arrayStage = array.getArrayStage();
            arrayStage.show();
        });
        arrayButton.setOnMouseEntered(mouseEvent -> {
            arrayButton.setStyle("-fx-background-color: #91f3b8");
        });
        arrayButton.setOnMouseExited(mouseEvent -> {
            arrayButton.setStyle("-fx-background-color: #0CE672");
        });
        anchorPane.getChildren().add(arrayButton);

        //creating button for Binary search tree data type
        Button binaryButton = new Button();
        binaryButton.setText("Binary S. Tree");
        Font binaryFont = Font.font("Courier New", FontWeight.BOLD, 36);
        binaryButton.setFont(binaryFont);
        binaryButton.setStyle("-fx-background-color: #0CE672");
        binaryButton.setPrefWidth(390);
        binaryButton.setPrefHeight(60);
        binaryButton.setLayoutX(100 + 390 + 125 + 390);
        binaryButton.setLayoutY(100);
        binaryButton.setOnMouseClicked(mouseEvent -> {
            BinarySearchTree BST = new BinarySearchTree(this.width, this.height);
            Stage BSTStage = BST.getBSTStage();
            BSTStage.show();
            BST.setUpMiniScreen();
        });
        binaryButton.setOnMouseEntered(mouseEvent -> {
            binaryButton.setStyle("-fx-background-color: #91f3b8");
        });
        binaryButton.setOnMouseExited(mouseEvent -> {
            binaryButton.setStyle("-fx-background-color: #0CE672");
        });
        anchorPane.getChildren().add(binaryButton);

        //creating button for Queue data type
        Button queueButton = new Button();
        queueButton.setText("Queue Data St.");
        Font queueFont = Font.font("Courier New", FontWeight.BOLD, 36);
        queueButton.setFont(queueFont);
        queueButton.setStyle("-fx-background-color: #0CE672");
        queueButton.setPrefWidth(390);
        queueButton.setPrefHeight(60);
        queueButton.setLayoutX(100);
        queueButton.setLayoutY(590);
        queueButton.setOnMouseClicked(mouseEvent -> {
            Queue queue = new Queue(this.width, this.height);
            Stage queueStage = queue.getQueueStage();
            queueStage.show();
        });
        queueButton.setOnMouseEntered(mouseEvent -> {
            queueButton.setStyle("-fx-background-color: #91f3b8");
        });
        queueButton.setOnMouseExited(mouseEvent -> {
            queueButton.setStyle("-fx-background-color: #0CE672");
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
        hashButton.setOnMouseEntered(mouseEvent -> {
            hashButton.setStyle("-fx-background-color: #91f3b8");
        });
        hashButton.setOnMouseExited(mouseEvent -> {
            hashButton.setStyle("-fx-background-color: #0CE672");
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
        this.welcomeStage.setResizable(false);
        welcomeStage.show();
    }
    public Stage getWelcomeStage(){
        return this.welcomeStage;
    }
}
