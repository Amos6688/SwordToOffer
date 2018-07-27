package com.structureAlgorithm;

/**
 * 如何求数组中两个元素的最小距离
 * 题目描述：给定一个数组，数组中含有重复元素，给出两个数n1和n2,求这两个数字在数组汇总所出现位置的最小距离
 * @author Chuan
 */
public class MinDistance
{
    /**
     * 思想:遍历数组，会遇到以下两种情况
     * 1、当遇到n1时，记录n1值对应的数组下标位置为n1_index,通过求n1_index与上次遍历到n2的下标n2_index的差，
     * 可以求出最近一次遍历到n1与n2的距离。
     * 2、当遇到n2时，记录n2值对应的数组下标位置为n2_index,通过求n1_index与上次遍历到n1的下标n1_index的差，
     *  可以求出最近一次遍历到n1与n2的距离。
     *  定义一个变量min_dist记录n1与n2的最小距离，在以上两种情况下，每次求出n1与n2的距离与min_dist相比，求最小值。
     *  这样只需对数组进行一次遍历就可以求出最小距离
     * @param a
     * @return
     */
    public static int getMinDistance(int[] a, int n1, int n2)
    {
       if (a == null)
       {
           return Integer.MIN_VALUE;
       }

       int len = a.length;
       int n1_index = -1;
       int n2_index = -1;
       int min_distance = Integer.MAX_VALUE;

       for (int i = 0; i < len; ++i)
       {
           if (a[i] ==  n1)
           {
               n1_index = i;
               if (n2_index >= 0)
               {
                   min_distance = min(Math.abs(min_distance), Math.abs(n1_index - n2_index));
               }
           }
           if (a[i] == n2)
           {
               n2_index = i;
               if (n1_index >= 0)
               {
                   min_distance = min(Math.abs(min_distance), Math.abs(n2_index - n1_index));
               }
           }
       }

       return min_distance;
    }

    private static int min(int a, int b)
    {
        return a > b ? b : a;
    }

    public static void main(String[] args)
    {
        int[] a = {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
        System.out.println(getMinDistance(a, 4, 8));
    }

}
