/*
 * Copyright (c) 2023. zhanghan_java@163.com All Rights Reserved.
 * 项目名称：Alfred的Java插件
 * 类名称：ZhAlfred.java
 * 创建人：张晗
 * 联系方式：zhanghan_java@163.com
 * 开源地址: https://github.com/dangnianchuntian/springboot
 * 博客地址: https://zhanghan.blog.csdn.net
 */

package com.zhanghan.alfred;

import com.zhanghan.alfred.enums.ToolTypeEnum;
import com.zhanghan.alfred.util.IpConvertUtil;
import com.zhanghan.alfred.util.StringUtil;

/**
 * Alfred入口工具类
 *
 * @author zhanghan
 * @create 2023-02-12-14:16
 */
public class ZhAlfred {

    //alfred 返回值识别的格式
    //{
    //    "items":[
    //    {
    //        "arg":"占位符",
    //            "valid":true,
    //            "subtitle":"Press enter to copy",
    //            "icon":{
    //        "path":"/System/Library/CoreServices/CoreTypes.bundle/Contents/Resources/BookmarkIcon.icns"
    //    },
    //        "title":"占位符"
    //    }
    //  ]
    //}
    private static String resultTemplate = "{\"items\":[{\"valid\":true,\"arg\":\"replace_arg\",\"subtitle\":\"Press enter to copy\",\"icon\":\"{\\n\\\"path\\\": \\\"/System/Library/CoreServices/CoreTypes.bundle/Contents/Resources/BookmarkIcon.icns\\\"\\n}\",\"title\":\"replace_arg\"}]}\n";
    //模版中的占位符,用于结果的替换
    private final static String placeholder = "replace_arg";

    /**
     * Alfred工具入口
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            //1.获取转换类型
            String type = args[0];
            //2.获取待转换的值
            String str = args[1].trim();
            //3.IP转换
            if (ToolTypeEnum.IP_CONVERT.getValue().equals(type)) {
                printFormatResult(IpConvertUtil.ipConvert(str));
                return;
            }
            //4.字符串长度计算
            if (ToolTypeEnum.STR_COUNT.getValue().equals(type)) {
                printFormatResult(StringUtil.countStr(str));
                return;
            }
            //5.字符串反转
            if (ToolTypeEnum.STR_REVERSE.getValue().equals(type)) {
                printFormatResult(StringUtil.reverseStr(str));
                return;
            }
            //6.不识别的类型
            printFormatResult("不支持的类型");
        } catch (Exception e) {
            printFormatResult("异常请重新输入");
        }
    }

    /**
     * 输出结果按照alfred的可识别格式输出
     *
     * @param result 待格式化的结果
     * @return
     */
    public static void printFormatResult(String result) {
        String formatResult = resultTemplate.replaceAll(placeholder, result);
        System.out.println(formatResult);
    }
}
