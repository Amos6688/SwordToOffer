package com.offer;

/**
 * 剑指offer 面试题42_2
 * 题目描述: 字符串的左旋操作是把子字符串前面的若干个字符转移到字符尾部。请定义一个函数实现字符串左旋操作的功能。
 *
 * 解题思路：用str构造两个StringBuilder，在第一个stringBuilder1对象中删除0-n-1个字符，在第二个stringBuilder2
 * 中删除n-str.length()-1个字符，然后stringBuilder1.append(stringBuilder2), 再将stringBuilder1转化为字符串即可
 */
public class LeftRotateString_42_2
{
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
