package com.study.en.support.table;

import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.WordService;
import com.study.en.support.holder.SpringContextHolder;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heyong
 * @date 2020/2/23
 */
@Slf4j
public class AddWordCell extends TableCell<EnglishWord, Boolean> {


    public  TableView table;
    public Button addButton;
    private final DoubleProperty buttonY = new SimpleDoubleProperty();

    private WordService wordService;

    /**
     * AddPersonCell constructor
     *
     * @param table the table to which a new person can be added.
     */
    public AddWordCell(final TableView table, final Button addButton) {
        this.table = table;
        this.addButton =addButton;
        addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonY.set(mouseEvent.getScreenY());
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                wordService = SpringContextHolder.getBean("wordService");
                Map<String, Object> columnMap = new HashMap<>();
                String word = ((EnglishWord) table.getItems().get(getTableRow().getIndex())).getWord();
                columnMap.put("word",word);
                wordService.removeByMap(columnMap);
                log.info("==>删除单词 "+word);
            }
        });
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            this.setGraphic(this.addButton);
        } else {
            setGraphic(null);
        }
    }

}

