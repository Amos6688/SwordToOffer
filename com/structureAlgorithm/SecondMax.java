package com.structureAlgorithm;

/**
 * 如何找出数组中第二大的数
 * @author Chuan
 */
public class SecondMax
{
    /**
     * 基本思想：通过设置两个变量max和secMax，max用来存储最大数，初始值为数组首元素，
     * secMax用来存储数组元素的第二大数，初始值为最小负数。然后遍历整个数组，如果当前数组
     * 元素的值比max大，则将secMax更新为max的值，max的值更新为当前元素值。当前元素值比max小，
     * 则判断当前元素值是否比secMax值大，如果大的话，则更新secMax值为当前元素的值。
     * 此方法只需要遍历一次数组即可
     * @param num 待求第二大数的数组
     * @return 返回数组中的第二大数
     */
    public static int findSecMax(int[] num)
    {
        if (num == null || num.length < 2)
        {
            return Integer.MIN_VALUE;
        }

        int max = num[0];
        int secMax = Integer.MIN_VALUE;
        for (int i = 1; i < num.length; ++i)
        {
            if (num[i] > max)
            {
                secMax = max;
                max = num[i];
            }
            else
            {
                if (num[i] > secMax)
                {
                    secMax = num[i];
                }
            }
        }
        return secMax;
    }

    public static void main(String[] args)
    {
        int[] num = {7, 3, 19, 40, 4, 7, 1};
        System.out.println(findSecMax(num));
    }
}
