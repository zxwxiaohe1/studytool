package com.study.en.controller;

import com.study.en.domain.service.ArticleService;
import com.study.en.utils.ConstantUtil;
import com.study.en.view.EnglishFormatView;
import javafx.event.Event;
import javafx.fxml.FXML;
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
    public EnglishFormatView englishFormatView;
    @FXML
    public Pane dynamicPane;
    @FXML
    public SplitPane splitPane;


    public void showEnglishFormatView(final Event e) {
        dynamicPane.getChildren().clear();
        dynamicPane.getChildren().add(englishFormatView.getView());
    }
}
