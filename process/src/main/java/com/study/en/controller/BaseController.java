package com.study.en.controller;

import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.ArticleService;
import com.study.en.modules.vo.Mean;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.JacksonUtil;
import com.study.en.view.ArticleContentView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author heyong
 * @date 2020/2/23
 */
public abstract class BaseController {

    @Autowired
    private ArticleService articleService;

    public List<EnglishWord> formatWordsToView(List<EnglishWord> englishWords) {

        if (ObjectUtils.isEmpty(englishWords)) {
            return null;
        }
        List<EnglishArticle> articles = articleService.list();
        Map<String, String> articleMaps = null;
        if (!ObjectUtils.isEmpty(articles)) {
            articleMaps = articles.stream().collect(Collectors.toMap(EnglishArticle::getId, EnglishArticle::getTitle));
        }
        for (EnglishWord englishWord : englishWords) {
            String mean = "";
            if (StringUtils.isNotBlank(englishWord.getMean())) {
                List<Mean> means = JacksonUtil.json2JavaType(englishWord.getMean(), List.class, Mean.class);
                for (Mean m : means) {
                    mean += m.getWordType() + "." + m.getMean() + ";";
                }
            }
            englishWord.setMean(mean);
            if (!ObjectUtils.isEmpty(articleMaps)) {
                if (StringUtils.isNotBlank(englishWord.getArticleId())) {
                    String arts = "";
                    if (englishWord.getArticleId().contains(ConstantUtil.FILE_POINT_ENGLISH)) {
                        String[] as = englishWord.getArticleId().split(ConstantUtil.FILE_POINT_ENGLISH);
                        for (String a : as) {
                            if (StringUtils.isNotBlank(articleMaps.get(a))) {
                                arts += articleMaps.get(a)+";";
                            }
                        }
                        englishWord.setArticleId(arts);
                    } else {
                        englishWord.setArticleId(articleMaps.get(englishWord.getArticleId()));
                    }
                }
            }
        }
        return englishWords;
    }
}
