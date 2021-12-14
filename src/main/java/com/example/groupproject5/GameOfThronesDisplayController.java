package com.example.groupproject5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOfThronesDisplayController implements Initializable {
    @FXML
    private TextField BookName;
    @FXML
    private TextField ISBNField;
    @FXML
    private TextField PageNumberField;
    @FXML
    private ListView<GameOfThronesDataHandler.BookDataType> ListControl;
    private GameOfThronesDataHandler Model;

    public void loadData(){
        var site = "https://www.anapioficeandfire.com/api/books";
        Model = new GameOfThronesDataHandler(site);
        var books = Model.getData();
        ObservableList<GameOfThronesDataHandler.BookDataType> BookList = FXCollections.observableArrayList(books);
        ListControl.setItems(BookList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        ListControl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GameOfThronesDataHandler.BookDataType>() {
            @Override
            public void changed(ObservableValue<? extends GameOfThronesDataHandler.BookDataType> observableValue, GameOfThronesDataHandler.BookDataType bookDataType, GameOfThronesDataHandler.BookDataType t1) {
                BookName.setText(t1.name);
                ISBNField.setText((t1.isbn));
                PageNumberField.setText(t1.numberOfPages.toString());
            }
        });
    }
}