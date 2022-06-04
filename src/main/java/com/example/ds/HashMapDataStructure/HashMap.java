package com.example.ds.HashMapDataStructure;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HashMap {
    HashMapNode[] hashMapNodes;

    Stage HashMapStage;

    Scene scene;

    AnchorPane anchorPane;

    int width;

    int height;

    public HashMap(int screenWidth, int screenHeight) {
        this.width = screenWidth;
        this.height = screenHeight;
        this.anchorPane = new AnchorPane();
        this.scene = new Scene(anchorPane);
        this.HashMapStage = new Stage();
        this.HashMapStage.setScene(scene);
        this.setUpScreen();
        this.hashMapNodes = new HashMapNode[10];
        for(int i = 0; i < hashMapNodes.length; i++){
            hashMapNodes[i] = new HashMapNode();
        }
    }
    public void setUpScreen(){
        this.anchorPane.setStyle("-fx-background-color: #112a7a");
        this.HashMapStage.setTitle("Hash Map Data Structure.");
        this.HashMapStage.setResizable(false);
        this.HashMapStage.setWidth(this.width);
        this.HashMapStage.setHeight(this.height);
        this.HashMapStage.initModality(Modality.APPLICATION_MODAL);
    }
    public Stage getHashMapStage(){
        return this.HashMapStage;
    }
}
