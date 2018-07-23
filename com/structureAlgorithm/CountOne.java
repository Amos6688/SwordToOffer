package com.structureAlgorithm;

/**
 * 如何求二进制数中1的个数
 * @author Chuan
 */
public class CountOne
{
    /**
     * 方法1思想：首先判断这个数的最后一位是否为1，如果为1，则计数器加1，然后，通过右移丢弃掉最后一位。
     * 循环执行该操作直到这个数为0为止
     * @param n 需要统计二进制表示中包含1个数的整数
     * @return 返回n的二进制表示中包含1的个数
     */
    public static int countOne(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if ((n & 1) == 1)
            {
                ++count;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 由于题目要求求出1的个数，此时可以只考虑1的个数
     * @param n 需要统计二进制表示中包含1个数的整数
     * @return 返回n的二进制表示中包含1的个数，把二进制表示中的1看做独立的个体。利用判断一个整数是否是2的n次方的方法2
     * 介绍的算法可以求出1的个数。给定一个数n，没进行一次n&（n-1）计算，其结果中都会少了一位1，而且是最后一位。
     */
    public static int countOne2(int n)
    {
        int count = 0;
        while (n > 0)
        {
           n = n & (n - 1);
           ++count;
        }
        return count;
    }


    public static void main(String[] args)
    {
        System.out.println(countOne2(7));
        System.out.println(countOne2(8));
    }

}
