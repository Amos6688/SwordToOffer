package com.offer;


/**
 * 剑指offer 面试题36
 * 题目描述：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对总和。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * @author chuan
 */
public class InversePairs_36
{

    public static void main(String[] args)
    {
        InversePairs_36 inversePairs_36 = new InversePairs_36();
        int[] array = {1,2,3,4,5,6,7,0};
        int count = inversePairs_36.InversePairs(array);
        System.out.println(count);
    }

    /**
     * 解题思路：利用归并排序的思想，把数组分割成子数组，先统计出子数组内部的逆序对的数目，
     * 然后再统计出两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序。
     * @param array 需要统计逆序对的数组
     * @return 逆序对的总数
     */
    public int InversePairs(int [] array)
    {
        if (array == null || array.length < 0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; ++i)
        {
            copy[i] = array[i];
        }

        int count = inverseParisCore(array, copy, 0, array.length - 1);
        return count;
    }

    public int inverseParisCore(int[] data, int[] copy, int start, int end)
    {
        if (start == end)
        {
            copy[start] = data[start];
            return 0;
        }

        int mid = (end + start) >> 1;
        int left = inverseParisCore(data, copy, start, mid) % 1000000007;
        int right = inverseParisCore(data, copy, mid + 1, end) % 1000000007;

        //i初始化为前半段最后一个数字的下标
        int i = mid;
        //j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= mid + 1)
        {
            if (data[i] > data[j])
            {
                copy[indexCopy--] = data[i--];
                count += j - mid;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[indexCopy--] = data[j--];
            }
        }

        for (; i >= start; --i)
        {
            copy[indexCopy--] = data[i];
        }

        for (; j >= mid + 1; --j)
        {
            copy[indexCopy--] = data[j];
        }

        //对子数组排序，以免在以后的统计过程中重复统计
        for(int k = start; k <= end; ++k) {
            data[k] = copy[k];
        }

        return (left + right + count) % 1000000007;
    }
}
