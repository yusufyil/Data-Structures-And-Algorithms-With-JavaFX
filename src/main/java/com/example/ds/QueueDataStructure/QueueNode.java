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
}

