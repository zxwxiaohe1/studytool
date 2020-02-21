package com.study.en.controller;

import com.study.en.domain.service.ArticleService;
import com.study.en.utils.ConstantUtil;
import com.study.en.view.AddWordView;
import com.study.en.view.EnglishFormatView;
import com.study.en.view.MainView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 */
@Controller
public class MainController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    public MainView mainView;
    @Autowired
    public AddWordView addWordView;
    @Autowired
    public EnglishFormatView englishFormatView;
    @FXML
    public Pane dynamicPane;


    public void showEnglishFormatView(final Event e) {
        if (e.getSource() instanceof Button) {
            dynamicPane.getChildren().clear();
            if (mainView.getEnglishFormatId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(englishFormatView.getView());
            } else if (mainView.getWordNotebookId().equals(((Button) e.getSource()).getId())) {
                dynamicPane.getChildren().add(addWordView.getView());
            }
        }

    }
}
