package com.study.en.controller;

import com.study.en.StudyApplication;
import com.study.en.view.*;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
    @Autowired
    public CreateAccountView createAccountView;
    @Autowired
    public DecodePasswordView decodePasswordView;

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

    @FXML
    public void showCreateAccountView(final Event event) {

        StudyApplication.showView(createAccountView, Modality.NONE, "create account");
    }
    @FXML
    public void showdecodePasswordView(final Event event) {

        StudyApplication.showView(decodePasswordView, Modality.NONE, "decode password");
    }
}
