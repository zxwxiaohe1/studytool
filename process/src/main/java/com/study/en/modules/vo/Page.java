package com.study.en.modules.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author heyong
 * @date 2020/2/23
 */
@Setter
@Getter
public class Page<T> {

    private Integer start = 0;
    private Integer pageSize = 9;
    private Integer count = 0;

}
