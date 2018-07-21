package com.sort;

/**
 * 插入排序
 * 基本思想：对于给定的一组记录，初始是假设第一个记录自称一个有序序列，其余记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，
 * 直到最后一个记录插入到有序序列中为止
 *
 * @author Chuan
 */
public class InsertSort
{
    public static  void insertSort(int[] a)
    {
        if (a != null)
        {
            int temp , j;
            for (int i = 1; i < a.length; ++i)
            {
                temp = a[i];
                j = i;
                if (a[j - 1] > temp)
                {
                    while (j >= 1 && a[j - 1] > temp)
                    {
                        a[j] = a[j -1];
                        --j;
                    }
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = {34, 8, 64, 51, 32, 21};
        insertSort(a);
        for (Integer i : a)
            System.out.print(i + "  ");
    }
}
