package com.study.en.controller;

import com.study.en.view.AddWordView;
import com.study.en.view.EnglishFormatView;
import com.study.en.view.MainView;
import com.study.en.view.WordPricticeView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@FXMLController
public class MainController implements Initializable {

    @Autowired
    public MainView mainView;
    @Autowired
    public AddWordView addWordView;
    @Autowired
    public EnglishFormatView englishFormatView;
    @Autowired
    public WordPricticeView wordPricticeView;
    @FXML
    public Pane dynamicPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void showEnglishFormatView(final Event e) {
        if (e.getSource() instanceof Button) {
            dynamicPane.getChildren().clear();
            if (mainView.getEnglishFormatId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(englishFormatView.getView());
            } else if (mainView.getWordNotebookId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(addWordView.getView());
            } else if (mainView.getWordPricticeId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(wordPricticeView.getView());
            }
        }

    }
}
