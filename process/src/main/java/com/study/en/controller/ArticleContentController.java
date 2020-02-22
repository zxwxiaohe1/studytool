package com.study.en.controller;

import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.service.ArticleService;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.view.ArticleContentView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author heyong
 * @date 2020/2/22
 */
@FXMLController
public class ArticleContentController implements Initializable {

    @FXML
    public TextArea contentTextArea;
    @FXML
    public Pane articleContentPane;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleContentView articleContentView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contentTextArea.requestFocus();
        contentTextArea.setFocusTraversable(true);
        contentTextArea.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue.booleanValue()) {
                    if (!ObjectUtils.isEmpty(articleContentView) && !ObjectUtils.isEmpty(articleContentView.getEnglishArticle())) {
                        if (articleContentView.getFrameFirstOpen()) {
                            contentTextArea.setText(articleContentView.getEnglishArticle().getContent());
                            articleContentView.setFrameFirstOpen(false);
                        }
                    }
                }
            }
        });
    }

    @FXML
    public void commitArticleContent(Event event) throws IOException {
        articleContentView.getEnglishArticle().setId(IdGen.uuid(articleContentView.getEnglishArticle().getTitle()));
        articleContentView.getEnglishArticle().setContent(contentTextArea.getText());
        articleService.saveOrUpdate(articleContentView.getEnglishArticle());
        DialogUtils.hintDialog((Stage) articleContentPane.getScene().getWindow(), "hint", "commit sucess !");
    }
}
