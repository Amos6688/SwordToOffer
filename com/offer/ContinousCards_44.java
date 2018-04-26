package com.offer;

import java.util.Arrays;

/**
 * 剑指offer 面试题44
 * 题目描述：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这五张牌是不是连续的。
 * 2~10 为数字本身，A 为1，J 为11，Q 为12， K 为13，而大小王可看做任意数字。
 *
 * 解题思路:首先把数组排序，在统计数组中0 的个数，最后统计排序后数组中相邻数字之间的空缺总数。
 * 如果空缺总数小于或等于0的个数，那么这个数组就是连续的，否则不连续
 */
public class ContinousCards_44
{
    public boolean isContinuous(int [] numbers)
    {
        int length = numbers.length;
        if (length < 5)
            return false;

        //对数组进行排序
        Arrays.sort(numbers);

        for (int i : numbers)
            System.out.print(i + " ");

        int numberOfZero = 0;
        int numberOfGap = 0;

        //统计数组中0的个数
        for (int i = 0; i <length && numbers[i] == 0; ++i)
            ++numberOfZero;

        //统计数组中间隔的数目
        int small = numberOfZero; //在已经排好序的数组中计算非0数字的间隔数目
        int big = small + 1;

        while (big < length)
        {
            //两个数相等，有对子，不可能是顺子
            if (numbers[small] == numbers[big])
                return false;

            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            ++big;
        }

        return numberOfGap <= numberOfZero;

    }
}
