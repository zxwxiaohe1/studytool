package com.study.en.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.en.domain.entity.EnglishWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heyong
 * @date 2020/02/21
 */
@Mapper
public interface EnglishWordMapper extends BaseMapper<EnglishWord> {

    /**
     * @param englishWord
     * @return
     */
    List<EnglishWord> pageByLike(EnglishWord englishWord);

    /**
     * @param englishWord
     * @return
     */
    Integer pageByLikeAccount(EnglishWord englishWord);
}
