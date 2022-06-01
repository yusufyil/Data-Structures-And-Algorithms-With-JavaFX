package com.example.ds.QueueDataStructure;

public class Queue {
    QueueNode front;
    QueueNode rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }
    public void enqueue(int key){
        QueueNode queueNode = new QueueNode(key);

        if(this.rear == null){
            this.rear = queueNode;
            this.front = queueNode;
            return;
        }else{
            this.rear.next = queueNode;
            this.rear = queueNode;
        }
    }
    public void dequeue(){
        if (this.front == null){
            return;
        }else{
            QueueNode temp = this.front;
            this.front = this.front.next;
            if (this.front == null){
                this.rear = null;
            }
        }
    }
}
