package com.example.ds.ArrayDataStructure;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Array {

    int[] arr;

    Stage arrayStage;

    Scene scene;

    AnchorPane anchorPane;

    private int width;

    private int height;

    public Array(int screenWidth, int screenHeight) {
        this.width = screenWidth;
        this.height = screenHeight;
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane, this.width, this.height);
        this.arrayStage = new Stage();
        this.arrayStage.setScene(this.scene);
        this.setUpScreen();
    }
    public void createArray(int size){
        arr = new int[size];
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #2d9614");
        this.arrayStage.setTitle("Stack Data Structure.");
        this.arrayStage.setResizable(false);
        this.arrayStage.setWidth(this.width);
        this.arrayStage.setHeight(this.height);
        this.arrayStage.initModality(Modality.APPLICATION_MODAL);

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        Button createArrayButton = new Button();
        TextField arraySize = new TextField();

        createArrayButton.setText("Create");
        createArrayButton.setPrefWidth(390);
        createArrayButton.setPrefHeight(60);
        createArrayButton.setFont(font);
        createArrayButton.setLayoutX(200);
        createArrayButton.setLayoutY(400);
        createArrayButton.setStyle("-fx-background-color: #07af98");
        anchorPane.getChildren().add(createArrayButton);
        createArrayButton.setOnMouseClicked(mouseEvent -> {
            try{
                int size = Integer.parseInt(arraySize.getText());
                if (size <= 0){
                    throw new Exception();
                }else {
                    arr = new int[size];
                    anchorPane.getChildren().remove(createArrayButton);
                    anchorPane.getChildren().remove(arraySize);
                    this.drawArrayToPane();
                }
            }catch (Exception e){
                System.out.println("Error.");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Wrong input has been given.");
                alert.setContentText("Input has to be a valid integer in range of 1 and 100.");
                alert.show();

            }
        });
        createArrayButton.setOnMouseEntered( mouseEvent -> {
            createArrayButton.setStyle("-fx-background-color: #02e1c1");
        });
        createArrayButton.setOnMouseExited( mouseEvent -> {
            createArrayButton.setStyle("-fx-background-color: #07af98");
        });

        arraySize.setText("Enter Array Size");
        arraySize.setFont(font);
        arraySize.setPrefWidth(390);
        arraySize.setPrefHeight(60);
        arraySize.setLayoutX(900);
        arraySize.setLayoutY(400);
        arraySize.setStyle("-fx-background-color: #07af98");
        anchorPane.getChildren().add(arraySize);
    }
    public void drawArrayToPane(){
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        Group arrayBoundries = new Group();
    }
    public Stage getArrayStage(){
        return this.arrayStage;
    }
}
