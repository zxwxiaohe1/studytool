/**
 * Copyright &copy; 2015-2020 <a href="http://www.sinux.com.cn/">JFusion</a> All rights reserved.
 */
package com.study.en.utils;


import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 *
 * @author sinux
 * @version 2020-01-15
 */
public class IdGen {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     *
     * @return String对象
     * @throws
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     *
     * @return String对象
     * @throws
     */
    public static String uuid(String target) {
        return UUID.nameUUIDFromBytes(target.replaceAll(" +", "").toLowerCase().getBytes()).toString();
    }


    public static void main(String[] args) {
        System.out.println(IdGen.uuid());
        System.out.println(IdGen.uuid("qwe  rtt u i"));
        System.out.println(IdGen.uuid(" q w e  r t  t u   i "));
        System.out.println(IdGen.uuid("qwe  rtt u iqwe  rtt u iqwe  rtt u iqwe  rtt u iqwe  rtt u iqwe  rtt u iqwe  rtt u i"));
    }

}
