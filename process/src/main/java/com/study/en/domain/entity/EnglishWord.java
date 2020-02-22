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
@TableName("english_word")
public class EnglishWord {
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
}
