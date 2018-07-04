package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 判断一个字符串中是否包含中文字符
 */
public class IncludeChinese
{
    public static void judgeChineseCharacor(String str)
    {
        String regEx = "[\u4e00-\u9fa5]";

        //判断是否存在中文字符
        if (str.getBytes().length == str.length())
        {
            System.out.println("无汉字");
        }
        else    //如果存在汉字，找出字符串中的汉字
        {
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            while (m.find())
            {
                System.out.print(m.group(0) + "");
            }
        }
    }

    public static void main(String[] args)
    {
        judgeChineseCharacor("Hello World");
        judgeChineseCharacor("Hello 你好");
    }
}
