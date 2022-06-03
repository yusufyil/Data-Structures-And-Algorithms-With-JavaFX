package com.example.ds.BinarySearchTreeDataStructure;

import javafx.scene.Node;
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
        this.root = this.insertRecursively(root, value);
    }
    private BSTNode insertRecursively(BSTNode root, int value){

        if (root == null) {
            root = new BSTNode(value);
            return root;
        }

        if (value <= root.value) {
            root.left = insertRecursively(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursively(root.right, value);
        }
        return root;
    }
    public void delete(int value){
        this.root = deleteRecursively(root, value);
    }
    public BSTNode deleteRecursively(BSTNode root, int value){
        if (root == null){
            return root;
        }

        if (value < root.value) {
            root.left = deleteRecursively(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRecursively(root.right, value);
        }else {
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }

            root.value = minValue(root.right);

            root.right = deleteRecursively(root.right, root.value);
        }

        return root;
    }
    public int minValue(BSTNode root)
    {
        int min = root.value;
        while (root.left != null){
            min = root.left.value;
            root = root.left;
        }
        return min;
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
