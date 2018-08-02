package com.structureAlgorithm;

/**
 * 如何判断一个数组中数值是否是连续的
 * 题目描述：一个数组，元素的取值可能是0~65535中任意一个，相同的数值不会出现。0是例外，可以反复出现。
 * 设计一种算法，当从该数组序列中随意选出5个数值，判断这五个数的值是否连续相邻。需要注意以下四点：
 * 1、5个数值允许是乱序的，例如{8,7,5,0,6}
 * 2、0可以统配任意数值，例如{8,7,5,0,6}中0可以通配9或者4
 * 3、0可以多次出现
 * 4、全0算连续，只有一个非0算连续
 * @author Chuan
 */
public class NumContinuous
{
    /**
     * 思路：如果没有0的存在，要组成连续的数组，最大值和最小值的差距必定为4，存在0的情况下，只要最大值
     * 和最小值的差距小于4就可以了，所以应找出数列中非0的最大值和非0的最小值，时间复杂度为O（n），如果
     * max-min<=4,那么这五个数就是连续相邻，否则，不连续相邻。
     * @param a 需要判断是否连续响铃的数组
     * @return 如果a连续相邻，返回true,否则返回false
     */
    public static boolean isContinuous(int[] a)
    {
        int len = a.length;
        int min = -1, max = -1;

        for (int i = 0; i < len; ++i)
        {
            if (a[i] != 0) {
                if (min > a[i] || -1 == min) {
                    min = a[i];
                }
                if (max < a[i] || -1 == max)
                {
                    max = a[i];
                }
            }
        }

        if (max - min > len - 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {8,7,5,0,6};
        if (isContinuous(a))
        {
            System.out.println("数组{8,7,5,0,6}连续相邻");
        }
        else
        {
            System.out.println("数组{8,7,5,0,6}不连相邻");
        }
    }
}
