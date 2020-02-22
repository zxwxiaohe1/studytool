package com.study.en.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 实体类对应的数据表为：english_article
 *
 * @author xiaohe
 * @date Tue Feb 18 14:20:30 CST 2020
 */

@Getter
@Setter
@TableName("english_article")
public class EnglishArticle {
    /**
     *
     */
    @TableId(value = "id",type = IdType.INPUT)
    private String id;

    /**
     *
     */
    @TableField("title")
    private String title;

    /**
     *
     */
    @TableField("remark")
    private String remark;

    /**
     *
     */
    @TableField("type_id")
    private String typeId;

    /**
     *
     */
    @TableField("level")
    private String level;

    /**
     *
     */
    @TableField("content")
    private String content;

    /**
     *
     */
    @TableField("mean")
    private String mean;

    /**
     *
     */
    @TableField("create_date")
    private Date createDate;
}