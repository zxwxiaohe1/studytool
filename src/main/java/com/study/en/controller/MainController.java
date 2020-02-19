package com.study.en.controller;

import com.study.en.bean.Column;
import com.study.en.bean.DataItem;
import com.study.en.bean.Table;
import com.study.en.domain.service.ArticleService;
import com.study.en.utils.TreeUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.*;

/**
 *
 */
@Controller
public class MainController implements Initializable {

    @Autowired
    private ArticleService articleService;
    @FXML
    private TreeView<DataItem> treeViewDataSource;
    @FXML
    private TreeItem<String> treeItemDataSourceRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Table dataItem = new Table();
        Column english = new Column();
        english.setColumnName("English Format");
        Column noteBook = new Column();
        noteBook.setColumnName("NoteBook");
        List<Column> columns = new ArrayList<>();
        columns.add(english);
        columns.add(noteBook);
        dataItem.setColumns(columns);
//        treeItemDataSourceRoot.setValue("dsfs");
    }
}
