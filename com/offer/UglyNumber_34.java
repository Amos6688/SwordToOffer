package com.offer;

/**
 * 剑指offer面试题 34
 * 求按从小到大的顺序的第N个丑数。
 *
 *解题思路：定义一个数组，里面的数字都是排好序的丑数，每一个丑数都是前面的丑数乘以2、3或者5得到的。
 * 那么问题就成了下一个丑数是如何得到的，该丑数一定是前面某一个丑数乘以2, 3或5的结果。我们没有必要每次都把已有
 * 的每个丑数分别乘以2,3，和5，只需要每次都记下乘以2， 3， 5之后大于当前最大丑数的数的位置即可。
 * @author chuan
 */
public class UglyNumber_34
{
    public int GetUglyNumber_Solution(int index)
    {
        if (index <= 0)
            return 0;

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int m2 = 0;
        int m3 = 0;
        int m5 = 0;

        while (nextUglyIndex < index)
        {
            int min = min(uglyNumbers[m2] * 2, uglyNumbers[m3] * 3, uglyNumbers[m5] * 5);
            uglyNumbers[nextUglyIndex] = min;

            while (uglyNumbers[m2] * 2 <= uglyNumbers[nextUglyIndex])
                ++m2;
            while (uglyNumbers[m3] * 3 <= uglyNumbers[nextUglyIndex])
                ++m3;
            while (uglyNumbers[m5] * 5 <= uglyNumbers[nextUglyIndex])
                ++m5;

            ++nextUglyIndex;
        }

        int ugly = uglyNumbers[nextUglyIndex - 1];
        return ugly;
    }

    int min(int number1, int number2, int number3)
    {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;

        return min;
    }
}
