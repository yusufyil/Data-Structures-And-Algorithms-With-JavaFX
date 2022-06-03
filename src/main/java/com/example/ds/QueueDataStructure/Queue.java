package com.example.ds.QueueDataStructure;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Queue {
    QueueNode front;
    QueueNode rear;
    int numberOfElements;

    //attributes for graphical user interface
    Stage queueStage;

    Scene scene;

    AnchorPane anchorPane;

    private int width;

    private int height;

    public Queue(int screenWidth, int screenHeight) {
        this.numberOfElements = 0;
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
        this.numberOfElements++;

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
        this.numberOfElements--;
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
        enqueue.setOnMouseEntered(mouseEvent -> {
            enqueue.setStyle("-fx-background-color: #092585");
        });
        enqueue.setOnMouseExited(mouseEvent -> {
            enqueue.setStyle("-fx-background-color: #76A4E7FF");
        });
        enqueue.setOnMouseClicked(mouseEvent -> {
            if(numberOfElements >= 11){
                System.out.println("Reached maximum number of elements.");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert!");
                alert.setHeaderText("Reached maximum number of elements.");
                alert.setContentText("There is not enough space to fit more nodes in to the scene.");
                alert.show();
                return;
            }
            try{
                int value = Integer.parseInt(textField.getText());
                this.enqueue(value);
                //this.rear.group.setLayoutX(55);
                //this.rear.group.setLayoutY(100);
                this.rear.group.setLayoutX(55);
                this.rear.group.setLayoutY(this.queueStage.getHeight());
                this.anchorPane.getChildren().add(this.rear.group);

                TranslateTransition transition = new TranslateTransition();
                transition.setNode(this.rear.group);
                transition.setByY(-(this.queueStage.getHeight() - 100) + ((numberOfElements - 1) * 63));
                transition.setDuration(Duration.millis(500));
                transition.play();


            }catch (Exception e){
                System.out.println("Error wrong argument has been delivered to method.");
            }
        });
        this.anchorPane.getChildren().add(enqueue);

        Button dequeue = new Button();
        dequeue.setLayoutX(400);
        dequeue.setLayoutY(300);
        dequeue.setText("Dequeue");
        dequeue.setPrefWidth(390.0);
        dequeue.setPrefHeight(60.0);
        dequeue.setFont(font);
        dequeue.setStyle("-fx-background-color: " + color);
        dequeue.setOnMouseEntered(mouseEvent -> {
            dequeue.setStyle("-fx-background-color: #092585");
        });
        dequeue.setOnMouseExited(mouseEvent -> {
            dequeue.setStyle("-fx-background-color: #76A4E7FF");
        });
        dequeue.setOnMouseClicked(mouseEvent -> {
            if(this.front == null){
                //queue is empty
                return;
            }
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(this.front.group);
            transition.setByY(-this.queueStage.getWidth());
            transition.setDuration(Duration.millis(500));
            transition.play();
            this.dequeue();

            //pushing up rest of queue because of visual issues
            SequentialTransition sequentialTransition = new SequentialTransition();
            QueueNode tempQueueNode = this.front;
            while (tempQueueNode != null){
                TranslateTransition translateTransition = new TranslateTransition();
                translateTransition.setNode(tempQueueNode.group);
                translateTransition.setByY(-62);
                translateTransition.setDuration(Duration.millis(500));
                sequentialTransition.getChildren().add(translateTransition);
                tempQueueNode = tempQueueNode.next;
            }
            sequentialTransition.play();

        });
        this.anchorPane.getChildren().add(dequeue);
    }

    public Stage getQueueStage() {
        return queueStage;
    }
}
