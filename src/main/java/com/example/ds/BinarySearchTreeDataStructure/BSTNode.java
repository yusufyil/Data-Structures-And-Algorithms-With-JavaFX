package com.example.ds.BinarySearchTreeDataStructure;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BSTNode {
    BSTNode left;
    BSTNode right;
    public int value;

    //attributes for graphical user interface
    Group group;

    Circle circle;

    Label label;

    public BSTNode() {
        this.circle = new Circle();
        this.label = new Label();
        this.group = new Group();
        this.circle.setRadius(36);
        this.circle.setStyle("-fx-fill: #d76464");
        Font font = Font.font("Courier New", FontWeight.BOLD, 24);
        this.label.setFont(font);
        this.label.setLayoutX(-15);
        this.label.setLayoutY(-15);
        this.group.getChildren().add(this.circle);
        this.group.getChildren().add(this.label);
    }

    public BSTNode(int value) {
        this();
        this.value = value;
        this.label.setText(Integer.toString(value));
    }
}
