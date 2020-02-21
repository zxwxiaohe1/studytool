package com.study.en.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class AddWordController implements Initializable {
    @FXML
    public BorderPane addWordPane;
    @FXML
    public SplitPane wordSplitPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        wordSplitPane.setStyle("-fx-padding: 0 3 0 0;");
    }
}
