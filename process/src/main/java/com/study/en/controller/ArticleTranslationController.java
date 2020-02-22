package com.study.en.controller;

import com.study.en.domain.service.ArticleService;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.view.ArticleTranslationView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
public class ArticleTranslationController implements Initializable {

    @FXML
    public TextArea articleTranslation;
    @FXML
    public Pane articleTranslationPane;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTranslationView articleTranslationView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        articleTranslation.requestFocus();
        articleTranslation.setFocusTraversable(true);
        articleTranslation.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue.booleanValue()) {
                    if (!ObjectUtils.isEmpty(articleTranslationView) && !ObjectUtils.isEmpty(articleTranslationView.getEnglishArticle())) {
                        if (articleTranslationView.getFrameFirstOpen()) {
                            articleTranslation.setText(articleTranslationView.getEnglishArticle().getMean());
                            articleTranslationView.setFrameFirstOpen(false);
                        }
                    }
                }
            }
        });
    }

    @FXML
    public void commitArticleTranslation(Event event) throws IOException {
        articleTranslationView.getEnglishArticle().setId(IdGen.uuid(articleTranslationView.getEnglishArticle().getTitle()));
        articleTranslationView.getEnglishArticle().setMean(articleTranslation.getText());
        articleService.saveOrUpdate(articleTranslationView.getEnglishArticle());
        DialogUtils.hintDialog((Stage) articleTranslationPane.getScene().getWindow(),"hint","commit sucess !");
    }
}
