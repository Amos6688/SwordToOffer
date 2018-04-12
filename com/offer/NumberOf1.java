package com.offer;

/**
 * 剑指offer面试题32
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * @author chuan
 */
public class NumberOf1
{
    /**
     * 解题思路：https://blog.csdn.net/yi_afly/article/details/52012593
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n)
    {
        if (n < 1)
            return 0;
        int count = 0;
        int round = n;
        int base = 1;

        while (round > 0)
        {
            int weight = round % 10;
            round = round / 10;
            count += round * base;
            if (weight == 1)
                count += (n % base) + 1;
            else if (weight > 1)
                count += base;

            base = base * 10;
        }

        return count;
    }



    public int NumberOf1Between1AndN_Solution2(int n)
    {
        int number = 0;
        for(int i = 1; i <=n; ++i)
        {
            number += NumberOf1(i);
        }
        return number;
    }

    public int NumberOf1(int n)
    {
        int number = 0;
        while(n != 0)
        {
            if(n % 10 == 1)
                ++number;
            n = n / 10;
        }
        return number;
    }
}
