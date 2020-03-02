package com.study.en.support.ennum;

/**
 * @author heyong
 * @date 2020/3/2
 */
public enum WordDiffType {

    normal {
        @Override
        public String sign() {
            return "0";
        }

        @Override
        public Integer errorTime() {
            return 0;
        }
    },
    medium {
        @Override
        public String sign() {
            return "1";
        }

        @Override
        public Integer errorTime() {
            return 5;
        }
    },
    hard {
        @Override
        public String sign() {
            return "2";
        }

        @Override
        public Integer errorTime() {
            return 10;
        }
    };

    public abstract String sign();
    public abstract Integer errorTime();

    /**
     * @return String
     * @Title: getDriverType
     * @Description: 获得单词难度值
     */
    public static String getWordDiff(String sign) {
        if (sign == null) {
            return normal.name();
        }
        sign = sign.toLowerCase();
        for (WordDiffType v : values()) {
            if (sign.trim().equals(v.sign().trim())) {
                return v.name();
            }
        }
        return normal.name();
    }
}
