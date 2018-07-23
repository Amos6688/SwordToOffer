package com.structureAlgorithm;

/**
 * 如何判断一个数是否是2的n次方
 *
 * @author Chuan
 */
public class IsTwoPower
{
    /**
     * 方法一基本思想：最直观的的就是用1做移位操作，然后判断移位后的值是否与给定值相等
     * @param n 给定的需要判断的值
     * @return 如果n是2的的整数次幂返回true，否则返回false
     */
    public static boolean isPower(int n)
    {
        if (n < 1)
        {
            return false;
        }
        int i = 1;
        while (i <= n)
        {
            if (i == n)
            {
                return true;
            }
            i <<= 1;
        }
        return false;
    }

    /**
     * 方法二基本思想：如果一个数是2的n次方，那么其二进表示中只有1位是1，其余都为0。
     * 因此判断一个数是否是2的n次方可以转换成判断这个数的二进制表示中是否只有一位为1。
     * 如果一个数的二进制表示只有一位为1，例如num=00010000，那么num-1 = 00001111，
     * 由于num和num-1二进制表示中中的每一位都不同，因此num&（num-1）的结果为0，可以利用这种方法来判断一个数是否是2的n次方
     * @param n 给定的需要判断的值
     * @return 如果n是2的的整数次幂返回true，否则返回false
     */
    public static boolean isPower2(int n)
    {
        if (n < 1)
        {
            return false;
        }
        int m = n & (n - 1);
        return m == 0;
    }


    public static void main(String[] args)
    {
        System.out.println(isPower2(4));
        System.out.println(isPower2(6));
    }

}
