package com.example.ds.BinarySearchTreeDataStructure;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    public int minValue(BSTNode root) {
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
    public void setUpMiniScreen(){
        //crating a mini screen for assigning values into tree.
        VBox vBox = new VBox();
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        TextField textField = new TextField();
        textField.setPrefWidth(390);
        textField.setPrefHeight(60);
        textField.setStyle("-fx-background-color: #9fbbea");
        textField.setFont(font);
        textField.setPromptText("Any number");
        vBox.getChildren().add(textField);

        Button insertToTree = new Button();
        insertToTree.setText("Insert");
        insertToTree.setPrefWidth(390);
        insertToTree.setPrefHeight(60);
        insertToTree.setFont(font);
        insertToTree.setStyle("-fx-background-color: #2fdc60");
        insertToTree.setOnMouseEntered(mouseEvent -> {
            insertToTree.setStyle("-fx-background-color: #9fbbea");
        });
        insertToTree.setOnMouseExited(mouseEvent -> {
            insertToTree.setStyle("-fx-background-color: #2fdc60");
        });
        vBox.getChildren().add(insertToTree);

        Button deleteFromTree = new Button();
        deleteFromTree.setText("Delete");
        deleteFromTree.setPrefWidth(390);
        deleteFromTree.setPrefHeight(60);
        deleteFromTree.setFont(font);
        deleteFromTree.setStyle("-fx-background-color: #2fdc60");
        deleteFromTree.setOnMouseEntered(mouseEvent -> {
            deleteFromTree.setStyle("-fx-background-color: #9fbbea");
        });
        deleteFromTree.setOnMouseExited(mouseEvent -> {
            deleteFromTree.setStyle("-fx-background-color: #2fdc60");
        });
        vBox.getChildren().add(deleteFromTree);

        Scene scene1 = new Scene(vBox);
        Stage miniStage = new Stage();
        miniStage.setScene(scene1);
        miniStage.setAlwaysOnTop(true);
        miniStage.show();
    }
    public Stage getBSTStage(){
        return BSTStage;
    }

}
