package com.offer;

import java.util.Arrays;

/**
 * 剑指offer 面试题12
 * 方法一:递归
 * 输入数字n，按顺序打印出从1到最大的n位进制数。比如输入3，则打印出1、2、3一直到999.
 */
public class Print1ToMaxOFDigits2
{
    public static void main(String[] args)
    {
        Print1ToMaxOFDigits p = new Print1ToMaxOFDigits();
        p.print1ToMaxOFDigits(3);
    }


    /**
     * 用字符串表示数字,因为数字最大是n位的，因此我们需要一个长度为n的字符串
     * 区别于C++字符串中最后一个是结束符号‘\0’
     * @param n
     */
    public void print1ToMaxOFDigits(int n)
    {
        if (n <= 0)
            return;
        char[] number = new char[n];

        for (int i = 0; i < 10; ++i)
        {
            number[0] = (char) (i + '0');
            print1ToMaxOFDigitsRecursively(number, n, 0);
        }
    }

    /**
     *
     * @param number
     * @param length
     * @param index
     */
    private void print1ToMaxOFDigitsRecursively(char[] number, int length, int index)
    {
        //递归终止条件:已经设置了数字的最后一位
        if (index == length -1)
        {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++)
        {
            number[index + 1] = (char)(i + '0');
            print1ToMaxOFDigitsRecursively(number, length, index + 1);
        }
    }

    //打印函数
    private void printNumber(char[] number)
    {
        boolean isBeginning0 = true;
        int length = number.length;

        for (int i = 0; i < length; ++i)
        {
            if (isBeginning0 && number[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0)
            {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
