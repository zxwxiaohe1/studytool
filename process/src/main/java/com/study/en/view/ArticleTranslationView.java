package com.study.en.view;

import com.study.en.domain.entity.EnglishArticle;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyong
 * @date 2020/2/22
 */
@Setter
@Getter
@FXMLView(title = "article content", value = "/fxml/articleTranslation.fxml", encoding = "utf-8")
public class ArticleTranslationView extends AbstractFxmlView {

    private Boolean frameFirstOpen;
    private EnglishArticle englishArticle;

}
