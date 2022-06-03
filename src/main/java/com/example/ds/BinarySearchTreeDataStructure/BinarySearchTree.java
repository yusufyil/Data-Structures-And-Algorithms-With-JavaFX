package com.example.ds.BinarySearchTreeDataStructure;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BinarySearchTree {
    BSTNode root;

    //attributes for graphical user interface
    Stage BSTStage;

    Scene scene;

    AnchorPane anchorPane;

    private int width;

    private int height;

    public BinarySearchTree(int screenWidth, int screenHeight) {
        this.width = screenWidth;
        this.height = screenHeight;
        this.BSTStage = new Stage();
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(this.anchorPane);
        this.BSTStage.setScene(scene);
        this.setUpScreen();

    }
    public void insert(int value){

    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #0b9494");
        this.BSTStage.setTitle("Stack Data Structure.");
        this.BSTStage.setResizable(false);
        this.BSTStage.setWidth(this.width);
        this.BSTStage.setHeight(this.height);
        this.BSTStage.initModality(Modality.APPLICATION_MODAL);
    }
    public Stage getBSTStage(){
        return BSTStage;
    }

}
