package com.offer;


/**
 * 剑指offer 面试题42_2
 * 题目描述: 字符串的左旋操作是把子字符串前面的若干个字符转移到字符尾部。请定义一个函数实现字符串左旋操作的功能。
 *
 */
public class LeftRotateString_42_2
{
    /**
     *解题思路：先把字符串分为两部分，第一部分为前n个字符，后一部分为后面所有字符。
     * 然后先将这两部分翻转，然后再将整个字符串翻转即为所求结果
     *@param str 需要进行左旋操作的字符串
     * @param n 左旋位数
     * @return 返回左旋完成的字符串
     */
    public String LeftRotateString2(String str,int n)
    {
        if(str == null)
            return null;
        if (str.trim().equals("") || n == 0)
            return str;
        char[] chars = str.toCharArray();

        int firstBegin = 0;
        int firstEnd = n -1;
        int secondBegin = n;
        int secondEnd = chars.length - 1;

        reverse(chars, firstBegin, firstEnd);
        reverse(chars, secondBegin, secondEnd);
        reverse(chars, 0, chars.length - 1);

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
     * 解题思路：用str构造两个StringBuilder，在第一个stringBuilder1对象中删除0-n-1个字符，在第二个stringBuilder2
     *  * 中删除n-str.length()-1个字符，然后stringBuilder1.append(stringBuilder2), 再将stringBuilder1转化为字符串即可
     * @param str 需要进行左旋操作的字符串
     * @param n 左旋位数
     * @return 返回左旋完成的字符串
     */
    public String LeftRotateString(String str,int n)
    {
        if(str == null)
            return null;
        if (str.trim().equals("") || n == 0)
            return str;

        StringBuilder stringBuilder1 = new StringBuilder(str);
        StringBuilder stringBuilder2 = new StringBuilder(str);

        return (stringBuilder1.delete(0, n).append(stringBuilder2.delete(n, str.length()))).toString();
    }
}
