package com.example.ds.StackDataStrcuture;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class StackNode extends Rectangle {
    private int value;
    private StackNode next;

    public Label label;

    public StackNode(int value) {
        this.next = null;
        this.value = value;
        setWidth(190);
        setHeight(60);
        setStyle("-fx-fill: #d76464");
        setArcWidth(20);
        setArcHeight(20);
        label = new Label(Integer.toString(value));

    }
    public void placeLabel(AnchorPane pane, int numberOfElements){
        label.setLayoutX(-400);
        label.setLayoutY(20);
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        label.setFont(font);
        pane.getChildren().add(label);

        TranslateTransition rightTransition = new TranslateTransition();
        rightTransition.setNode(label);
        rightTransition.setDuration(Duration.millis(500));
        rightTransition.setByX(455);


        TranslateTransition bottomTransition = new TranslateTransition();
        bottomTransition.setNode(label);
        bottomTransition.setDuration(Duration.millis(500));
        bottomTransition.setByY(722 - (63 * numberOfElements));


        SequentialTransition sequentialTransition = new SequentialTransition(rightTransition, bottomTransition);
        sequentialTransition.play();

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
