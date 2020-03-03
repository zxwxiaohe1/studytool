package com.study.en.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.study.en.StudyApplication;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.WordService;
import com.study.en.support.ennum.WordDiffType;
import com.study.en.support.table.AddWordCell;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.view.MatchWordView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@FXMLController
public class WordPricticeController extends BaseController implements Initializable {

    @FXML
    public StackPane tableAnchorPane;
    @FXML
    public VBox centerVBox;
    @FXML
    public TextField articleTitle;
    @FXML
    public RadioButton wordRadioButton;
    @FXML
    public RadioButton articleRadioButton;
    @FXML
    public Button hintPageButton;
    @FXML
    public Button lastPageButton;
    @FXML
    public Button nextPageButton;
    @FXML
    public Button matchWordButton;
    @FXML
    public Button matchMeanButton;
    @FXML
    public Button chooseWordButton;
    @FXML
    public Button chooseMeanButton;
    @Autowired
    private WordService wordService;
    @Autowired
    private MatchWordView matchWordView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EnglishWord englishWord = new EnglishWord();
        List<EnglishWord> list = wordService.pageByLike(englishWord);
        Integer count = wordService.pageByLikeAccount(englishWord);
        if (!ObjectUtils.isEmpty(list)) {
            String hintPageButtonText = "1/1";
            if (count != 0) {
                Integer countPage = count / englishWord.getPage().getPageSize();
                if ((count % englishWord.getPage().getPageSize()) != 0) {
                    countPage += 1;
                }
                hintPageButtonText = "1/" + countPage;
            }
            hintPageButton.setText(hintPageButtonText);
            centerVBox.getChildren().add(createTableView(list));
        } else {
            centerVBox.getChildren().add(createTableView(null));
        }
    }

    public TableView<EnglishWord> createTableView(List<EnglishWord> words) {
        words = formatWordsToView(words);
        TableView<EnglishWord> tableView = new TableView<EnglishWord>();
        tableView.setEditable(true);

        TableColumn<EnglishWord, String> tcWord = new TableColumn<>("Word");
        tcWord.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getWord()));
//        tcWord.setSortable(false);
        tcWord.setResizable(false);
        tcWord.setEditable(true);
        tcWord.setMinWidth(150.0);
        tcWord.setMaxWidth(200.0);
        TableColumn<EnglishWord, String> tcMean = new TableColumn<>("Mean");
        tcMean.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getMean()));
//        tcMean.setSortable(false);
        tcMean.setResizable(false);
        tcMean.setEditable(true);
        tcMean.setMinWidth(250.0);
        tcMean.setMaxWidth(250.0);

        TableColumn<EnglishWord, String> tcArticle = new TableColumn<>("Article");
        tcArticle.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getArticleId()));
//        tcArticle.setSortable(false);
        tcArticle.setResizable(false);
        tcArticle.setEditable(true);
        tcArticle.setMinWidth(200.0);
        tcArticle.setMaxWidth(200.0);

        TableColumn<EnglishWord, Boolean> tcButton = new TableColumn<>("操作");
        tcButton.setCellFactory(new Callback<TableColumn<EnglishWord, Boolean>, TableCell<EnglishWord, Boolean>>() {
            @Override
            public TableCell<EnglishWord, Boolean> call(TableColumn<EnglishWord, Boolean> personBooleanTableColumn) {
                return new AddWordCell(tableView, new Button("del"), new Button("edit"));
            }
        });

        tableView.getColumns().add(tcWord);
        tableView.getColumns().add(tcMean);
        tableView.getColumns().add(tcArticle);
        tableView.getColumns().add(tcButton);


        ObservableList<EnglishWord> data = FXCollections.observableArrayList();
        if (!ObjectUtils.isEmpty(words)) {
            data.setAll(words);
        }
        tableView.setItems(data);
        return tableView;
    }

    @FXML
    public void searchArticleWord(ActionEvent event) {

        List<EnglishWord> words = null;
        String hintPageButtonText = "1/1";
        EnglishWord englishWord = new EnglishWord();
        if (StringUtils.isBlank(articleTitle.getText())) {
            words = wordService.pageByLike(englishWord);
        } else {
            if (wordRadioButton.isSelected()) {
                englishWord.setWord(articleTitle.getText());
            } else {
                englishWord.setArticleId(IdGen.uuid(articleTitle.getText()));
            }
            words = wordService.pageByLike(englishWord);
        }
        Integer count = wordService.pageByLikeAccount(englishWord);
        if (count != 0) {
            Integer countPage = count / englishWord.getPage().getPageSize();
            if ((count % englishWord.getPage().getPageSize()) != 0) {
                countPage += 1;
            }
            hintPageButtonText = "1/" + countPage;
        }
        hintPageButton.setText(hintPageButtonText);
        centerVBox.getChildren().clear();
        centerVBox.getChildren().add(createTableView(words));
    }

    @FXML
    public void goToPage(ActionEvent event) {
        EnglishWord englishWord = new EnglishWord();
        String[] showPages = hintPageButton.getText().split("/");
        Integer currPage = Integer.valueOf(showPages[0].trim());

        if ("goToLastPage".equals(((Button) event.getSource()).getId())) {
            if (currPage != 1) {
                currPage -= 2;
                englishWord.getPage().setStart(currPage * englishWord.getPage().getPageSize());
                currPage += 1;
            }
        } else if ("goToNextPage".equals(((Button) event.getSource()).getId())) {
            if (Integer.valueOf(showPages[0].trim()) < Integer.valueOf(showPages[1].trim())) {
                englishWord.getPage().setStart(currPage * englishWord.getPage().getPageSize());
                currPage += 1;
            } else {
                currPage -= 1;
                englishWord.getPage().setStart(currPage * englishWord.getPage().getPageSize());
                currPage += 1;
            }
        }
        List<EnglishWord> words = null;
        String hintPageButtonText = "1/1";
        if (StringUtils.isBlank(articleTitle.getText())) {
            words = wordService.pageByLike(englishWord);
        } else {
            if (wordRadioButton.isSelected()) {
                englishWord.setWord(articleTitle.getText());
            } else {
                englishWord.setArticleId(IdGen.uuid(articleTitle.getText()));
            }
            words = wordService.pageByLike(englishWord);
        }
        Integer count = wordService.pageByLikeAccount(englishWord);
        if (count != 0) {
            Integer countPage = count / englishWord.getPage().getPageSize();
            if ((count % englishWord.getPage().getPageSize()) != 0) {
                countPage += 1;
            }
            hintPageButtonText = currPage + "/" + countPage;
        }
        hintPageButton.setText(hintPageButtonText);
        centerVBox.getChildren().clear();
        centerVBox.getChildren().add(createTableView(words));
    }

    @FXML
    public void wordPricticeButtonAction(ActionEvent event) {

        EnglishWord englishWord = new EnglishWord();
        if (articleRadioButton.isSelected()) {
            englishWord.setArticleId(IdGen.uuid(articleTitle.getText()));
        }
        List<EnglishWord> words = wordService.listByLike(englishWord);
        if (!ObjectUtils.isEmpty(words)) {
            for (EnglishWord w : words) {
                if (!ObjectUtils.isEmpty(w.getEnglishWordPrictice())) {
                    w.getEnglishWordPrictice().setDifficultyLevel(WordDiffType.getWordDiff(w.getEnglishWordPrictice().getDifficultyLevel()));
                }
            }
        }
        if ("matchWordButton".equals(((Button) event.getSource()).getId())) {
            AnchorPane anchorPane = new AnchorPane();
            HBox hBox = new HBox();
            hBox.setLayoutX(30.0);
            hBox.setLayoutY(35.0);
            hBox.setSpacing(25.0);
            ToggleGroup group = new ToggleGroup();
            RadioButton normal = new RadioButton("all");
            normal.setToggleGroup(group);
            normal.setSelected(true);
            RadioButton medium = new RadioButton("medium");
            medium.setToggleGroup(group);
            RadioButton hard = new RadioButton("hard");
            hard.setToggleGroup(group);
            hBox.getChildren().add(normal);
            hBox.getChildren().add(medium);
            hBox.getChildren().add(hard);
            anchorPane.getChildren().add(hBox);
            DialogUtils.operationDialog("difficult level", anchorPane);
            Integer errorTime = WordDiffType.normal.errorTime();
            if (medium.isSelected()) {
                errorTime = WordDiffType.medium.errorTime();
            } else if (hard.isSelected()) {
                errorTime = WordDiffType.hard.errorTime();
            }
            if (WordDiffType.normal.errorTime().equals(errorTime)) {
                matchWordView.setEnglishWords(words);
            } else {
                List<EnglishWord> targetWords = new ArrayList<>();
                for (EnglishWord ew : words) {
                    if (ObjectUtils.isEmpty(ew.getEnglishWordPrictice()) || ew.getEnglishWordPrictice().getErrorTime() < errorTime) {
                        continue;
                    }
                    targetWords.add(ew);
                }
                matchWordView.setEnglishWords(targetWords);
            }
            if (!matchWordView.getOpened()) {
                StudyApplication.showView(matchWordView, Modality.NONE, "match word");
            }
        } else if ("matchMeanButton".equals(((Button) event.getSource()).getId())) {

        } else if ("chooseWordButton".equals(((Button) event.getSource()).getId())) {

        } else if ("chooseMeanButton".equals(((Button) event.getSource()).getId())) {

        }
    }
}
