package com.study.en.controller;

import com.study.en.modules.service.WordFormat;
import com.study.en.modules.vo.SingleWord;
import com.study.en.support.ennum.WordExportType;
import com.study.en.support.export.ExportWord;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.DialogUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class EnglishFormatController implements Initializable {

    @FXML
    public Pane englishFormatPane;
    @FXML
    private HBox selectTextFile;
    @FXML
    private TextField textName;
    @FXML
    private TextField docName;
    @FXML
    private Label selectFileDialog;
    @FXML
    public Label wordTemplate;
    @FXML
    public Label sentenceTemplate;
    @FXML
    public Label phraseTemplate;
    @FXML
    private ToggleGroup enTypeGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordTemplate.setText(ConstantUtil.TEMPLATE_WORD);
        sentenceTemplate.setText(ConstantUtil.TEMPLATE_SENTENCE);
        phraseTemplate.setText(ConstantUtil.TEMPLATE_PHRASE);
    }

    @FXML
    private void handleLoadClicked(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        Window stage = selectTextFile.getScene().getWindow();
        fileChooser.setTitle("Load Dialog");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                File loadFile = file.getParentFile();
                fileChooser.setInitialDirectory(loadFile);
                textName.setText(file.getAbsolutePath());
                docName.setText(file.getName().split("\\" + ConstantUtil.FILE_PERIOD_ENGLISH)[0] + ConstantUtil.FILE_EXPORT_SUFFIX);
            }
            selectFileDialog.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void convertCommit(ActionEvent event) {
        if (StringUtils.isBlank(textName.getText())) {
            selectFileDialog.setTextFill(Paint.valueOf("red"));
            selectFileDialog.setText("please select file first ! ");
            return;
        }
        String selected = ((RadioButton) this.enTypeGroup.getSelectedToggle()).getText();
        WordFormat wordFormat = new WordFormat();
        ExportWord exportWord = new ExportWord();
        if (WordExportType.word.name().equals(selected)) {
            Map<String, SingleWord> appleMap = wordFormat.singleWordFormat(textName.getText()).stream().collect(Collectors.toMap(SingleWord::getWord, a -> a, (k1, k2) -> k1));
            List<String> sortw = new ArrayList<>(appleMap.keySet());
            Collections.sort(sortw);
            List<SingleWord> words = new ArrayList<>();
            for (String w : sortw) {
                words.add(appleMap.get(w));
            }
            exportWord.exec(words, WordExportType.word.name(), docName.getText().trim());
        } else if (WordExportType.sentence.name().equals(selected)) {
            List<SingleWord> words = wordFormat.sentenceFormat(textName.getText());
            exportWord.exec(words, WordExportType.sentence.name(), docName.getText().trim());
        } else {
            List<SingleWord> words = wordFormat.phraseFormat(textName.getText());
            exportWord.exec(words, WordExportType.phrase.name(),docName.getText().trim());
        }
        DialogUtils.hintDialog((Stage) englishFormatPane.getScene().getWindow(), "hint", "Format Success!");
    }

}
