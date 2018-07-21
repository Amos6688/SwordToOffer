package com.sort;

/**
 * 选择排序
 * 基本原理：对于给定的一组记录，经过第一轮比较后得到最小的的记录，然后将该记录与第一个记录的位置进行交换；
 * 接着对不包括第一个记录以外的其他记录进行第二轮比较，得到最小的记录并与第二个记录进行位置交换；
 * 重复该过程，直到进行比较的记录只有一个时为止。
 * @author Chuan
 */
public class SelectSort
{
    public static void selectSort(int[] num)
    {
        int temp, flag, n = num.length;

        for (int i = 0; i < n; ++i)
        {
            temp = num[i];
            flag = i;
            for (int j = i + 1; j < n; ++j)
            {
                if (num[j] < temp)
                {
                    temp = num[j];
                    flag = j;
                }
            }
            if (flag != i)
            {
                num[flag] = num[i];
                num[i] = temp;
            }
        }
    }


    public static void main(String[] args)
    {
        int[] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        selectSort(a);
        for (int i : a)
        {
            System.out.println(i);
        }
    }

}
