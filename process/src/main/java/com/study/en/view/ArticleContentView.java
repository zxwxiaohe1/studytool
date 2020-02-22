package com.study.en.view;

import com.study.en.domain.entity.EnglishArticle;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyong
 * @date 2020/2/22
 */
@Setter
@Getter
@FXMLView(title = "article content", value = "/fxml/articleContent.fxml", encoding = "utf-8")
public class ArticleContentView extends AbstractFxmlView {

    private Boolean frameFirstOpen;
    private EnglishArticle englishArticle;

}
