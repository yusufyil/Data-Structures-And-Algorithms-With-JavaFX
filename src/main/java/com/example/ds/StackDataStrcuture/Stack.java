package com.example.ds.StackDataStrcuture;

import javafx.scene.Node;

public class Stack {
    StackNode top;

    public Stack() {
        this.top = null;
    }

    public static void main(String[] args) {

    }
    public void insert(int key){
        /**
         * this method inserts new value to on top of stack
         */
        StackNode stackNode = new StackNode();
        stackNode.setValue(key);
        //assigning next node to top element of stack
        stackNode.setNext(this.top);
        this.top = stackNode;
    }
    public int peek(){
        return this.top.getValue();
    }
    public int pop(){
        int valueToReturn = this.top.getValue();
        if(this.top.getNext() != null){
            this.top = this.top.getNext();
        }else{
            this.top = null;
        }
        return valueToReturn;
    }
    public void clearStack(){
        /**
         * this method clears entire stack
         */
        this.top = null;
    }
    public void printStack(){
        /**
         * this method prints out entire stack one by one, from top to bottom
         */
        StackNode index = this.top;
        while(index != null){
            System.out.println("Value: " + index.getValue());
            index = index.getNext();
        }
    }
}
