package com.structureAlgorithm;

import java.util.ArrayList;

/**
 * 如何计算两个有序数组的交集
 * 题目描述:假设两个含有n个元素的有序（非降序）整型数组a和b，其中a={0,1,2,3,4},
 * b={1,3,5,7,9},那么它们的交集为{1,3}
 * @author Chuan
 */
public class TwoArraysMixed
{
    /**
     * 思路：二路归并法。设两个数组分别为a和b。分别以i，j从头开始遍历连个数组。在遍历过程过，
     * 若当前便利位置的a[i]==b[j]，则此数为两个数组的交集，记录下来，并继续向后遍历a和b。
     * 若a[i]>b[j],则需继续向后遍历b。若a[i]<b[j]，则需继续向后遍历a。直到有一个数组结束为止。
     * @param a 数组1
     * @param b 数组2
     * @return 返回数组1和数组2的交集
     */
    public static ArrayList<Integer> mixed(int[] a, int[] b)
    {
        ArrayList<Integer> mix = new ArrayList<>();
        int i = 0, j = 0;
        int n1 = a.length;
        int n2 = b.length;
        while (i <  n1 && j < n2)
        {
            if (a[i] == b[j])
            {
                mix.add(a[i]);
                ++i;
                ++j;
            }
            else if (a[i] > b[j])
            {
                ++j;
            }
            else if (a[i] < b[j])
            {
                ++i;
            }
        }

        return mix;
    }

    public static void main(String[] args)
    {
        int[] a = {0,1,2,3,4};
        int[] b = {1,3,5,7,9};
        ArrayList<Integer> mix = mixed(a, b);
        for (Integer i : mix)
        {
            System.out.println(i);
        }
    }
}
