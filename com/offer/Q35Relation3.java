package com.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 剑指offer 面试题35相关题目3
 * 题目描述：在英语中，如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词。
 * 写一个函数，判断两个单词是否互为变位词。
 *
 * @author chuan
 */
public class Q35Relation3
{

    public static void main(String[] args)
    {
        Q35Relation3 relation3 = new Q35Relation3();
        String str1 = "evil";
        String str2 = "live";
        boolean result = relation3.solution(str1, str2);
        System.out.println(result);
    }


    /**
     * 解题思路：使用Hashmap，键为字符，值为该字符出现的次数。
     * 先遍历字符串1，字符没出现一次，对应值增1。
     * 再遍历字符串2，字符每出现一次，对应值减1。
     * 最后判断map中所有值是否都为0。如果都为0，则是变位词。否则不是变位词
     * @param str1 单词1
     * @param str2 单词2
     * @return 是否为变位词
     */
    public boolean solution(String str1, String str2) {
        //字符串长度不一致，则一定不是变位词
        if (str1.length() != str2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); ++i) {
            Character ch = str1.charAt(i);
            if (map.containsKey(ch)) {
                Integer times = map.get(ch);
                ++times;
                map.put(ch, times);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < str2.length(); ++i) {
            Character ch = str2.charAt(i);
            if (map.containsKey(ch)) {
                Integer times = map.get(ch);
                --times;
                map.put(ch, times);
            }
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Iterator<Map.Entry<Character, Integer>> iterator = set.iterator(); iterator.hasNext(); ) {
            Integer times = iterator.next().getValue();
            if (times != 0)
                return false;
        }
        return true;
    }
}
