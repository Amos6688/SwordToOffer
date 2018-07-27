package com.structureAlgorithm;


/**
 * 如何求指定数字在数组中第一次出现的位置
 * 问题描述：给定数组a={3,4,5,6,5,6,7,8,9,8}.这个数组中相邻匀速之差绝对值都为1，给定数字9，
 * 它在数组中第一次出现的位置下标为8（数组下标从0开始）
 * @author Chuan
 */
public class FirstIndex
{
    /**
     * 思想：跳跃搜索法
     * 从数组第一个元素开始（i=0），把数组当前位置的值与t进行比较，如果相等，则返回数组下标，
     * 否则从数组下标为i+|t-a[i]|处继续查找
     * @param a 传入给定数组
     * @param t 要查找的指定元素
     * @return 返回指定元素第一次出现的位置
     */
    public static int findFirstIndex(int[]a , int t)
    {
        if (a == null)
        {
            return -1;
        }
        int len = a.length;
        int i = 0;
        while (i < len)
        {
            if (a[i] == t)
            {
                return i;
            }
            else
            {
                i += Math.abs(t - a[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] a = {3,4,5,6,5,6,7,8,9,8};
        System.out.println(findFirstIndex(a, 9));
    }

}
