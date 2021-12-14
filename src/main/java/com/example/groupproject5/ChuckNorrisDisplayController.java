// James Abdallah
package com.example.groupproject5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ChuckNorrisDisplayController implements Initializable {
    private String selectedCategory;
    @FXML
    private TextArea jokeDisplay;

    @FXML
    public void catButtonPress(ActionEvent event){
        var buttonPressed = (Button)event.getSource();
        selectedCategory = buttonPressed.getText();
        var Joke = new ChuckNorrisDataHandler();
        jokeDisplay.setText(Joke.loadJoke(selectedCategory));
    }
    @FXML
    public void handleClose(ActionEvent event){
        System.exit(0);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
