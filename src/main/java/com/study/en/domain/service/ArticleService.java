package com.study.en.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.en.domain.entity.EnglishArticle;
import com.study.en.domain.mapper.EnglishArticleMapper;
import org.springframework.stereotype.Service;

/**
 * @author heyong
 * @date 2020/02/21
 */
@Service
public class ArticleService extends ServiceImpl<EnglishArticleMapper, EnglishArticle> {
}
