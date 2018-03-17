package com.offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

/**
 * 剑指offer 面试题12相关题目
 * 两个大叔相加（减）
 * 思路：可以利用Java中自带的大数类BigInteger
 */
public class TwoBigDataAddition
{

    public static void main(String[] args) throws IOException
    {
        //构建控制台标准输入流
       InputStreamReader inputStreamReader = new InputStreamReader(System.in);
       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

       String number1 = bufferedReader.readLine();
       String number2 = bufferedReader.readLine();

       System.out.println(bigAddition(number1, number2));
    }

    private static BigInteger bigAddition(String number1, String number2)
    {
        BigInteger result;

        BigInteger b1 = new BigInteger(number1);
        BigInteger b2 = new BigInteger(number2);

        result = b1.add(b2);

        return result;
    }
}
