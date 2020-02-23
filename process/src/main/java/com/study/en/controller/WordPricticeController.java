package com.study.en.controller;

import com.study.en.StudyApplication;
import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.ArticleService;
import com.study.en.domain.service.WordService;
import com.study.en.modules.vo.Mean;
import com.study.en.support.ennum.WordExportType;
import com.study.en.support.ennum.WordType;
import com.study.en.support.table.AddWordCell;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.utils.JacksonUtil;
import com.study.en.view.ArticleContentView;
import com.study.en.view.ArticleTranslationView;
import com.study.en.view.WordPricticeView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author heyong
 */
@FXMLController
public class WordPricticeController implements Initializable {

    @FXML
    public StackPane tableAnchorPane;
    @FXML
    public VBox centerVBox;
    @FXML
    private WordPricticeView wordPricticeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        centerVBox.getChildren().add(createTableView());
    }

    public TableView<EnglishWord> createTableView() {

        TableView<EnglishWord> tableView = new TableView<EnglishWord>();
        tableView.setEditable(true);

        TableColumn<EnglishWord, String> tcFirstName = new TableColumn<>("Word");
        tcFirstName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getWord()));

        tcFirstName.setSortable(false);
        TableColumn<EnglishWord, String> tcSecondName = new TableColumn<>("Mean");
        tcSecondName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getMean()));
        tcSecondName.setSortable(false);

        TableColumn<EnglishWord, String> tcAge = new TableColumn<>("Article");
        tcAge.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getArticleId()));
        tcAge.setSortable(false);


        TableColumn<EnglishWord, Boolean> tcButton = new TableColumn<>("操作");
        tcButton.setCellFactory(new Callback<TableColumn<EnglishWord, Boolean>, TableCell<EnglishWord, Boolean>>() {
            @Override
            public TableCell<EnglishWord, Boolean> call(TableColumn<EnglishWord, Boolean> personBooleanTableColumn) {
                return new AddWordCell(tableView, new Button("del"));
            }
        });

        tableView.getColumns().add(tcFirstName);
        tableView.getColumns().add(tcSecondName);
        tableView.getColumns().add(tcAge);
        tableView.getColumns().add(tcButton);


        ObservableList<EnglishWord> data = FXCollections.observableArrayList();
        EnglishWord p1 = new EnglishWord("xiaohe1", "L1");
        EnglishWord p2 = new EnglishWord("xiaohe2", "L2");
        EnglishWord p3 = new EnglishWord("xiaohe3", "L3");
        data.add(p1);
        data.add(p2);
        data.add(p3);
        tableView.setItems(data);
        return tableView;
    }
}
