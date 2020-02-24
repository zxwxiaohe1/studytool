package com.study.en.controller;

import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.WordService;
import com.study.en.support.table.AddWordCell;
import com.study.en.utils.IdGen;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.net.URL;
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
    @Autowired
    private WordService wordService;

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
        tcWord.setResizable(false);
        tcWord.setMinWidth(150.0);
        tcWord.setMaxWidth(200.0);
        tcWord.setSortable(false);
        TableColumn<EnglishWord, String> tcMean = new TableColumn<>("Mean");
        tcMean.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getMean()));
        tcMean.setSortable(false);
        tcMean.setResizable(false);
        tcMean.setMinWidth(250.0);
        tcMean.setMaxWidth(250.0);

        TableColumn<EnglishWord, String> tcArticle = new TableColumn<>("Article");
        tcArticle.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getArticleId()));
        tcArticle.setSortable(false);
        tcArticle.setResizable(false);
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
            }else{
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
}
