package com.offer;

/**
 * 剑指offer 面试题42_1
 * 题目描述：输入一个英文句子，翻转句子中单词的顺序，但单词内的顺序不变，标点符号和普通字符一样处理。
 *
 * 解题思路：利用空格将句子分为字符串数组，然后从数组尾部开始遍历，将每个单词重新拼接为一句话。
 * 需要注意的是对于空字符串的判断str.trim().equals("")
 */
public class ReverseWordsInSentence_42_1
{
    public String ReverseSentence(String str)
    {
        if (str == null)
            return null;
        if (str.trim().equals(""))
            return str;

        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; --i)
        {
            if (i != 0)
                stringBuilder.append(strings[i] + " ");
            else
                stringBuilder.append(strings[i]);
        }

        return stringBuilder.toString();
    }
}
