package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目说明：leetcode第三题，其字符串最长子串的长度
 * 解题思路：定义一个HashMap，将字符串的每一个字符作为键，字符的位置作为值，存储在该Map中。定义两个位置指针分，
 * 分别指向子串的起始(begin)和终止(end)位置。end从头到尾遍历字符串，当遇到重复字符的时候需要把起始位置重新设置
 * 为该重复字符上次出现的下一个位置
 */
public class MaxLenOfSubStr {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null || s.equals(""))
            return max;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0, begin = 0; end < s.length(); ++end) {
            if (map.containsKey(s.charAt(end))) {
                begin = Math.max(begin, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }
}
