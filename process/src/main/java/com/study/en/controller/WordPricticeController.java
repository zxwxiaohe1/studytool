package com.study.en.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class WordPricticeController extends BaseController implements Initializable {

    @FXML
    public StackPane tableAnchorPane;
    @FXML
    public VBox centerVBox;
    @FXML
    private WordPricticeView wordPricticeView;
    @Autowired
    private WordService wordService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //获取前台发送过来的数据
        Integer pageNo = 1;
        Integer pageSize = 9;
        IPage<EnglishWord> page = new Page<>(pageNo, pageSize);
        QueryWrapper<EnglishWord> wrapper = new QueryWrapper<>();
        EnglishWord englishWord = new EnglishWord();
        englishWord.setArticleId("fbc831a3-0441-3fdc-adcb-d6584e64d3c0");
        englishWord.getPage().setStart(0);
        englishWord.getPage().setPageSize(9);
        List<EnglishWord> list = null;
        try {
            list = wordService.pageByArticleIdLike(englishWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!ObjectUtils.isEmpty(list)) {
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
                return new AddWordCell(tableView, new Button("del"),new Button("edit"));
            }
        });

        tableView.getColumns().add(tcWord);
        tableView.getColumns().add(tcMean);
        tableView.getColumns().add(tcArticle);
        tableView.getColumns().add(tcButton);


        ObservableList<EnglishWord> data = FXCollections.observableArrayList();
        if (!ObjectUtils.isEmpty(words))  {
            data.setAll(words);
        }
        tableView.setItems(data);
        return tableView;
    }

}
