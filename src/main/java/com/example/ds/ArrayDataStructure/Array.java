package com.example.ds.ArrayDataStructure;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Array {

    int[] arr;
    ArrayList<Label> listOfLabels;

    Stage arrayStage;

    Scene scene;

    AnchorPane anchorPane;

    private int width;

    private int height;

    public Array(int screenWidth, int screenHeight) {
        this.width = screenWidth;
        this.height = screenHeight;
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane, this.width, this.height);
        this.arrayStage = new Stage();
        this.arrayStage.setScene(this.scene);
        this.listOfLabels = new ArrayList<>();
        this.setUpScreen();
    }
    public void createArray(int size){
        arr = new int[size];
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #2d9614");
        this.arrayStage.setTitle("Array Data Structure.");
        this.arrayStage.setResizable(false);
        this.arrayStage.setWidth(this.width);
        this.arrayStage.setHeight(this.height);
        this.arrayStage.initModality(Modality.APPLICATION_MODAL);

        Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        Button createArrayButton = new Button();
        TextField arraySize = new TextField();

        createArrayButton.setText("Create");
        createArrayButton.setPrefWidth(390);
        createArrayButton.setPrefHeight(60);
        createArrayButton.setFont(font);
        createArrayButton.setLayoutX(200);
        createArrayButton.setLayoutY(400);
        createArrayButton.setStyle("-fx-background-color: #07af98");
        anchorPane.getChildren().add(createArrayButton);
        createArrayButton.setOnMouseClicked(mouseEvent -> {
            try{
                int size = Integer.parseInt(arraySize.getText());
                if (size <= 0 || size > 15){
                    throw new Exception();
                }else {
                    arr = new int[size];
                    anchorPane.getChildren().remove(createArrayButton);
                    anchorPane.getChildren().remove(arraySize);
                    this.drawArrayToPane();
                }
            }catch (Exception e){
                System.out.println("Error.");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Wrong input has been given.");
                alert.setContentText("Input has to be a valid integer in range of 1 and 15 exclusively.");
                alert.show();

            }
        });
        createArrayButton.setOnMouseEntered( mouseEvent -> {
            createArrayButton.setStyle("-fx-background-color: #02e1c1");
        });
        createArrayButton.setOnMouseExited( mouseEvent -> {
            createArrayButton.setStyle("-fx-background-color: #07af98");
        });

        arraySize.setPromptText("Enter Array Size");
        arraySize.setFont(font);
        arraySize.setPrefWidth(390);
        arraySize.setPrefHeight(60);
        arraySize.setLayoutX(900);
        arraySize.setLayoutY(400);
        arraySize.setStyle("-fx-background-color: #07af98");
        anchorPane.getChildren().add(arraySize);
    }
    public void drawArrayToPane(){
        Font font = Font.font("Courier New", FontWeight.BOLD, 24);
        Group arrayBoundries = new Group();

        //drawing an appropriate rectangle to represent array
        int startingPositionX = ((int)arrayStage.getWidth() - (100 * this.arr.length + (this.arr.length + 1) * 5)) / 2;
        for(int i = 0; i < this.arr.length; i++){
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(100);
            rectangle.setHeight(60);
            rectangle.setLayoutX(startingPositionX + i * 100);
            rectangle.setLayoutY(200);
            rectangle.setStyle("-fx-background-color: #91f3b8");
            arrayBoundries.getChildren().add(rectangle);

            Label value = new Label(Integer.toString(this.arr[i]));
            value.setFont(font);
            value.setPrefWidth(100);
            value.setPrefHeight(60);
            value.setLayoutX(startingPositionX + 5 + i * 100);
            value.setLayoutY(200);
            value.setStyle("-fx-background-color: #91f3b8");
            listOfLabels.add(value);
            arrayBoundries.getChildren().add(value);

            Line upperLine = new Line();
            upperLine.setStartX(startingPositionX + i * 100);
            upperLine.setStartY(200);
            upperLine.setEndX(startingPositionX + i * 100 + 100);
            upperLine.setEndY(200);
            upperLine.setStrokeWidth(5);
            arrayBoundries.getChildren().add(upperLine);

            Line bottomLine = new Line();
            bottomLine.setStartX(startingPositionX + i * 100);
            bottomLine.setStartY(260);
            bottomLine.setEndX(startingPositionX + i * 100 + 100);
            bottomLine.setEndY(260);
            bottomLine.setStrokeWidth(5);
            arrayBoundries.getChildren().add(bottomLine);

            Line sideLine = new Line();
            sideLine.setStartX(startingPositionX + i * 100 + 105);
            sideLine.setStartY(200);
            sideLine.setEndX(startingPositionX + i * 100 + 105);
            sideLine.setEndY(260);
            sideLine.setStrokeWidth(5);
            arrayBoundries.getChildren().add(sideLine);
        }
        //adding first vertical line to the pane
        Line startingline = new Line();
        startingline.setStartX(startingPositionX);
        startingline.setStartY(200);
        startingline.setEndX(startingPositionX);
        startingline.setEndY(260);
        startingline.setStrokeWidth(5);
        arrayBoundries.getChildren().add(startingline);

        this.anchorPane.getChildren().add(arrayBoundries);

        Label indexLabel = new Label();
        indexLabel.setFont(font);
        indexLabel.setText("Index :");
        indexLabel.setLayoutX(this.arrayStage.getWidth() / 2 - 120);
        indexLabel.setLayoutY(400);
        this.anchorPane.getChildren().add(indexLabel);

        Label valueLabel = new Label();
        valueLabel.setFont(font);
        valueLabel.setText("Value :");
        valueLabel.setLayoutX(this.arrayStage.getWidth() / 2 - 120);
        valueLabel.setLayoutY(450);
        this.anchorPane.getChildren().add(valueLabel);

        TextField indexField = new TextField();
        indexField.setPromptText("Enter index number");
        indexField.setLayoutX(this.arrayStage.getWidth() / 2 );
        indexField.setLayoutY(400);
        this.anchorPane.getChildren().add(indexField);

        TextField valueField = new TextField();
        valueField.setPromptText("Enter value");
        valueField.setLayoutX(this.arrayStage.getWidth() / 2 );
        valueField.setLayoutY(450);
        this.anchorPane.getChildren().add(valueField);

        Button insertValue = new Button();
        insertValue.setText("Insert");
        insertValue.setTextAlignment(TextAlignment.CENTER);
        insertValue.setFont(font);
        insertValue.setPrefWidth(275);
        insertValue.setPrefHeight(50);
        insertValue.setLayoutX(this.arrayStage.getWidth() / 2 - 120);
        insertValue.setLayoutY(500);
        insertValue.setStyle("-fx-background-color: #2ada72");
        insertValue.setOnMouseEntered(mouseEvent -> {
            insertValue.setStyle("-fx-background-color: #91f3b8");
        });
        insertValue.setOnMouseExited(mouseEvent -> {
            insertValue.setStyle("-fx-background-color: #2ada72");
        });
        insertValue.setOnMouseClicked(mouseEvent -> {
            try{
                int index = Integer.parseInt(indexField.getText());
                int value = Integer.parseInt(valueField.getText());
                listOfLabels.get(index).setText(String.valueOf(value));
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("Each text-field should be correctly filled.");
                alert.setContentText("Both text-fields are have to filled with whole numbers and index field can't exceed" +
                        " length of array.");
                alert.show();
            }
        });
        this.anchorPane.getChildren().add(insertValue);



    }
    public Stage getArrayStage(){
        return this.arrayStage;
    }
}
