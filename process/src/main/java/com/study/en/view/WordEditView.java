package com.study.en.view;

import com.study.en.domain.entity.EnglishWord;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaohe
 * @description:
 * @date 2020/3/9 10:54
 */
@Setter
@Getter
@FXMLView(value = "/fxml/wordEdit.fxml", encoding = "utf-8")
public class WordEditView extends AbstractFxmlView {

    private Boolean opened = false;
    private EnglishWord englishWord;
}
