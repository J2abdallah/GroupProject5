package com.example.groupproject5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

//
public class MakeupDisplayController implements Initializable {
    @FXML
    private TextField NameField;
    @FXML
    private TextField BrandField;
    @FXML
    private TextField DescriptionField;
    @FXML
    private TextField PriceField;
    @FXML
    private ListView<MakeupDataHandler.MakeupType> ListControl;
    private MakeupDataHandler Model;
    @FXML
    private void loadData(){
        var site = "";
        String param = getQueryParam();
    }

    private String getQueryParam() {
        var inputDialog = new TextInputDialog(" ");
        inputDialog.seeContentText();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
