package com.study.en.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
/**
 * @author xiaohe
 * @description:
 * @date 2020/3/9 14:59
 */
public class CopyUtil {

    public static <T> T copy(Object source, Class<T> c) {
        if (source == null) {
            return null;
        }
        try {
            T instance = c.newInstance();
            BeanUtils.copyProperties(source, instance);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <E, T> List<T> copyList(List<E> sources, Class<T> c) {
        if (CollectionUtils.isEmpty(sources)) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        for (E source : sources) {
            list.add(copy(source, c));
        }
        return list;
    }

}
