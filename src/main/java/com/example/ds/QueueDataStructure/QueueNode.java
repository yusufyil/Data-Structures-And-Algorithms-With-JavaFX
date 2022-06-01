package com.example.ds.QueueDataStructure;

public class QueueNode {
    QueueNode next;
    int key;

    public QueueNode() {
        this.next = null;
        this.key = 0;
    }
    public  QueueNode(int key){
        this.key = key;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}

