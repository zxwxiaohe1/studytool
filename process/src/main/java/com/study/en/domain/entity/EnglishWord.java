package com.study.en.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.study.en.modules.vo.Mean;
import com.study.en.utils.JacksonUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author heyong
 * @date 2020/2/22
 */
@Getter
@Setter
@TableName("english_word")
public class EnglishWord extends BaseEntity<EnglishWord> {
    /**
     *
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     *
     */
    @TableField("word")
    private String word;
    /**
     *
     */
    @TableField("mean")
    private String mean;
    /**
     *
     */
    @TableField("article_id")
    private String articleId;
    /**
     *
     */
    @TableField("create_date")
    private Date createDate;

    /**
     *
     */
    @TableField("remark")
    private String remark;

    public EnglishWord() {
    }

    public EnglishWord(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }


}
