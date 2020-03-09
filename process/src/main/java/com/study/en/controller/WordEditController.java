package com.study.en.controller;

import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.entity.EnglishWordPrictice;
import com.study.en.domain.service.ArticleService;
import com.study.en.domain.service.WordPricticeService;
import com.study.en.domain.service.WordService;
import com.study.en.modules.vo.Mean;
import com.study.en.support.ennum.WordDiffType;
import com.study.en.utils.*;
import com.study.en.view.WordEditView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * @author xiaohe
 * @description:
 * @date 2020/3/9 11:40
 */
@Getter
@FXMLController
public class WordEditController extends BaseController implements Initializable {

    @FXML
    private TextField wordTextField;
    @FXML
    private TextField errorTimeTextField;
    @FXML
    private TextField artsTextField;
    @FXML
    private TextArea meanTextField;
    @FXML
    private Button editConfirmButton;
    @FXML
    private Button wrongNumButton;
    @Autowired
    private WordEditView wordEditView;
    @Autowired
    private WordService wordService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private WordPricticeService wordPricticeService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initpane();
        wordEditView.setOpened(true);
        wordTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!wordEditView.getOpened()) {
                    initpane();
                }
            }
        });
    }

    public void initpane() {
        EnglishWord englishWord = wordEditView.getEnglishWord();
        if (ObjectUtils.isEmpty(englishWord)) {
            return;
        }
        if (ObjectUtils.isEmpty(englishWord.getEnglishWordPrictice())) {
            errorTimeTextField.setText("0");
        } else {
            errorTimeTextField.setText(String.valueOf(englishWord.getEnglishWordPrictice().getErrorTime()));
        }
        wordTextField.setText(englishWord.getWord());
        meanTextField.setText(createViewMean(JacksonUtil.json2JavaType(englishWord.getMean(), List.class, Mean.class)));
        artsTextField.setText(formatWordsToView(englishWord).getArticleId());
    }

    @FXML
    public void editConfirmAction(ActionEvent event) {
        EnglishWord englishWord = new EnglishWord();
        englishWord.setId(IdGen.uuid(wordTextField.getText()));
        englishWord.setWord(wordTextField.getText());
        String[] artsStr = null;
        if (StringUtil.isNotBlank(artsTextField.getText())) {
            artsStr = artsTextField.getText().split(ConstantUtil.FILE_SPERATOR_ENGLISH);
        }
        if (!ObjectUtils.isEmpty(artsStr)) {
            List<EnglishArticle> articles = articleService.list();
            Map<String, String> articleMaps = null;
            if (!ObjectUtils.isEmpty(articles)) {
                articleMaps = articles.stream().collect(Collectors.toMap(EnglishArticle::getId, EnglishArticle::getTitle));
            }
            String arts = "";
            for (String art : artsStr) {
                if (ObjectUtils.isEmpty(articleMaps.get(IdGen.uuid(art)))) {
                    continue;
                }
                arts += IdGen.uuid(art) + ConstantUtil.FILE_POINT_ENGLISH;
            }
            englishWord.setArticleId(arts);
        }
        englishWord.setMean(JacksonUtil.bean2Json(formatMeanToObj(meanTextField.getText())));
        wordService.saveOrUpdate(englishWord);
        wordEditView.setEnglishWord(wordService.selectById(englishWord.getId()));
        DialogUtils.hintDialog("edit word", "update word successfully !");
    }

    @FXML
    public void updataWordPricticeAction(ActionEvent event) {
        EnglishWordPrictice englishWordPrictice = new EnglishWordPrictice();
        Integer errorTime = 0;
        if (StringUtil.isNotBlank(errorTimeTextField.getText())) {
            errorTime = Integer.valueOf(errorTimeTextField.getText());
        }
        englishWordPrictice.setWordId(IdGen.uuid(wordTextField.getText()));
        englishWordPrictice.setErrorTime(errorTime);
        if (errorTime >= WordDiffType.medium.errorTime()) {
            englishWordPrictice.setDifficultyLevel(WordDiffType.medium.sign());
        } else if (errorTime >= WordDiffType.hard.errorTime()) {
            englishWordPrictice.setDifficultyLevel(WordDiffType.hard.sign());
        } else {
            englishWordPrictice.setDifficultyLevel(WordDiffType.normal.sign());
        }
        wordPricticeService.saveOrUpdate(englishWordPrictice);
        wordEditView.setEnglishWord(wordService.selectById(englishWordPrictice.getWordId()));
        DialogUtils.hintDialog("edit word", "reset error time successfully !");
    }
}
