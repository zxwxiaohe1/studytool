package com.study.en.view;

import com.study.en.domain.entity.EnglishWord;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * @author heyong
 */
@Setter
@Getter
@FXMLView(value = "/fxml/matchWord.fxml", encoding = "utf-8")
public class MatchWordView extends AbstractFxmlView {

    private List<EnglishWord> englishWords;

    private Boolean opened = false;
}
