package com.study.en.modules.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heyong
 * @date 2019/4/26
 */
@Setter
@Getter
public class SingleWord {

    private String word = "";
    private String mean = "";
    private List<Mean> means = new ArrayList<Mean>();
}
