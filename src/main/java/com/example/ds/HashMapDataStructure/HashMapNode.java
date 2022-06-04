package com.example.ds.HashMapDataStructure;

import com.example.ds.BinarySearchTreeDataStructure.BinarySearchTree;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class HashMapNode {

    Button node;

    BinarySearchTree binarySearchTree;

    public HashMapNode(int width, int height) {
        this.node = new Button();
        this.node.setPrefWidth(140);
        this.node.setPrefHeight(60);
        this.node.setStyle("-fx-background-color: #d76464");
        Font font = Font.font("Courier New", FontWeight.BOLD, 24);
        this.node.setFont(font);
        this.node.setTextAlignment(TextAlignment.CENTER);
        this.binarySearchTree = new BinarySearchTree(width, height);

    }
    public void updateLabel(){
        if (this.binarySearchTree.root == null){
            this.node.setText("Null");
        }else {
            this.node.setText(Integer.toString(this.binarySearchTree.root.value));
        }
    }
}
