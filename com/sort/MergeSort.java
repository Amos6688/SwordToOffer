package com.sort;

/**
 * 归并排序
 * 基本思想：归并排序是利用分治技术将数据序列划分为越来越小的半子表，再对半子表排序，
 * 最后再利用递归方法将排好序的半子表合并成越来越大的有序序列。对于给定的一组记录（假设共有n个记录），
 * 首先将两个相邻的长度为1的子序列进行归并，得到n/2（向上取整）个长度为2或1的有序子序列，
 * 再将其两两归并，反复执行此过程，直到得到一个有序序列
 * @author Chuan
 */
public class MergeSort
{
    //将有二个有序数列a[first...mid]和a[mid + 1...last]合并。
    private static void mergeArray(int[] a, int first, int mid, int last)
    {
        int i = first, j = mid + 1;
        int n = mid, m = last;
        int k = 0;
        int[] tmp = new int[a.length];

        while (i <= n && j <= m)
        {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else
                tmp[k++] = a[j++];
        }

        while (i <= n)
            tmp[k++] = a[i++];

        while (j <= m)
            tmp[k++] = a[j++];

        //将排好序的部分更新到原数组
        for (i = 0; i < k; ++i)
            a[first + i] = tmp[i];
    }

    private static void mergeSortCore(int[] a, int first, int last)
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergeSortCore(a, first, mid);
            mergeSortCore(a, mid + 1, last);
            mergeArray(a, first, mid, last);
        }

    }


    public static void mergeSort(int[] array)
    {
        if (array == null || array.length <= 0)
            return;
        mergeSortCore(array, 0, array.length - 1);
    }

    public static void main(String[] args)
    {
        int[] a = {34, 8, 64, 51, 32, 21};
        mergeSort(a);
        for (Integer i : a)
            System.out.print(i + "  ");
    }

}
