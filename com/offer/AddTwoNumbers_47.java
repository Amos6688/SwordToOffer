package com.offer;

/**
 * 剑指offer 面试题47
 * 题目描述：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 解题思路：利用位运算。第一步不考虑进位对每一位相加，相当于异或。
 * 第二步进位，只有当1加1时会产生进位，此时可以想象成两个数先做与运算，然后再向左移动一位。
 * 第三步把前面的两个步骤的结果相加，第三步的过程依然是重复前面两步，直到不产生进位为止
 */
public class AddTwoNumbers_47
{
    public int Add(int num1,int num2)
    {
        int sum ;
        int carry;

        do {
            sum = num1 ^ num2;  //异或
            carry = (num1 & num2) << 1; //左移产生进位

            num1 = sum;
            num2 = carry;
        }while (num2 != 0);

        return num1;
    }
}
