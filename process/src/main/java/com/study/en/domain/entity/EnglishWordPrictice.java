package com.study.en.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author heyong
 * @date 2020/2/22
 */
@Getter
@Setter
@TableName("english_word_prictice")
public class EnglishWordPrictice extends BaseEntity<EnglishWordPrictice> {

    /**
     *
     */
    @TableId(value = "word_id", type = IdType.INPUT)
    private String wordId;
    /**
     *
     */
    @TableField("error_time")
    private Integer errorTime;
    /**
     *
     */
    @TableField("difficulty_level")
    private String difficultyLevel;

}
