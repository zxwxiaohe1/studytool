package com.study.en.support.ennum;

import com.study.en.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author heyong
 * @date 2019/4/26
 */
@Slf4j
public enum WordType {
    /**
     * 名词
     */
    n() {
        @Override
        public String type() {
            return "名词";
        }
    },
    /**
     * 动词
     */
    v() {
        @Override
        public String type() {
            return "动词";
        }
    },
    /**
     * 形容词
     */
    adj() {
        @Override
        public String type() {
            return "形容词";
        }
    },
    /**
     * 副词
     */
    adv() {
        @Override
        public String type() {
            return "副词";
        }
    },
    /**
     * 不及物动词
     */
    vi() {
        @Override
        public String type() {
            return "不及物动词";
        }
    },
    /**
     * 数量词
     */
    num() {
        @Override
        public String type() {
            return "数量词";
        }
    },
    /**
     * 连词
     */
    conj() {
        @Override
        public String type() {
            return "连词";
        }
    },
    /**
     * 及物动词
     */
    vt() {
        @Override
        public String type() {
            return "及物动词";
        }
    },
    /**
     * 介词
     */
    prep() {
        @Override
        public String type() {
            return "介词";
        }
    },
    aux() {
        @Override
        public String type() {
            return "助动词";
        }
    };

    /**
     * @return String
     * @Title: driver Type
     * @Description: 获得驱动
     */
    public abstract String type();

    /**
     * @return String
     * @Title: getDriverType
     * @Description: 获得驱动
     */
    public static String type(String type) {
        if (type == null) {
            return "";
        }
        type = type.toLowerCase();
        for (WordType v : values()) {
            if (type.trim().equals(v.name().trim())) {
                return v.type();
            }
        }
        return "";
    }

    public static List<WordType> getChildByLengthDesc() {
        LinkedList<WordType> wts = new LinkedList<WordType>();
        for (WordType wt : values()) {
            linkedListOrder(wts, wt, null);
        }
        log.info("word type ==>" + JacksonUtil.bean2Json(wts));
        return wts;
    }

    private static void linkedListOrder(LinkedList<WordType> wts, WordType wt, Integer index) {
        if (ObjectUtils.isEmpty(wts)) {
            wts.add(wt);
            return;
        }
        if (index == null) {
            if (wt.name().length() < wts.getLast().name().length()) {
                wts.addLast(wt);
                return;
            } else {
                linkedListOrder(wts, wt, wts.size() - 2);
            }
        } else if (index == -1) {
            wts.addFirst(wt);
            return;
        } else {
            if (wt.name().length() < wts.get(index).name().length()) {
                wts.add(index + 1, wt);
                return;
            } else {
                linkedListOrder(wts, wt, index - 1);
            }
        }
    }
}
