package com.structureAlgorithm;

/**
 * 如何把一个数组循环右移k位
 * 解题思想，以数组{1,2,3,4,5,6,7,8}循环右移2位为例
 * 第一步：逆序数组子序列{1,2,3,4,5,6},数组序列形式变为{6,5,4,3,2,1,7，8}
 * 第二步：逆序数组子序列{7.8}，数组序列形式变为{6,5,4,3,2,1,8,7}
 * 第三步：全部逆序，数组序列的形式变为{7,8,1,2,3,4,5,6}
 * @author Chuan
 */
public class Shift_k
{
    /**
     * 逆序数组子序列
     * @param num 传入需要逆序的数组
     * @param b 逆序开始下标
     * @param e 逆序终止下标
     */
    public static void reverse(int[] num, int b, int e)
    {
        int temp;
        for (; b < e; ++b, --e)
        {
            temp = num[b];
            num[b] = num[e];
            num[e] = temp;
        }
    }

    /**
     * 将数组num循环右移k位
     * @param num 传入需要循环右移的数组
     * @param k 传入需要循环右移k位
     */
    public static void shift_k(int[] num, int k)
    {
        int len = num.length;
        k = k % len; //为了防止k比n大，右移k为何右移k % len为结果一样
        reverse(num, len - k, len -1);
        reverse(num, 0,len - k - 1);
        reverse(num, 0, len - 1);
    }


    public static void main(String[] args)
    {
        int[] num  = {1,2,3,4,5,6,7,8};
        shift_k(num, 3);
        for (int i : num)
        {
            System.out.println(i);
        }
    }


}
