package com.study.en.controller;

import com.study.en.domain.entity.EnglishWord;
import com.study.en.modules.vo.Mean;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.JacksonUtil;
import com.study.en.view.MatchWordView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@FXMLController
public class MatchWordController extends BaseController implements Initializable {

    @FXML
    public Label wordMeansLabel;
    @FXML
    public Label wordTargetLabel;
    @FXML
    public Label wordDidAndCount;
    @FXML
    public TextField inputWordTextField;
    @FXML
    public BorderPane matchWordContentPane;
    @Autowired
    private MatchWordView matchWordView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputWordTextField.requestFocus();
        inputWordTextField.setFocusTraversable(true);
        inputWordTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!matchWordView.getOpened() && newValue.booleanValue()) {
                    matchWordView.setOpened(true);
                    List<EnglishWord> englishWords = matchWordView.getEnglishWords();
                    if (ObjectUtils.isEmpty(englishWords)) {
                        wordMeansLabel.setText("");
                        wordDidAndCount.setText("0/0");
                        return;
                    }
                    matchWordView.setAmount(englishWords.size());
                    Collections.shuffle(englishWords);
                    EnglishWord word = englishWords.get(0);
                    if (ObjectUtils.isEmpty(word)) {
                        return;
                    }
                    wordMeansLabel.setText(createViewMean(JacksonUtil.json2JavaType(word.getMean(), List.class, Mean.class)));
                    wordTargetLabel.setText(word.getWord());
                    wordTargetLabel.setVisible(false);
                    englishWords.remove(0);
                    wordDidAndCount.setText((matchWordView.getAmount() - englishWords.size()) + "/" + matchWordView.getAmount());

                }
            }
        });
        inputWordTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    matchWord();
                } else if (ke.getCode().equals(KeyCode.DOWN)) {
                    nextWord();
                }
            }
        });
    }

    @FXML
    public void matchWordAction(ActionEvent event) {
        if ("matchWordButton".equals(((Button) event.getSource()).getId())) {
            matchWord();
        } else if ("nextWordButton".equals(((Button) event.getSource()).getId())) {
            nextWord();
        }
    }

    public void matchWord() {
        if (wordTargetLabel.getText().trim().toLowerCase().equals(inputWordTextField.getText().trim().toLowerCase())) {
            wordTargetLabel.setTextFill(Paint.valueOf("#006633"));
        } else {
            wordTargetLabel.setTextFill(Color.RED);
        }
        wordTargetLabel.setVisible(true);
    }

    public void nextWord() {
        if (wordTargetLabel.getText().trim().toLowerCase().equals(inputWordTextField.getText().trim().toLowerCase())) {
            wordTargetLabel.setTextFill(Paint.valueOf("#006633"));
            List<EnglishWord> englishWords = matchWordView.getEnglishWords();
            if (ObjectUtils.isEmpty(englishWords)) {
                DialogUtils.hintDialog("hint", "no words!");
                return;
            }
            EnglishWord word = englishWords.get(0);
            if (ObjectUtils.isEmpty(word)) {
                return;
            }
            wordMeansLabel.setText(createViewMean(JacksonUtil.json2JavaType(word.getMean(), List.class, Mean.class)));
            wordTargetLabel.setText(word.getWord());
            wordTargetLabel.setVisible(false);
            inputWordTextField.setText("");
            englishWords.remove(0);
            wordDidAndCount.setText((matchWordView.getAmount() - englishWords.size()) + "/" + matchWordView.getAmount());
        } else {
            DialogUtils.hintDialog("hint", "Please enter the word correctly!");
        }
    }

    private String createViewMean(List<Mean> means) {
        if (ObjectUtils.isEmpty(means)) {
            return "";
        }
        String meanStr = "";
        for (Mean m : means) {
            meanStr += m.getWordType() + ConstantUtil.FILE_PERIOD_ENGLISH + m.getMean() + "\n";
        }
        return meanStr;
    }

}
