package com.study.en.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 新加属性必须添加@JsonIgnore
 * @author heyong
 * @date 2020/3/28
 */
@Getter
@Setter
@TableName("account_input")
public class AccountBackup {

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    @TableField("sys_name")
    private String sysName;
    @TableField("sys_url")
    private String sysUrl;
    @TableField("login_name")
    private String loginName;
    @TableField("password")
    private String password;
    @JsonIgnore
    @TableField("create_date")
    private Date createDate;
    @TableField("remarks")
    private String remarks;

}
