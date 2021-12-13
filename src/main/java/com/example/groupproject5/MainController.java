package com.example.groupproject5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Label welcomeText;


    @FXML
    public void handleOpenGameOfThrones(ActionEvent event){
        var secondLoc = new FXMLLoader(MainApplication.class.getResource("MainGameOfThrones.fxml"));
        Scene secondScene = null;
        try{
            secondScene = new Scene(secondLoc.load(), 900, 600);
        }catch (IOException e){
            System.out.println("Couldn't load Thrones window");
            e.printStackTrace();
        }
        Stage secondWindow = new Stage();
        secondWindow.setScene(secondScene);
        secondWindow.setTitle("See  - here is a second window");
        secondWindow.show();
    }

    @FXML
        public void handleOpenChuckNorris(ActionEvent event){
        var norrisWindow = new FXMLLoader(MainApplication.class.getResource("ChuckNorris.fxml"));
        Scene norrisScene = null;
        try {
            norrisScene = new Scene(norrisWindow.load(),1000,666);

        } catch (IOException e) {
            System.out.println("norris didnt load");
            e.printStackTrace();
        }
        Stage norrisStage = new Stage();
        norrisStage.setScene(norrisScene);
        norrisStage.setTitle("Norris Window");
        norrisStage.show();
    }

    @FXML
    public void handleClose(ActionEvent event){
        System.exit(0);
    }

}