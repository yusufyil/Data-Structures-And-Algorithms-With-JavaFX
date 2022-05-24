package com.example.ds.StackDataStrcuture;

import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StackNode extends Rectangle {
    private int value;
    private StackNode next;

    public Text text;

    public StackNode(int value) {
        this.next = null;
        this.value = value;
        setWidth(190);
        setHeight(60);
        setStyle("-fx-fill: #d76464");
        setArcWidth(20);
        setArcHeight(20);
        text = new Text();
        text.setText(Integer.toString(value));
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        text.setFont(font);
        text.setLayoutX(getLayoutX());
        text.setLayoutY(getLayoutY());



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
