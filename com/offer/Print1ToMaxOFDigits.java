package com.offer;


import java.util.Arrays;

/**
 * 剑指offer 面试题12
 * 方法一模拟整数相加法
 * 输入数字n，按顺序打印出从1到最大的n位进制数。比如输入3，则打印出1、2、3一直到999.
 */
public class Print1ToMaxOFDigits
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
        //将数组的每一位都置为0
        Arrays.fill(number, '0');

        while (!increment(number))
        {
            printNumber(number);
        }
    }

    /**
     * increment实现在数字的字符串上加1,判断达到最大值的条件是第一个字符产生了进位
     * @param number 传入的字符串数组
     * @return 如果达到了最大值返回true， 否则返回false
     */
    private boolean increment(char[] number)
    {
        //是否达到最大位
        boolean isOverFlow = false;
        //进位
        int nTakeOver = 0;
        int length = number.length;

        for (int i = length - 1; i >= 0; --i)
        {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == length - 1)
                ++nSum;

            if (nSum >= 10)
            {
                //最高位进位则溢出
                if (i == 0)
                    isOverFlow = true;
                else
                {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] =(char) ('0' + nSum);
                }
            }
            else
            {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverFlow;
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
