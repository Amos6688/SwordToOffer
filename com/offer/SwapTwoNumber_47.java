package com.offer;

/**
 * 剑指offer 面试题47相关
 *
 * 题目描述：不使用新的变量，交换两个变量的值
 *
 * 解题思路：第一种利用加减法。第二种利用异或
 */
public class SwapTwoNumber_47
{
    /**
     * 交换数组中两个元素
     * 解法1：利用加减法
     * @param array 只有两个元素的数组
     *@return 交换位置后的数组
     */
     public int[] SwapTwoNumber(int[] array)
     {
         array[0] = array[0] + array[1];
         array[1] = array[0] - array[1];
         array[0] = array[0] - array[1];

         return array;
     }

    /**
     * 交换数组中两个元素
     * 解法1：利用异或
     * @param array 只有两个元素的数组
     * @return 交换位置后的数组
     */
    public int[] SwapTwoNumber2(int[] array)
    {
        array[0] = array[0] ^ array[1];
        array[1] = array[0] ^ array[1];
        array[0] = array[0] ^ array[1];

        return array;
    }

}
