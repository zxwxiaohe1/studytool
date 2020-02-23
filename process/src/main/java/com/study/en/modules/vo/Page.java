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

    private Integer start;
    private Integer pageSize;
    private Integer count;

}
