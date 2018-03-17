package com.offer;

/**
 * 剑指offer 面试题10
 */
public class NumberOf1InBinary
{
    public int NumberOf1(int n)
    {
        int count = 0;
        //把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
        //那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的运算。
        while(n != 0)
        {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }


//    public int NumberOf1(int n)
//    {
//        int count = 0;
//        //利用Integer的静态方法先将n转换为二进制字符串
//        //然后再通过String的方法toCharArray()将二进制字符串转换为字符数组
//        char[] array = Integer.toBinaryString(n).toCharArray();
//
//        for(int i = 0; i < array.length; ++i)
//        {
//            if(array[i] == '1')
//                ++count;
//        }
//        return count;
//    }
}
