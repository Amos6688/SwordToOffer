package com.offer;

/**
 * 剑指offer 面试题53
 * 题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 解题思路：具体来说：
 * 当模式中的第二个字符不是“*”时：
 * a1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * a2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 *
 * 而当模式中的第二个字符是“*”时：
 * c1、如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
 *
 * 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * b1、模式后移2字符，相当于x*被忽略；
 * b2、字符串后移1字符，模式后移2字符，即*前面的字符出现了一次；
 * b3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为* 可以匹配多位；
 */
public class RegularExpressionsMatching_53
{
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern ==null)
            return false;

        int strIndex = 0;
        int patternIndex = 0;

        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private static boolean matchCore(char[] str,int strIndex, char[] pattern, int patternIndex)
    {
        //如果匹配到末尾了说明匹配成功
        if (strIndex >= str.length && patternIndex >= pattern.length)
            return true;
        //如果模式串已到末尾，但是字符串还没有到末尾，说明匹配失败
        if (strIndex < str.length && patternIndex >= pattern.length)
            return false;

        //当模式的第二个字符是'*'
        //需要注意的是，java一定要防止数组越界问题
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*')
        {
            //匹配串已经结束，防止str="",pattern=".*"的情况，如果不加此判断，下面if中str[strIndex]会越界
            if(strIndex >= str.length){
                return matchCore(str, strIndex, pattern,patternIndex + 2);
            }
            //前一个字符匹配,即前一个字符相同或者模式第一个字符为'.'
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')
            {
                //分三种情况递归
                //第一种情况，x*匹配0个字符，即*前面的一个字符出现0次
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        //第二种情况，匹配一个字符，即*前面的字符出现了一次
                        ||matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        //第三种情况，匹配一个字符，模式保持不变，因为*可以匹配多位
                        ||matchCore(str, strIndex + 1, pattern, patternIndex);

            }
            else
                //第一个位置不匹配，模式后移两位，也就是x*匹配0个字符
                return matchCore(str, strIndex, pattern, patternIndex + 2);
        }

        //第一个字符匹配，但模式第二个不是*，模式和字符串都后移一位
        if (strIndex < str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        else
            return false; //第一个字符不匹配并且模式第二个位置不是'*'
    }
}
