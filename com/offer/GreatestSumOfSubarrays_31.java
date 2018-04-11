package com.offer;

/**
 * 剑指offer面试题 31
 * 输入一个整形数组，数组里有证书也有负数，求所有子数组的和的最大值
 *
 * 分析：数组{1，-2，3，10，-4，7，2，-5}。初始化和为0，从第一个数字开始累加，如果到第k个数累加和为负数了，
 * 就说明从第一个数字开始的子数组的和会小于从第k+1开始的子数组的和。因此我们可以currentSum变量保存当前的和，
 * 用greatestSum变量保存最大的和。如果currentSum小于0，则currentSum等于下一个数，否则继续累加。
 * 并用greatestSum保存最大和，最后返回greatestSum
 */
public class GreatestSumOfSubarrays_31
{
    boolean invalidInput = false;
    public int FindGreatestSumOfSubArray(int[] array)
    {
        if(array == null || array.length == 0)
        {
            invalidInput = true;
            return 0;
        }

        invalidInput = false;
        int currentSum = 0;
        int greatestSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; ++i)
        {
            if (currentSum < 0)
                currentSum = array[i];
            else
                currentSum += array[i];


            if (currentSum > greatestSum)
                greatestSum = currentSum;
        }

        return greatestSum;
    }
}
