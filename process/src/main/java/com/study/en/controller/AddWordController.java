package com.study.en.controller;

import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.service.ArticleService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@Controller
public class AddWordController implements Initializable {

    @FXML
    public BorderPane addWordPane;
    @FXML
    public TextField articleTitle;
    @FXML
    public TextField targetId;
    @FXML
    public TextArea meanId;
    @FXML
    public ToggleGroup enTypeGroup;
    @FXML
    public Label articleDialog;
    @Autowired
    private ArticleService articleService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        articleTitle.setFocusTraversable(true);
        articleTitle.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue.booleanValue()) {
                    focusLost();
                }
            }
        });
    }

    private void focusLost() {
        EnglishArticle article = null;
        if (StringUtils.isNotBlank(articleTitle.getText())) {
            article = articleService.getById(articleTitle.getText().trim());
            if (ObjectUtils.isEmpty(article)) {
                articleDialog.setTextFill(Paint.valueOf("red"));
                articleDialog.setText("this article not exist !");
            } else {
                articleDialog.setTextFill(Paint.valueOf("green"));
                articleDialog.setText("this article already exist !");
            }
        }
    }

    @FXML
    public void articleButtonAction(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            if ("search".equals(((Button) event.getSource()).getText())) {
                EnglishArticle article = null;
                if (StringUtils.isNotBlank(articleTitle.getText())) {
                    article = articleService.getById(articleTitle.getText().trim());
                    if (ObjectUtils.isEmpty(article)) {
                        articleDialog.setText("this article not exist !");
                        return;
                    }
                    articleDialog.setText("");
                }
            }
        }
    }
}
