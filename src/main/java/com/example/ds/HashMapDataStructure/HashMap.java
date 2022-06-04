package com.example.ds.HashMapDataStructure;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HashMap {
    HashMapNode[] hashMapNodes;

    Stage HashMapStage;

    Scene scene;

    AnchorPane anchorPane;

    int width;

    int height;

    public HashMap(int screenWidth, int screenHeight) {
        this.width = screenWidth;
        this.height = screenHeight;
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane);
        this.HashMapStage = new Stage();
        this.HashMapStage.setScene(scene);
        this.hashMapNodes = new HashMapNode[10];
        for(int i = 0; i < hashMapNodes.length; i++){
            hashMapNodes[i] = new HashMapNode(this.width, this.height);
        }
        this.setUpScreen();
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #112a7a");
        this.HashMapStage.setTitle("Hash Map Data Structure.");
        this.HashMapStage.setResizable(false);
        this.HashMapStage.setWidth(this.width);
        this.HashMapStage.setHeight(this.height);
        this.HashMapStage.initModality(Modality.APPLICATION_MODAL);

        Font font = Font.font("Courier New", FontWeight.BOLD, 24);

        //drawing nodes to the scene
        int startingPositionX = 10;
        int startingPositionY = 300;
        for(int i = 0; i < this.hashMapNodes.length; i++){
            hashMapNodes[i].node.setLayoutX(startingPositionX + (i * 150));
            hashMapNodes[i].node.setLayoutY(startingPositionY);
            hashMapNodes[i].updateLabel();
            int finalI = i;
            hashMapNodes[i].node.setOnMouseClicked(mouseEvent -> {
                hashMapNodes[finalI].binarySearchTree.BSTStage.show();
            });
            this.anchorPane.getChildren().add(hashMapNodes[i].node);
        }

        Label valueLabel = new Label();
        valueLabel.setFont(font);
        valueLabel.setText("Value :");
        valueLabel.setStyle("-fx-text-fill: #ffffff");
        valueLabel.setLayoutX(this.HashMapStage.getWidth() / 2 - 330);
        valueLabel.setLayoutY(450);
        this.anchorPane.getChildren().add(valueLabel);

        TextField valueField = new TextField();
        valueField.setPromptText("Enter value");
        valueField.setLayoutX(this.HashMapStage.getWidth() / 2 - 210);
        valueField.setLayoutY(450);
        this.anchorPane.getChildren().add(valueField);

        Button insertValue = new Button();
        insertValue.setText("Insert");
        insertValue.setTextAlignment(TextAlignment.CENTER);
        insertValue.setFont(font);
        insertValue.setPrefWidth(275);
        insertValue.setPrefHeight(50);
        insertValue.setLayoutX(this.HashMapStage.getWidth() / 2 - 330);
        insertValue.setLayoutY(500);
        insertValue.setStyle("-fx-background-color: #0b85b9");
        insertValue.setOnMouseEntered(mouseEvent -> {
            insertValue.setStyle("-fx-background-color: #2baaf1");
        });
        insertValue.setOnMouseExited(mouseEvent -> {
            insertValue.setStyle("-fx-background-color: #0b85b9");
        });
        insertValue.setOnMouseClicked(mouseEvent -> {
            try{
                int value = Integer.parseInt(valueField.getText());
                int index = value % 10;
                hashMapNodes[index].binarySearchTree.insert(value);
                hashMapNodes[index].updateLabel();
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("Wrong argument!");
                alert.setHeaderText("User input has to be an integer.");
                alert.show();
            }
        });
        this.anchorPane.getChildren().add(insertValue);

        Button deleteValue = new Button();
        deleteValue.setText("Delete");
        deleteValue.setTextAlignment(TextAlignment.CENTER);
        deleteValue.setFont(font);
        deleteValue.setPrefWidth(275);
        deleteValue.setPrefHeight(50);
        deleteValue.setLayoutX(this.HashMapStage.getWidth() / 2 - 330);
        deleteValue.setLayoutY(570);
        deleteValue.setStyle("-fx-background-color: #0b85b9");
        deleteValue.setOnMouseClicked(mouseEvent -> {
            try{
                int value = Integer.parseInt(valueField.getText());
                int index = value % 10;
                hashMapNodes[index].binarySearchTree.delete(value);
                hashMapNodes[index].updateLabel();
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("Wrong argument!");
                alert.setHeaderText("User input has to be an integer.");
                alert.show();
            }
        });
        this.anchorPane.getChildren().add(deleteValue);

    }
    public Stage getHashMapStage(){
        return this.HashMapStage;
    }
}
