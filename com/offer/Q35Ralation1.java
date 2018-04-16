package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer 面试题35相关题目1
 * 题目描述：定义一个函数，输入两个字符串，从第一个字符串中删除在第二个字符串中出现过的所有字符。
 *
 *  @author chuan
 */
public class Q35Ralation1
{
    public static void main(String[] args)
    {
        Q35Ralation1 ralation1 = new Q35Ralation1();

        String str1 = "we are students";
        String str2 = "aeiou";

        ralation1.solution(str1, str2);
    }

    /**
     * 解答题思路：将第二个字符串中的每个字符都存入map中，然后从头至尾扫描一遍第一个字符串。
     * 如果该字符出现在map中，则不打印，否则打印。时间复杂度为O（n）
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     */
    public void solution(String str1, String str2)
    {
        Map<Character, Character> map = new HashMap<>();
        for (int i= 0; i < str2.length(); ++i)
        {
            map.put(str2.charAt(i), str2.charAt(i));
        }

        for (int i = 0; i < str1.length(); ++i)
        {
            if (!map.containsKey(str1.charAt(i)))
            {
                System.out.print(str1.charAt(i));
            }
        }
        System.out.println();
    }
}
