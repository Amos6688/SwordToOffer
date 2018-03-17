package com.offer;

/**
 * 剑指offer 面试题9
 */
public class EasyFibonacci
{
    //实用的解法是从下往上计算，首先根据f(0) 和f(1)计算出f(2)
    //再根据f(1) 和f(2)计算出f(3)...依次类推
    public int Fibonacci(int n)
    {
        int[] result = {0,1};
        if(n < 2)
            return result[n];

        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;
        for(int i = 2; i <= n; i++)
        {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }
}
