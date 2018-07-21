package com.sort;

/**
 * 冒泡排序
 * 基本思想：对于给定的的n个记录，从第一个记录开始一次对相邻的两个记录进行比较，当前面的记录大于后面的记录时，交换位置；
 * 进行一轮比较和换位后，n个记录中最大记录将位于第n位；然后再对前（n-1）个记录进行第二轮比较；重复该比较过程，直到进行
 * 比较的记录只剩下一个为止
 *
 * @author Chuan
 */
public class BubbleSort
{
    public static void bubbleSort(int[] num)
    {
        int i, j;
        int temp;
        int len = num.length;
        for (i = 0; i < len - 1; ++i)   //n个数要进行n-1轮循环比较
        {
            for (j = 0; j < len - i - 1; ++j)
            {
                if (num[j] > num[j + 1])
                {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        bubbleSort(a);
        for (int i : a)
        {
            System.out.println(i);
        }
    }

}
