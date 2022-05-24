package com.example.ds.StackDataStrcuture;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
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
    private int numberOfElements = 0;

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
        StackNode stackNode = new StackNode(key);
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
        lineLeft.setEndY(800);
        lineLeft.setStrokeWidth(5);
        lineLeft.setStyle("-fx-stroke: " + color);
        this.anchorPane.getChildren().add(lineLeft);

        Line lineRight = new Line();
        lineRight.setStartX(250);
        lineRight.setStartY(100);
        lineRight.setEndX(250);
        lineRight.setEndY(800);
        lineRight.setStrokeWidth(5);
        lineRight.setStyle("-fx-stroke: " + color);
        this.anchorPane.getChildren().add(lineRight);

        Line lineBottom = new Line();
        lineBottom.setStartX(50);
        lineBottom.setStartY(800);
        lineBottom.setEndX(250);
        lineBottom.setEndY(800);
        lineBottom.setStrokeWidth(5);
        lineBottom.setStyle("-fx-stroke: " + color);
        this.anchorPane.getChildren().add(lineBottom);

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        TextField textField = new TextField();
        textField.setLayoutX(990);
        textField.setLayoutY(100);
        textField.setPrefWidth(390);
        textField.setPrefHeight(60);
        textField.setStyle("-fx-background-color: " + color);
        textField.setFont(font);
        textField.setText("Any number");
        this.anchorPane.getChildren().add(textField);

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
        pushToStack.setOnMouseClicked(mouseEvent -> {
            try{
                int value = readFromTextField(textField.getText());
                System.out.println(value);
                insert(value);
                StackNode top = this.top;
                top.setLayoutX(-400);
                top.setLayoutY(20);
                //making node come from outside of screen
                TranslateTransition rightTransition = new TranslateTransition();
                rightTransition.setNode(top);
                rightTransition.setByX(455);

                //pushing node down to bottom
                TranslateTransition bottomTransition = new TranslateTransition();
                bottomTransition.setNode(top);
                bottomTransition.setByY(715 - (63 * numberOfElements));

                SequentialTransition sequentialTransition = new SequentialTransition(rightTransition, bottomTransition);
                sequentialTransition.play();

                numberOfElements++;
                this.anchorPane.getChildren().add(top);
                this.anchorPane.getChildren().add(top.text);
            }catch (Exception e){
                System.out.println("Error");
            }
        });
        this.anchorPane.getChildren().add(pushToStack);


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
    public int readFromTextField(String textField){
        return Integer.valueOf(textField);
    }
}
