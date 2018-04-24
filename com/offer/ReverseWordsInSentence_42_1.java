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
    /**
     * 翻转句子，解法1
     * 解题思路：先将整个句子翻转，然后再逐个将翻转后句子中的每个单词翻转
     *
     * @param str 需要翻转的句子
     * @return 返回翻转完毕的句子
     */
    public String ReverseSentence2(String str)
    {
        if (str == null)
            return null;
        if (str.trim().equals(""))
            return str;

        char[] chars = str.toCharArray();
        int begin = 0;
        int end = chars.length - 1;

        //翻转整个句子
        reverse(chars, begin, end);

        //翻转每个单词
        begin = end = 0;
        while (begin != chars.length - 1)
        {
            //空格不用翻转
            if (chars[begin] == ' ')
            {
                ++begin;
                ++end;
            }
            else if (chars[end] == ' ')
            {
                reverse(chars, begin, --end);
                begin = ++end;
            }
            /**
             * 注意此处与书上不一样，因为C++中字符串默认是以'\0'结尾的，
             * 而Java中不是。
             */
            else if (end == chars.length - 1)
            {
                reverse(chars, begin, end);
                begin = end;
            }
            else
                ++end;
        }

        return new String(chars);
    }

    /**
     * 将chars数组从begin 到end 翻转，
     * @param chars 需要翻转的字符数组
     * @param begin 翻转的起始位置
     * @param end 翻转的终止位置
     */
    public static void reverse(char[] chars, int begin, int end)
    {
        if (begin > end || begin < 0 || end >= chars.length)
            return;

        while (begin < end)
        {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            ++begin;
            --end;
        }
    }


    /**
     * 解法2
     * @param str 需要翻转的句子
     * @return 返回翻转完毕的句子
     */
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
