/*
 * Copyright (c) 2023. zhanghan_java@163.com All Rights Reserved.
 * 项目名称：Alfred的Java插件
 * 类名称：IpConvertUtil.java
 * 创建人：张晗
 * 联系方式：zhanghan_java@163.com
 * 开源地址: https://github.com/dangnianchuntian/springboot
 * 博客地址: https://zhanghan.blog.csdn.net
 */

package com.zhanghan.alfred.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IP转换工具类
 *
 * @author zhanghan
 * @create 2023-02-12-14:16
 */
public class IpConvertUtil {

    /**
     * IP转换工具(030005055146 -> 30.5.55.146)
     *
     * @param str 待转换的IP
     * @return
     */
    public static String ipConvert(String str) {
        //1.字符串过滤非数字字符
        str = filterUnNumber(str);
        //2.将原始值进行切分
        List<String> strList = stringToList(str, 3);
        //3.切割后的字符串去除以0开头
        List<String> format = new ArrayList();
        strList.stream().forEach(x -> {
            format.add(x.replaceAll("^(0+)", ""));
        });
        //4.用.进行拼接
        String ip = "";
        for (String s : format) {
            ip = ip + s + ".";
        }
        ip = ip.substring(0, ip.length() - 2);
        return ip;
    }

    /**
     * 将字符串切成几份
     *
     * @param str    待切分的字符串
     * @param length 切成多少份
     * @return
     */
    public static List<String> stringToList(String str, int length) {
        List<String> list = new ArrayList<>();
        //将输入的字符串分割为几份
        int size = str.length() / length + 1;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                String substring = str.substring(i * length, str.length());
                list.add(substring);
            } else {
                String substring = str.substring(i * length, (i + 1) * length);
                list.add(substring);
            }
        }
        return list;
    }

    /**
     * 过滤数字以外的字符串
     *
     * @param str 待过滤的字符串
     * @return
     */
    public static String filterUnNumber(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
