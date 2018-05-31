package com.sort;

/**
 * 插入排序
 */
public class InsertSort
{
    public static <T extends Comparable<? super T>> void insertSort(T[] a)
    {
        for (int p = 1; p < a.length; ++p)
        {
            T tmp = a[p];   //保存当前位置p的元素，其中[0,p-1]已经有序
            int j;
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; --j)
            {
                a[j] = a[j - 1];    //后移一位
            }
            a[j] = tmp;     //插入到合适的位置
        }
    }

    public static void main(String[] args)
    {
        Integer[] a = {34, 8, 64, 51, 32, 21};
        insertSort(a);
        for (Integer i : a)
            System.out.print(i + "  ");
    }
}
