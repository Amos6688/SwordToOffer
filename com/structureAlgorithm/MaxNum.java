package com.structureAlgorithm;

/**
 * 如何用递归方法求一个整数数组的最大元素
 *
 * @author Chuan
 */
public class MaxNum
{
    public static int max(int a, int b)
    {
        return a > b ? a : b;
    }

    /**
     * 思想：递归的求解“数组第一个元素”与“数组中其他元素组成数组的最大值”的最大值
     * @param a
     * @param begin
     * @return
     */
    public static int maxNum(int[] a, int begin)
    {
        int len = a.length - begin;
        if (len == 1)
        {
            return a[begin];
        }
        else
        {
            return max(a[begin], maxNum(a, begin + 1));
        }
    }


    public static void main(String[] args)
    {
        int[] a = {0, 16, 2, 3, 4, 5, 10, 7, 8, 9};
        System.out.println(maxNum(a, 0));
    }
}
