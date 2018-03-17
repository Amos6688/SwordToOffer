package com.offer;

/**
 * 剑指offer 面试题8
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解题思想：二分查找
 */
public class MinNumberInRotatedArray
{
    /**
     * 此段代码无法解决两个指针指向的数字以及他们中间的数字三者相同的情况，
     * 如果出现此情况，则只能采取顺序查找的方法
     * @param array
     * @return
     * @throws Exception
     */
    public int minNumberInRotateArray(int[] array) throws Exception
    {
        if(array == null)
            throw new Exception("Invalid parameter");

        int low = 0;
        int high = array.length - 1;
        int indexMid = low;
        while(array[low] >= array[high])
        {
            //循环的终止条件
            if(high - low == 1)
            {
                indexMid = high;
                break;
            }

            indexMid = (low + high) / 2;
            if(array[indexMid] >= array[low])
                low = indexMid;
            else if(array[indexMid] <= array[high])
                high = indexMid;
        }
        return array[indexMid];
    }

    public int minNumberInRotateArray2(int[] array) throws Exception
    {
        if(array == null)
            throw new Exception("Invalid parameter");

        int low = 0;
        int high = array.length - 1;
        int indexMid = low;
        while(array[low] >= array[high])
        {
            //循环的终止条件
            if(high - low == 1)
            {
                indexMid = high;
                break;
            }

            indexMid = (low + high) / 2;
            //如果下标为low， high， indexMid指向的三个数字相同
            //则只能顺序查找
            if(array[low] == array[high] && array[low] == array[indexMid])
                return MinInOrder(array, low, high);
            if(array[indexMid] >= array[low])
                low = indexMid;
            else if(array[indexMid] <= array[high])
                high = indexMid;
        }
        return array[indexMid];
    }

    //顺序查找最小值
    private int MinInOrder(int[] array, int low, int high)
    {
        int result = array[low];
        for(int i = 0; i <= high; i++)
        {
            if(result > array[i])
                result = array[i];
        }
        return result;
    }
}
