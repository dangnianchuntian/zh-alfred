/*
 * Copyright (c) 2023. zhanghan_java@163.com All Rights Reserved.
 * 项目名称：Alfred的Java插件
 * 类名称：StringUtil.java
 * 创建人：张晗
 * 联系方式：zhanghan_java@163.com
 * 开源地址: https://github.com/dangnianchuntian/springboot
 * 博客地址: https://zhanghan.blog.csdn.net
 */

package com.zhanghan.alfred.util;

/**
 * 字符串工具类
 *
 * @author zhanghan
 * @create 2023-02-12-14:16
 */
public class StringUtil {
    /**
     * 字符串反转
     *
     * @param str 待反转字符串
     * @return
     */
    public static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    /**
     * 计算字符串的长度
     * @param str 待计算的字符串
     * @return
     */
    public static String countStr(String str) {
        return String.valueOf(str.length());
    }
}
