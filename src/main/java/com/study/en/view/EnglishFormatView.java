package com.study.en.view;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLView(value = "/fxml/englishFormat.fxml", encoding = "utf-8")
public class EnglishFormatView extends AbstractFxmlView implements Initializable {

    @FXML
    public FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
    }
}
