/*
 * Copyright (c) 2023. zhanghan_java@163.com All Rights Reserved.
 * 项目名称：Alfred的Java插件
 * 类名称：ToolTypeEnum.java
 * 创建人：张晗
 * 联系方式：zhanghan_java@163.com
 * 开源地址: https://github.com/dangnianchuntian/springboot
 * 博客地址: https://zhanghan.blog.csdn.net
 */

package com.zhanghan.alfred.enums;

/**
 * 工具类型:用于确认是哪种类型的转换
 *
 * @author zhanghan
 * @create 2023-02-12-14:16
 */
public enum ToolTypeEnum {
    /**
     * ip转换
     */
    IP_CONVERT("ip_convert"),
    /**
     * 字符串计数
     */
    STR_COUNT("str_count"),
    /**
     * 字符串反转
     */
    STR_REVERSE("str_reverse");

    private String value;

    ToolTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
