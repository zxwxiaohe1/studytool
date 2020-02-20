package com.study.en.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
public class EnglishFormatController {
    @FXML
    private HBox radioGroup;
    @FXML
    private HBox selectTextFile;
    @FXML
    private TextField textName;

    @FXML
    private void handleLoadClicked(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        Window stage = selectTextFile.getScene().getWindow();
        fileChooser.setTitle("Load Dialog");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                File loadFile = file.getParentFile();
                fileChooser.setInitialDirectory(loadFile);
                textName.setText(file.getAbsolutePath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void selectRadio(ActionEvent event) {
       System.out.println(event.getEventType());
    }

}
