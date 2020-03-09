package com.study.en.controller;

import com.study.en.StudyApplication;
import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.ArticleService;
import com.study.en.domain.service.WordService;
import com.study.en.modules.vo.Mean;
import com.study.en.support.ennum.WordExportType;
import com.study.en.support.ennum.WordType;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.utils.JacksonUtil;
import com.study.en.view.ArticleContentView;
import com.study.en.view.ArticleTranslationView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author heyong
 */
@FXMLController
public class AddWordController extends BaseController implements Initializable {

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
    @FXML
    public Label wordDialog;
    @FXML
    public Label meanDialog;
    @Autowired
    private WordService wordService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleContentView articleContentView;
    @Autowired
    private ArticleTranslationView articleTranslationView;
    @FXML
    public Label articleTitleLabel;
    @FXML
    public Label articleContentLabel;
    @FXML
    public Label transactionTitleLabel;
    @FXML
    public Label transactionContentLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (ObjectUtils.isEmpty(articleTitle)) {
            return;
        }
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
            article = articleService.getById(IdGen.uuid(articleTitle.getText()));
            if (ObjectUtils.isEmpty(article)) {
                articleDialog.setTextFill(Paint.valueOf("red"));
                articleDialog.setText("this article not exist !");
            } else {
                articleDialog.setTextFill(Paint.valueOf("green"));
                articleDialog.setText("this article already exist !");
                articleTitleLabel.setText("原文");
                articleContentLabel.setText(article.getContent());
                transactionTitleLabel.setText("译文");
                transactionContentLabel.setText(article.getMean());
            }
        } else {
            articleDialog.setText(null);
            articleTitleLabel.setText(null);
            articleContentLabel.setText(null);
            transactionTitleLabel.setText(null);
            transactionContentLabel.setText(null);
        }
    }

    @FXML
    public void articleButtonAction(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            if ("commit".equals(((Button) event.getSource()).getText())) {
                EnglishArticle article = null;
                String selected = ((RadioButton) this.enTypeGroup.getSelectedToggle()).getText();
                if (StringUtils.isNotBlank(targetId.getText())
                        && StringUtils.isNotBlank(meanId.getText())) {
                    article = articleService.getById(IdGen.uuid(articleTitle.getText()));
                    if (WordExportType.word.name().equals(selected)) {
                        EnglishWord word = wordService.getById(IdGen.uuid(targetId.getText()));
                        if (ObjectUtils.isEmpty(word)) {
                            word = new EnglishWord();
                            word.setId(IdGen.uuid(targetId.getText()));
                            word.setWord(targetId.getText());
                        } else {

                        }
                        if (!ObjectUtils.isEmpty(article)) {
                            if (StringUtils.isNotBlank(word.getArticleId())) {
                                word.setArticleId(word.getArticleId()
                                        .replaceAll(IdGen.uuid(ConstantUtil.ARTICLE_EMPTY_TITLE), "")
                                        .replaceAll(article.getId(), "")
                                        .replaceAll(ConstantUtil.FILE_POINT_ENGLISH + "+", ConstantUtil.FILE_POINT_ENGLISH)
                                        + ConstantUtil.FILE_POINT_ENGLISH + article.getId());
                            } else {
                                word.setArticleId(article.getId());
                            }
                        } else {
                            if (StringUtils.isBlank(word.getArticleId())) {
                                word.setArticleId(IdGen.uuid(ConstantUtil.ARTICLE_EMPTY_TITLE));
                            }
                        }
                        word.setMean(JacksonUtil.bean2Json(formatMeanToObj(meanId.getText())));
                        word.setCreateDate(new Date());
                        wordService.saveOrUpdate(word);
                    } else if (WordExportType.sentence.name().equals(selected)) {
                    } else {
                    }
                    DialogUtils.hintDialog((Stage) addWordPane.getScene().getWindow(), "hint", "commit sucess !");
                    wordDialog.setText(null);
                    meanDialog.setText(null);
                } else {
                    if (StringUtils.isBlank(targetId.getText())) {
                        wordDialog.setTextFill(Paint.valueOf("red"));
                        wordDialog.setText("please enter the word !");
                    }
                    if (StringUtils.isBlank(meanId.getText())) {
                        meanDialog.setTextFill(Paint.valueOf("red"));
                        meanDialog.setText("please enter the mean !");
                    }
                }
            }
        }
    }

    @FXML
    public void showArticleContentWindow(Event event) throws IOException {

        if (StringUtils.isBlank(articleTitle.getText())) {
            articleDialog.setTextFill(Paint.valueOf("red"));
            articleDialog.setText("please enter the name of the article !");
            return;
        } else {
            EnglishArticle article = articleService.getById(IdGen.uuid(articleTitle.getText()));
            if (ObjectUtils.isEmpty(article)) {
                article = new EnglishArticle();
                article.setTitle(articleTitle.getText());
            }
            if (event.getSource() instanceof Button) {
                if ("content".equals(((Button) event.getSource()).getText())) {
                    articleContentView.setEnglishArticle(article);
                    articleContentView.setFrameFirstOpen(true);
                    StudyApplication.showView(articleContentView, Modality.NONE, "article content");
                } else if ("translate".equals(((Button) event.getSource()).getText())) {
                    articleTranslationView.setEnglishArticle(article);
                    articleTranslationView.setFrameFirstOpen(true);
                    StudyApplication.showView(articleTranslationView, Modality.NONE, "article translation");
                }
            }

        }

    }


}
