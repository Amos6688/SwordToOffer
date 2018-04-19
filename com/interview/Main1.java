package com.interview;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 在GBK编码环境下，编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"，6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * @author chuan
 */
public class Main1
{
        public static void main(String[] args) throws UnsupportedEncodingException
        {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            int byteNum = in.nextInt();
            System.out.println(subString(str, byteNum));
        }

        private static String subString(String str, int splitByteNum) throws UnsupportedEncodingException
        {
            //输入无效判断
            if (null == str || "".equals(str) || splitByteNum <= 0)
            {
                return "";
            }

            int tempSubStrLength = splitByteNum;
            //截取长度为要截取字节数的子串。说明str.length()字符串中字符个数一定小于等于字节数。
            String subStr = str.substring(0, tempSubStrLength > str.length() ? str.length() : tempSubStrLength);
            //在GBK编码下，得到子串的字节长度
            int subStrByteNum = subStr.getBytes("GBK").length;
            //如果子串的字节长度大于字符长度，说明一定有汉字
            while (subStrByteNum > tempSubStrLength)
            {
                /**
                 * 在子串末尾去掉一个字符，重新计算子串在GBK下的字节长度。
                 * 因为是去掉一个字符，而汉字占一个字符，所以不用考虑半个汉字的问题
                 */
                int subStrLength = --splitByteNum;
                subStr = str.substring(0, tempSubStrLength > str.length() ? str.length() : subStrLength);
                subStrByteNum = subStr.getBytes("GBK").length;
            }
            return subStr;
        }
}
