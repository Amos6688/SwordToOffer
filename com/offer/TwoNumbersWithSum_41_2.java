package com.offer;

import java.util.ArrayList;

/**
 * 剑指offer 面试题41_2
 * 题目描述：输入一个正整数s，打印出所有和为s的连续正整数序列。
 * <p>
 * 解题思路：用两个正整数small和big分别表示序列的最大值和最小值，首先把small初始化为1，
 * big初始化为2.如果从small到big的序列和大于s，我们可以从序列中去掉最小的值，也就是增大small的值。
 * 如果从small到big的序列的和小于s，我们可以增大big，让这个序列包含更多的数字。
 * 因为这个序列至少要有两个数字，我们一直增加small到（1+s）/2为止
 */
public class TwoNumbersWithSum_41_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3)
            return result;

        int small = 1;
        int big = 2;
        /**
         * 我的理解是：
         * 当sum为偶数时比如10，只需small < 10 / 2即可，因为当samll 等于5以后的序列一定会大于10；
         * 当sum为奇数时比如11，如果samll < 11 / 2,即samll<5。那就会漏掉5，6这个序列
         * 所以middle =  (1 + sum) / 2
         */
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum)
                result.add(addContinuousSequenceToList(small, big));

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;

                if (curSum == sum)
                    result.add(addContinuousSequenceToList(small, big));
            }

            ++big;
            curSum += big;

        }

        return result;
    }

    private ArrayList<Integer> addContinuousSequenceToList(int small, int big) {
        ArrayList<Integer> continuousSequence = new ArrayList<>();
        for (int i = small; i <= big; ++i)
            continuousSequence.add(i);

        return continuousSequence;
    }
}
