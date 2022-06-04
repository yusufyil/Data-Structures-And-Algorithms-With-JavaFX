package com.example.ds.HashMapDataStructure;

import com.example.ds.BinarySearchTreeDataStructure.BinarySearchTree;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HashMapNode {

    Rectangle node;

    Label label;

    Group group;

    BinarySearchTree binarySearchTree;

    public HashMapNode() {
        this.node = new Rectangle();
        this.label = new Label();
        this.group = new Group();
        this.node.setWidth(190);
        this.node.setHeight(60);
        this.node.setStyle("-fx-fill: #d76464");
        this.node.setArcWidth(20);
        this.node.setArcHeight(20);
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        this.label.setFont(font);
        this.label.setLayoutY(8);
        this.label.setText("Null");
        group.getChildren().add(this.node);
        group.getChildren().add(this.label);
    }
    public void updateLabel(){
        if (this.binarySearchTree.root == null){
            this.label.setText("Null");
        }else {
            this.label.setText(Integer.toString(this.binarySearchTree.root.value));
        }
    }
}
