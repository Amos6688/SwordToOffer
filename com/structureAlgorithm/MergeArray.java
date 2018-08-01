package com.structureAlgorithm;

/**
 * 如何对数组的两个字有序段进行合并
 * 题目描述：数组a[0,mid-1]和a[mid,n-1]是各自有序的，对数组a[0,n-1]的两个子有序段进行合并，得到a[0,n-1]整体有序。
 * 要求空间复杂度为O（1）
 * @author Chuan
 */
public class MergeArray
{
    /**
     * 首先，遍历数组中下标为0~mid-1的元素，将遍历到的元素值与a[mid]进行比较，当遍历到a[i]（0<=i<=mid-1）时，
     * 如果满足a[mid] < a[i]，那么交换a[i]与a[mid]的值。接着找到交换后的a[mid]在a[mid,n-1]中的具体位置（插入排序），
     * 实现方法为：遍历a[mid, n-2]，如果a[mid + 1] < a[mid],那么交换a[mid]与a[mid+1]的位置。
     * @param a 需要进行合并的数组
     * @param mid 第二段有序数组的起始位置
     */
    public static void findRightPlaceForMid(int[] a, int mid)
    {
        int len = a.length;
        int temp;

        for (int i = mid; i < len - 1; ++i)
        {
            if (a[i + 1] < a[i])
            {
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }

    public static void sort(int[] a, int mid)
    {
        int temp;
        for (int i = 0; i <= mid - 1; ++i)
        {
            if (a[mid] < a[i])
            {
                temp = a[i];
                a[i] = a[mid];
                a[mid] = temp;
                findRightPlaceForMid(a, mid);
            }
        }
    }


    public static void main(String[] args)
    {
        int[] a = {1,5,6,7,9,2,4,8,10,13,14};
        sort(a, 5);
        for (int i : a)
        {
            System.out.println(i);
        }
    }
}
