package com.example.ds.QueueDataStructure;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QueueNode {
    QueueNode next;
    int key;
    //for gui
    Group group;
    Rectangle rectangle;
    Label label;

    public QueueNode() {
        this.next = null;
        this.key = 0;
        this.group = new Group();
        this.rectangle = new Rectangle();
        this.label = new Label();
    }
    public  QueueNode(int key){
        this();
        this.key = key;
        this.rectangle.setWidth(190);
        this.rectangle.setHeight(60);
        this.rectangle.setStyle("-fx-fill: #d76464");
        this.rectangle.setArcWidth(20);
        this.rectangle.setArcHeight(20);
        this.label.setText(Integer.toString(key));
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        this.label.setFont(font);
        this.label.setLayoutY(8);
        group.getChildren().add(this.rectangle);
        group.getChildren().add(this.label);
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}

