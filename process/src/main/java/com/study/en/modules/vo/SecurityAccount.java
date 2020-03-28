package com.study.en.modules.vo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author heyong
 * @date 2020/3/28
 */
@Setter
@Getter
public class SecurityAccount {

    private String name ;
    private String phone;
    private String idcard;
    private String salt;
    private String passwd;
    private String proof;

    public SecurityAccount() {
    }
    public SecurityAccount(String name, String phone, String idcard, String salt) {
        this.name = name;
        this.phone = phone;
        this.idcard = idcard;
        this.salt = salt;
    }
}
