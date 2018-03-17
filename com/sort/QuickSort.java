package com.sort;

/**
 * 本例实现快速排序
 * 快速排序的思想：
 * 1、选定一个合适的值（理想情况选中值最好，但一般情况下选择数组的第一个元素），这个值称为转轴
 * 2、接下来遍历一遍数组，将数组分为两部分：比转轴小的数字移到转轴的左边，比转轴大的数字移到转轴的右边
 * 3、一遍遍历结束后，就确定了转轴的索引位置
 * 4、接下来就可以用递归的思想分别对转轴的左右两边进行排序
 */
public class QuickSort
{

    public void sort(int[] array, int low, int high)
    {

       if (low < high)
       {
           int index = partition(array, low, high);
           sort(array,low, index - 1);
           sort(array, index + 1, high);
       }
    }


    private int partition(int[] array, int low, int high)
    {
        int pivot = array[low];

        //扫描一遍数组
        while (low < high)
        {
            while (low < high && array[high] >= pivot)
                high--;
            array[low] = array[high];

            while (low < high && array[low] <= pivot)
                low++;
            array[high] = array[low];
        }

        //扫描完成，记得将转轴归为
        array[low] = pivot;

        return low;
    }


    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort();
        int[] arr = {7, 3, 8, 9, 1, 2, 6, 3, 9, 1};

        quickSort.sort(arr, 0, arr.length - 1);

        for (int i : arr)
            System.out.println(i);
    }
}
