package com.example.ds.QueueDataStructure;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Queue {
    QueueNode front;
    QueueNode rear;

    //attributes for graphical user interface
    Stage queueStage;

    Scene scene;

    AnchorPane anchorPane;

    private int width;

    private int height;

    public Queue(int screenWidth, int screenHeight) {
        this.front = null;
        this.rear = null;
        this.width = screenWidth;
        this.height = screenHeight;
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane, this.width, this.width);
        this.queueStage = new Stage();
        this.queueStage.setScene(this.scene);
        this.setUpScreen();

    }
    public void enqueue(int key){
        QueueNode queueNode = new QueueNode(key);

        if(this.rear == null){
            this.rear = queueNode;
            this.front = queueNode;
            return;
        }else{
            this.rear.next = queueNode;
            this.rear = queueNode;
        }
    }
    public void dequeue(){
        if (this.front == null){
            return;
        }else{
            QueueNode temp = this.front;
            this.front = this.front.next;
            if (this.front == null){
                this.rear = null;
            }
        }
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #096085");
        this.queueStage.setTitle("Stack Data Structure.");
        this.queueStage.setResizable(false);
        this.queueStage.setWidth(this.width);
        this.queueStage.setHeight(this.height);
        this.queueStage.initModality(Modality.APPLICATION_MODAL);

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

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        TextField textField = new TextField();
        textField.setLayoutX(990);
        textField.setLayoutY(100);
        textField.setPrefWidth(390);
        textField.setPrefHeight(60);
        textField.setStyle("-fx-background-color: " + color);
        textField.setFont(font);
        textField.setPromptText("Any number");
        this.anchorPane.getChildren().add(textField);

        Button enqueue = new Button();
        enqueue.setLayoutX(400);
        enqueue.setLayoutY(100);
        enqueue.setText("Enqueue");
        enqueue.setPrefWidth(390);
        enqueue.setPrefHeight(60);
        enqueue.setFont(font);
        enqueue.setStyle("-fx-background-color: " + color);
        this.anchorPane.getChildren().add(enqueue);

    }

    public Stage getQueueStage() {
        return queueStage;
    }
}
