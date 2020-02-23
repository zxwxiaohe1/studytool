package com.study.en.domain.entity;

import com.study.en.modules.vo.Page;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author heyong
 * @date 2020/2/23
 */
@Getter
@Setter
public abstract class BaseEntity<T> {
    /**
     * 当前实体分页对象
     */
    public Page<T> page = new Page<>();
}
