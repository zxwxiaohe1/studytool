package com.study.en.view;

import com.study.en.domain.entity.EnglishWord;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * @author heyong
 */
@Setter
@Getter
@FXMLView(value = "/fxml/matchWord.fxml", encoding = "utf-8")
public class MatchWordView extends AbstractFxmlView {

    private List<EnglishWord> englishWords;
}
