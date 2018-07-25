package com.structureAlgorithm;

/**
 * 如何找出数组中只出现一次的数字
 * 方法一：两重循环遍历数组，时间复杂度为O（n2）
 * 方法二：先对数组进行排序，然后从第一个数字开始遍历，比较相邻的两个数，时间复杂度为O（nlogn）
 * 方法三：采用异或运算
 * @author Chuan
 */
public class NotDouble
{
    /**
     * 采用方法三实现：异或运算
     * 根据异或运算的定义可知，任何一个数字异或它自己都等于0，所以，如果从头到尾一次异或数组中的每一个数字，
     * 那些出现两次的数字全部在异或中会被抵消掉，最终的结果刚好是这个只出现1次的数字
     * @param num
     * @return
     */
    public static int findNotDouble(int[] num)
    {
        int len = num.length;
        int result = num[0];
        for (int i = 1; i < len; ++i)
        {
            result = result ^ num[i];
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] num = {1,2,3,2,4,3,5,4,1};
        int result = findNotDouble(num);
        System.out.println(result);
    }


}
