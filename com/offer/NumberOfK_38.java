package com.offer;

/**
 * 剑指offer 面试题38
 * 统计一个数字在排序数组中出现的次数。
 * 解题思路：先用二分查找法在数组中找到用第一个k出现的下标，再用二分查找法在数组中找到对后一个k出现的下标
 *
 * @author chuan
 */
public class NumberOfK_38
{

    public int GetNumberOfK(int [] array , int k)
    {
        int number = 0;
        if (array != null && array.length > 0)
        {
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);

            if (first > -1 && last > -1)
                number = last - first + 1;
        }

        return number;
    }

    //获取数字第一次出现的下标
    private static int getFirstK(int[] array, int k, int start, int end)
    {
        if (start > end)
            return -1;

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k)
        {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                end = middleIndex - 1;
        }
        else if (middleData >k)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;

        return getFirstK(array, k, start, end);
    }

    //获取数字最后一次出现的下标
    private static int getLastK(int[] array, int k, int start, int end)
    {
        if (start > end)
            return -1;

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k)
        {
            if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k) || middleIndex == array.length - 1)
                return middleIndex;
            else
                start = middleIndex + 1;
        }
        else if (middleData < k)
            start = middleIndex + 1;
        else
            end = middleIndex - 1;

        return getLastK(array, k, start, end);
    }
}
