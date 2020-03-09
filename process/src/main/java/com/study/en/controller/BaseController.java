package com.study.en.controller;

import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.domain.service.ArticleService;
import com.study.en.modules.vo.Mean;
import com.study.en.support.ennum.WordType;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.CopyUtil;
import com.study.en.utils.JacksonUtil;
import com.study.en.utils.StringUtil;
import com.study.en.view.ArticleContentView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
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

    public List<EnglishWord> formatWordsToView(List<EnglishWord> origin) {

        List<EnglishWord> englishWords = CopyUtil.copyList(origin, EnglishWord.class);
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
                                arts += articleMaps.get(a) + ";";
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

    public EnglishWord formatWordsToView(EnglishWord origin) {
        EnglishWord englishWord = CopyUtil.copy(origin, EnglishWord.class);
        if (ObjectUtils.isEmpty(englishWord)) {
            return null;
        }
        List<EnglishArticle> articles = articleService.list();
        Map<String, String> articleMaps = null;
        if (!ObjectUtils.isEmpty(articles)) {
            articleMaps = articles.stream().collect(Collectors.toMap(EnglishArticle::getId, EnglishArticle::getTitle));
        }
        if (ObjectUtils.isEmpty(englishWord.getMean())) {
            String mean = "";
            if (StringUtils.isNotBlank(englishWord.getMean())) {
                List<Mean> means = JacksonUtil.json2JavaType(englishWord.getMean(), List.class, Mean.class);
                for (Mean m : means) {
                    mean += m.getWordType() + "." + m.getMean() + ";";
                }
            }
            englishWord.setMean(mean);
        }
        if (!ObjectUtils.isEmpty(articleMaps)) {
            if (StringUtils.isNotBlank(englishWord.getArticleId())) {
                String arts = "";
                if (englishWord.getArticleId().contains(ConstantUtil.FILE_POINT_ENGLISH)) {
                    String[] as = englishWord.getArticleId().split(ConstantUtil.FILE_POINT_ENGLISH);
                    for (String a : as) {
                        if (StringUtils.isNotBlank(articleMaps.get(a))) {
                            arts += articleMaps.get(a) + ";";
                        }
                    }
                    englishWord.setArticleId(arts);
                } else {
                    englishWord.setArticleId(articleMaps.get(englishWord.getArticleId()));
                }
            }
        }
        return englishWord;
    }

    public String createViewMean(List<Mean> means) {
        if (ObjectUtils.isEmpty(means)) {
            return "";
        }
        String meanStr = "";
        for (Mean m : means) {
            meanStr += m.getWordType() + ConstantUtil.FILE_PERIOD_ENGLISH + m.getMean() + "\n";
        }
        return meanStr;
    }

    public List<Mean> formatMeanToObj(String originMean) {
        if (StringUtil.isBlank(originMean)) {
            return null;
        }
        String temp = "";
        StringBuilder target = new StringBuilder(originMean.replaceAll(" +", ""));
        for (WordType w : WordType.getChildByLengthDesc()) {
            temp = target.toString();
            if (temp.contains(w.name() + ConstantUtil.FILE_PERIOD_ENGLISH)) {
                temp = temp.replaceAll(w.name() + ConstantUtil.FILE_PERIOD_ENGLISH, w.name() + ConstantUtil.SYMBOL_JOINT_MARK);
                target = new StringBuilder(temp);
                target.insert(target.toString().indexOf(w.name() + ConstantUtil.SYMBOL_JOINT_MARK), ConstantUtil.SPLIT_WORD_MEAN_CHAR);
            }
        }
        String[] meanStrs = target.toString().split(ConstantUtil.SPLIT_WORD_MEAN_CHAR);
        String[] meanSplitStrs;
        List<Mean> wordMeans = new ArrayList<>();
        for (String meanStr : meanStrs) {
            if (StringUtils.isNotBlank(meanStr)) {
                Mean mean = new Mean();
                meanSplitStrs = meanStr.trim().split("\\" + ConstantUtil.SYMBOL_JOINT_MARK);
                if (meanSplitStrs.length >= 2) {
                    mean.setWordType(meanSplitStrs[0]);
                    mean.setMean(meanSplitStrs[1]);
                    wordMeans.add(mean);
                }
            }
        }
        return wordMeans;
    }
}
