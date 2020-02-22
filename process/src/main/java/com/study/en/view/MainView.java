package com.study.en.view;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Setter
@Getter
@FXMLView(value = "/fxml/main.fxml", encoding = "utf-8")
public class MainView extends AbstractFxmlView {

    private final String englishFormatId = "english-format-id";
    private final String wordNotebookId = "word-notebook-id";


}
