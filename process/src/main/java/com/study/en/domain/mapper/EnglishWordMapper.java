package com.study.en.domain.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.en.domain.entity.EnglishWord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author heyong
 * @date 2020/02/21
 */
@Mapper
public interface EnglishWordMapper extends BaseMapper<EnglishWord> {
}
