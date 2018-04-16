package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer面试题35 相关题目2
 * 题目描述：定义一个函数，删除字符串中所有重复出现的字符。例如“google”，删除之后为“gole”
 *
 * @author chuan
 */
public class Q35Relation2
{
    public static void main(String[] args)
    {
        Q35Relation2 relation2 = new Q35Relation2();
        String str = "google";
        relation2.solution(str);

    }


    /**
     * 解题思路：使用hashmap，遍历该字符串的每个字符，如果map不包含该字符，则将其加入map，并将其打印出来；
     * 否则continue。
     * @param str 需要处理得字符串
     */
    public void solution(String str)
    {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i)
        {
            if (map.containsKey(str.charAt(i)))
            {
                continue;
            }
            map.put(str.charAt(i), str.charAt(i));
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

}
