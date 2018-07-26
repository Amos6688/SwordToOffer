package com.structureAlgorithm;

/**
 * 如何求对数之差的最大值
 * 问题描述：数组中的一个数字减去它右边子数组中的一个数字可以得到一个差值，求所有差值中的最大值
 * @author Chuan
 */
public class PairMax
{
    /**
     * 利用动态规划算法
     * 思想：给定数组a，申请额外的数组diff和max，其中diff[i]是以数组中第i个数字为减数的所有数对之差的最大值
     * （前i+1个数组成的子数组中最大的差值），max[i]为前i+1个数的最大值。假设已经求得了diff[i],那么diff[i+1]
     * 的值有两种可能性：1）等于diff[i],2)等于max[i] - a[i+1]。通过上面的分析，可以得到哦动态规划方法的表达式为：
     * diff[i+1] = max{diff[i], max[i] - a[i+1]}, max[i+1] = max{max[i], a[i+1]}
     * @param a 传入待计算数组
     * @return 返回数组中对数之差的最大值
     */
    public static int getPairMax(int[] a)
    {
        if (a == null)
        {
            return Integer.MAX_VALUE;
        }
        int len = a.length;
        if (len <= 1)
        {
            return Integer.MIN_VALUE;
        }

        int[] diff = new int[len];
        int[] max = new  int[len];
        diff[0] = Integer.MIN_VALUE;
        max[0] = a[0];
        for (int i = 1; i < len; ++i)
        {
            diff[i] = max(diff[i-1], max[i-1] - a[i]);
            max[i] = max(max[i-1], a[i]);
        }

        return diff[len-1];
    }


    /**
     * 利用动态规划算法
     * 思想：对方法一进行改进。因为在求解diff[i+1]时，只用到了diff[i]与max[i],
     * 而与diff和max数组中其他数字无关，因此可以通过；两个变量而不是数组来记录diff[i]和max[i]
     * 的值，从而降低了算法的刷空间复杂度
     * @param a 传入待计算数组
     * @return 返回数组中对数之差的最大值
     */
    public static int getPairMax2(int[] a)
    {
        if (a == null)
        {
            return Integer.MAX_VALUE;
        }
        int len = a.length;
        if (len <= 1)
        {
            return Integer.MIN_VALUE;
        }

        int diff = 0;
        int max = a[0];
        for (int i = 1; i < len; ++i)
        {
            diff = max(diff, max - a[i]);
            max = max(max, a[i]);
        }

        return diff;
    }

    public static int max(int a, int b)
    {
        return a > b ? a : b;
    }

    public static void main(String[] args)
    {
        int[] a = {1,4,17,3,2,9};
        System.out.println(getPairMax(a));

        System.out.println(getPairMax2(a));
    }

}
