package com.structureAlgorithm;

/**
 * 如何找出数组中唯一的重复元素
 * 问题描述：数组a[n],1~n-1这n-1个数存放在a[n]中，其中某个数重复一次。
 * 写一个函数，找出被重复的数字。要求每个数组元素只能方位一次，并且不使用辅助空间。
 *
 *
 * @author Chuan
 */
public class FindDupNum
{
    /**
     * 思想：采用数学求和法，因为只有一个数字重复1次，而又是连续的。根据累加原理，对数组的所有项求和，
     * 然后减去1~n-1的和，即为所求的重复元素
     * @param a 传入待查找的数组
     * @return 返回找到的唯一重复元素
     */
    public static int sum_findDup(int[] a)
    {
        int len = a.length;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < len - 1; ++i)
        {
            temp1 += (i + 1);
            temp2 += a[i];
        }

        temp2 += a[len - 1];

        int result = temp2 - temp1;
        return result;
    }

    /**
     *如果没有要求每个数组元素只能访问一次，且不允许使用辅助空间，还可以用异或法
     * 思想：数组a[n]中的n个数异或结果再与1~n-1异或的结果在做异或运算，得到的值即为所求
     * @param a 传入待查找的数组
     * @return 返回找到的唯一重复元素
     */
    public static int xor_findDup(int[] a)
    {
        int len = a.length;
        int i;
        int result = 0;
        for (i = 0; i < len; ++i)
        {
            result ^= a[i];
        }

        for (i = 1; i < len; ++i)
        {
            result ^= i;
        }

        return result;
    }

    /**
     * 空间换时间法
     * 思想：申请长度为N-1布尔型数组arrayFlag并初始化为false，然后从头开始遍历数组a，
     * 取每个数组元素a[i]的值，将其对应的数组arrayFlag中的元素赋值为true，如果已经设置过true，
     * 那么该数就是重复的元素
     * @param a 传入待查找的数组
     * @return 返回找到的唯一重复元素
     */
    public static int findInteger(int[] a)
    {
        int len = a.length;
        boolean[] arrayFlag = new boolean[len];
        int i = 1;
        int result = Integer.MAX_VALUE;
        while (i < len)
        {
            arrayFlag[i] = false;
            ++i;
        }

        for (i = 0; i < len; ++i)
        {
            if (arrayFlag[a[i]] == false)
            {
                arrayFlag[a[i]] = true;
            }
            else
            {
                result = a[i];
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] a = {1,2,1,3,4};
        int result = sum_findDup(a);
        System.out.println(result);

        int result2 = xor_findDup(a);
        System.out.println(result2);

        int result3 = findInteger(a);
        System.out.println(result3);
    }
}
