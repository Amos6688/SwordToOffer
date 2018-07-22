package com.sort;

/**
 * 希尔排序
 * 基本思想：希尔排序是将待排序的数组元素按下标的一定增量分组，分成多个子序列，然后对各个
 * 子序列进行直接插入排序算法排序；然后依次缩减增量再进行排序，直到增量为1时，进行最后一次直接插入排序。
 * 排序结束
 * @author Chuan
 */
public class ShellSort
{
    public static void shellSort(int[] num)
    {
        if (num == null || num.length <= 1)
        {
            return;
        }

        //希尔排序，升序排列
        int i, j, temp;
        int len = num.length;
        for (int h = len / 2; h > 0; h = h / 2)  //h为每次插入排序的增量
        {
            for (i = h; i < len; i++)   //i为每次要插入的元素的下标，
            {
                temp = num[i];
                for (j = i - h; j >= 0; j -= h)     //j为与i同一组元素的下标
                {
                    //如果要插入的元素小于同组最后的元素，则将同组大于它的元素后移
                    //直到找到它应该插入的位置
                    if (num[j] > temp)
                    {
                        num[j + h] = num[j];
                    }
                    else
                    {
                        break;
                    }
                }
                num[j + h] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        shellSort(a);
        for (int i : a)
        {
            System.out.println(i);
        }
    }

}
