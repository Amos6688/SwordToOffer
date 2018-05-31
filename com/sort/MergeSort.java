package com.sort;

/**
 * 归并排序
 */
public class MergeSort
{
    //将有二个有序数列a[first...mid]和a[mid + 1...last]合并。
    private static void mergeArray(int[] a, int first, int mid, int last, int[] tmp)
    {
        int i = first, j = mid + 1;
        int n = mid, m = last;
        int k = 0;

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

        for (i = 0; i < k; ++i)
            a[first + i] = tmp[i];
    }

    private static void mergeSortCore(int[] a, int first, int last, int[] tmp)
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergeSortCore(a, first, mid, tmp);
            mergeSortCore(a, mid + 1, last, tmp);
            mergeArray(a, first, mid, last, tmp);
        }

    }


    public static void mergeSort(int[] array)
    {
        if (array == null || array.length <= 0)
            return;

        int[] tmp = new int[array.length];
        mergeSortCore(array, 0, array.length - 1, tmp);
    }

    public static void main(String[] args)
    {
        int[] a = {34, 8, 64, 51, 32, 21};
        mergeSort(a);
        for (Integer i : a)
            System.out.print(i + "  ");
    }

}
