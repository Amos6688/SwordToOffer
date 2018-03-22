package com.offer;

import java.util.Random;

/**
 * 剑指offer 面试题29
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum
{
    private boolean inputInvalid = false;

    /**
     * 思路：类似于快速排序算法，排序之后位于数组中间的的数字一定就是那个出现次数最多的数字
     * @param array
     * @return 找到的出现次数最多的数字
     * @throws Exception
     */
    public int MoreThanHalfNum_Solution(int [] array) throws Exception
    {
        int length = array.length;
        if (checkInvalidArray(array, length))
            return 0;

        int middle = length >> 1; //右移一位，相当于除2

        int start = 0;
        int end = length - 1;

        int index = partition(array, length, start, end);

        while (index != middle)
        {
            if (index > middle)
            {
                end = index -1;
                index = partition(array, length, start, end);
            }
            else
            {
                start = index + 1;
                index = partition(array, length, start, end);
            }
        }

        int result = array[middle];
        if (!checkMoreThanHalf(array, length, result))
            return 0;
        return result;
    }

    /**
     * 解法2：在遍历数组的时候保存两个值：一个是数组中的数字，一个是次数。当遍历下一个数字的时候，
     * 如果下一个数字和之前保存的数字相同，则次数加1；如果不同，则减1。如果次数为0，需要保存下一个数字，
     * 并把次数设为1。由于要找的数字出现的次数比其他所有数字出现的次数都多，那么要找的数字肯定是最后一次把次数设为1时对应的数字
     * @param array
     * @return 找到的数字
     * @throws Exception
     */
    public int MoreThanHalfNum_Solution2(int [] array) throws Exception
    {
        int length = array.length;
        if (checkInvalidArray(array, length))
            return 0;

        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; ++i)
        {
            if (times == 0) {
                result = array[i];
                times = 1;
            }
            else if (array[i] == result)
                ++times;
            else
                --times;
        }
        if (!checkMoreThanHalf(array, length, result))
            return 0;
        return result;
    }



    private int partition(int[] data, int length, int start, int end) throws Exception
    {
        if (data == null || length <= 0 || start < 0 || end >= length)
            throw new Exception("Invalid Parameter");

        Random rand = new Random();
        int index = rand.nextInt(length);
        swap(data, index, end);

        int small = start - 1;
        for (index = start; index < end; ++index)
        {
            if (data[index] < data[end])
            {
                ++small;
                if(small != index)
                    swap(data, index, small);
            }
        }

        ++ small;
        swap(data, small, end);

        return small;
    }

    private void swap(int[] data, int index, int end)
    {
        int temp = data[index];
        data[index] = data[end];
        data[end] = temp;
    }

    private boolean checkInvalidArray(int[] array, int length)
    {
        inputInvalid = false;
        if (array == null || length <= 0)
            inputInvalid = true;
        return inputInvalid;
    }

    private boolean checkMoreThanHalf(int[] array, int length, int number)
    {
        int times = 0;
        for (int i = 0; i < length; i++)
            if (array[i] == number)
                ++times;

        boolean isMoreThanHalf = true;
        if (times * 2 <= length)
        {
            inputInvalid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

}
