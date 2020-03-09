package com.study.en.support.table;

import com.study.en.StudyApplication;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.WordPricticeService;
import com.study.en.domain.service.WordService;
import com.study.en.support.holder.SpringContextHolder;
import com.study.en.utils.DialogUtils;
import com.study.en.utils.IdGen;
import com.study.en.view.MatchWordView;
import com.study.en.view.WordEditView;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heyong
 * @date 2020/2/23
 */
@Slf4j
public class AddWordCell extends TableCell<EnglishWord, Boolean> {


    public TableView table;
    public Button addButton;
    public Button editButton;
    private final DoubleProperty buttonY = new SimpleDoubleProperty();

    private WordService wordService;

    /**
     * AddPersonCell constructor
     *
     * @param table the table to which a new person can be added.
     */
    public AddWordCell(final TableView table, final Button addButton, final Button editButton) {
        this.table = table;
        this.addButton = addButton;
        this.editButton = editButton;
        this.addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                wordService = SpringContextHolder.getBean("wordService");
                Map<String, Object> columnMap = new HashMap<>();
                String word = ((EnglishWord) table.getItems().get(getTableRow().getIndex())).getWord();
                columnMap.put("word", word);
                wordService.removeByMap(columnMap);
                log.info("==>删除单词 " + word);
                DialogUtils.hintDialog("hint", "delete success !");
            }
        });
        this.editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word = ((EnglishWord) table.getItems().get(getTableRow().getIndex())).getWord();
                log.info("==>编辑单词 " + word);
                WordService wordService = SpringContextHolder.getBean(WordService.class);
                WordEditView wordEditView = SpringContextHolder.getBean(WordEditView.class);
                if (ObjectUtils.isEmpty(wordService) || ObjectUtils.isEmpty(wordEditView)) {
                    return;
                }
                wordEditView.setEnglishWord(wordService.selectById(IdGen.uuid(word)));
                StudyApplication.showView(wordEditView, Modality.NONE, "edit word");
            }
        });
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            HBox hbox = new HBox();
            hbox.getChildren().add(this.addButton);
            hbox.getChildren().add(this.editButton);
            this.setGraphic(hbox);
        } else {
            setGraphic(null);
        }
    }

}

