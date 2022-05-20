package com.example.ds.StackDataStrcuture;

import javafx.scene.shape.Circle;

public class StackNode extends Circle{
    private int value;
    private StackNode next;

    public StackNode() {
        this.next = null;
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
