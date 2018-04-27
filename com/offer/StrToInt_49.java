package com.offer;

/**
 * 剑指offer 面试题49
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 解题思路：题目本身并不难，每次扫描一个字符，利用公式num = num * 10 + (chars[i] - '0')计算。
 * 但是重点是考虑各种输入输入的情况，比如带有正负号的字符串、""空串、null、以及超出整数最大最小值的情况。
 * 所以一定要实现想好测试用例
 */
public class StrToInt_49
{
    private final int MAX_VALUE = Integer.MAX_VALUE;
    private final int MIN_VALUE = Integer.MIN_VALUE;
    private int status; //用于区分传入的是空字符串还是null

    public int StrToInt(String str)
    {
        status = 0;
        if (str == null)
            status = 1;

        long num = 0;
        if (str != null && !str.equals("") && str.length() != 0)
        {
            char[] chars = str.toCharArray();
            boolean minus = false;
            boolean add = false;
            if (chars[0] == '-')
                minus = true;
            else if (chars[0] == '+')
                add = true;

            num = strToIntCore(chars, minus, add);
        }

        return (int)num;
    }

    private long strToIntCore(char[] chars, boolean minus, boolean add)
    {
        long num = 0;


        for (int i = ((minus || add) ? 1 : 0); i < chars.length; ++i)
        {
            if (chars[i] >= '0' && chars[i] <= '9')
            {
                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (chars[i] - '0');

                if (num > MAX_VALUE || num < MIN_VALUE)
                {
                    num = 0;
                    break;
                }
            }
            else
            {
                num = 0;
                break;
            }
        }

        return num;
    }
}
