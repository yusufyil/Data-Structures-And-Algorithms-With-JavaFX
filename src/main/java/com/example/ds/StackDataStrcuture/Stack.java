package com.example.ds.StackDataStrcuture;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Stack {
    StackNode top;

    //attributes for graphical user interface

    Stage stackStage;

    Scene scene;

    AnchorPane anchorPane;

    private int width;

    private int height;

    public Stack(int screenWidth, int screenHeight) {
        this.top = null;
        this.width = screenWidth;
        this.height = screenHeight;
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane, this.width, this.height);
        this.stackStage = new Stage();
        this.stackStage.setScene(this.scene);
        this.setUpScreen();
    }

    public void insert(int key){
        /**
         * this method inserts new value to on top of stack
         */
        StackNode stackNode = new StackNode();
        stackNode.setValue(key);
        //assigning next node to top element of stack
        stackNode.setNext(this.top);
        this.top = stackNode;
    }
    public int peek(){
        return this.top.getValue();
    }
    public int pop(){
        int valueToReturn = this.top.getValue();
        if(this.top.getNext() != null){
            this.top = this.top.getNext();
        }else{
            this.top = null;
        }
        return valueToReturn;
    }
    public void clearStack(){
        /**
         * this method clears entire stack
         */
        this.top = null;
    }
    public void printStack(){
        /**
         * this method prints out entire stack one by one, from top to bottom
         */
        StackNode index = this.top;
        while(index != null){
            System.out.println("Value: " + index.getValue());
            index = index.getNext();
        }
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #096085");
        this.stackStage.setTitle("Stack Data Structure.");
        this.stackStage.setResizable(false);
        this.stackStage.setWidth(this.width);
        this.stackStage.setHeight(this.height);
        this.stackStage.initModality(Modality.APPLICATION_MODAL);

        //setting up scene for stack data type
        String color = "#76a4e7";
        Line lineLeft = new Line();
        lineLeft.setStartX(50);
        lineLeft.setStartY(100);
        lineLeft.setEndX(50);
        lineLeft.setEndY(600);
        lineLeft.setStrokeWidth(5);
        lineLeft.setStyle("-fx-stroke: " + color);
        this.anchorPane.getChildren().add(lineLeft);

        Line lineRight = new Line();
        lineRight.setStartX(250);
        lineRight.setStartY(100);
        lineRight.setEndX(250);
        lineRight.setEndY(600);
        lineRight.setStrokeWidth(5);
        lineRight.setStyle("-fx-stroke: " + color);
        this.anchorPane.getChildren().add(lineRight);

        Line lineBottom = new Line();
        lineBottom.setStartX(50);
        lineBottom.setStartY(600);
        lineBottom.setEndX(250);
        lineBottom.setEndY(600);
        lineBottom.setStrokeWidth(5);
        lineBottom.setStyle("-fx-stroke: " + color);
        this.anchorPane.getChildren().add(lineBottom);

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        Button pushToStack = new Button();
        pushToStack.setLayoutX(400);
        pushToStack.setLayoutY(100);
        pushToStack.setText("Push");
        pushToStack.setPrefWidth(390);
        pushToStack.setPrefHeight(60);
        pushToStack.setFont(font);
        pushToStack.setStyle("-fx-background-color: " + color);
        pushToStack.setOnMouseEntered(mouseEvent -> {
            pushToStack.setStyle("-fx-background-color: #9fbbea");
        });
        pushToStack.setOnMouseExited(mouseEvent -> {
            pushToStack.setStyle("-fx-background-color: " + color);
        });
        this.anchorPane.getChildren().add(pushToStack);

        TextField textField = new TextField();
        textField.setLayoutX(990);
        textField.setLayoutY(100);
        textField.setPrefWidth(390);
        textField.setPrefHeight(60);
        textField.setStyle("-fx-background-color: " + color);
        textField.setFont(font);
        textField.setText("Any number");
        this.anchorPane.getChildren().add(textField);

        Button popFromStack = new Button();
        popFromStack.setLayoutX(400);
        popFromStack.setLayoutY(300);
        popFromStack.setText("Pop");
        popFromStack.setPrefWidth(390);
        popFromStack.setPrefHeight(60);
        popFromStack.setFont(font);
        popFromStack.setStyle("-fx-background-color: " + color);
        popFromStack.setOnMouseEntered(mouseEvent -> {
            popFromStack.setStyle("-fx-background-color: #9fbbea");
        });
        popFromStack.setOnMouseExited(mouseEvent -> {
            popFromStack.setStyle("-fx-background-color: " + color);
        });
        this.anchorPane.getChildren().add(popFromStack);

        Button peekFromStack = new Button();
        peekFromStack.setLayoutX(990);
        peekFromStack.setLayoutY(300);
        peekFromStack.setText("Peek");
        peekFromStack.setPrefWidth(390);
        peekFromStack.setPrefHeight(60);
        peekFromStack.setFont(font);
        peekFromStack.setStyle("-fx-background-color: " + color);
        peekFromStack.setOnMouseEntered(mouseEvent -> {
            peekFromStack.setStyle("-fx-background-color: #9fbbea");
        });
        peekFromStack.setOnMouseExited(mouseEvent -> {
            peekFromStack.setStyle("-fx-background-color: " + color);
        });
        this.anchorPane.getChildren().add(peekFromStack);


    }
    public Stage getStackStage(){

        return this.stackStage;
    }
}
