package com.structureAlgorithm;

/**
 * 如何找出数组中只出现一次的数字
 * 方法一：两重循环遍历数组，时间复杂度为O（n2）
 * 方法二：先对数组进行排序，然后从第一个数字开始遍历，比较相邻的两个数，时间复杂度为O（nlogn）
 * 方法三：采用异或运算
 * 方法四：通用方法，适用于只有一个数出现一次，其他数都出现n次的所有情况
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

    /**
     * 方法四：以n = 3位例，加入数组中有如下元素{1,1,1,2,2,2},他们对应的二进制表示为01,01,01,10,10,10.
     * 显然这个数组中的所有数字对应的二进制数中第0位有3个1，第一位有3个1.对于本体而言，假设出现一次的这个数为a，
     * 那么去掉a后其他所有数字对应的二进制数的每个位置出现1的格式为3的倍数。因此可以对数组中的所有数字对应的二进制数
     * 中各个位置上1的个数对3取余，就可以得到出现一次的这个数数的二进制表示
     * @param num 传入需要查找的数组
     * @return 返回出现一次的数字
     */
    public static int findOnce(int[] num, int appearTimes)
    {
        int len = num.length;
        int[] bitCount = new int[32];

        //计算数组中所有数字对应的二进制数个位置上1出现的次数
        for (int i = 0; i < len; ++i)
        {
            for (int j = 0; j < 32; ++j)
            {
                bitCount[j] += ((num[i] >> j) & 1);
            }
        }

        //若某位上的结果不能被整除，则肯定目标数字在这一位上
        int appearOne = 0;
        for (int i = 0; i < 32; ++i)
        {
            if (bitCount[i] % appearTimes != 0)
            {
                appearOne += (1 << i);
            }
        }

        return appearOne;
    }


    public static void main(String[] args)
    {
        int[] num = {1,2,3,2,4,3,5,4,1};
        int result = findNotDouble(num);
        int result2 = findOnce(num, 2);
        System.out.println(result);
        System.out.println(result2);
    }


}
