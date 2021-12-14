package com.example.groupproject5;// James Abdallah
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChuckNorrisApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {
        FXMLLoader fxmlLoader = new FXMLLoader(ChuckNorrisApplication.class.getResource("chuckNorris.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        }
        catch (IOException e){
            System.out.println("Error loading FXML or exception in the controller class");
        }
        stage.setTitle("Chuck Norris Joke - James Abdallah");
        stage.setScene(scene);
        stage.show();
    }
}
