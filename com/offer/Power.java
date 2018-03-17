package com.offer;

/**
 * 剑指offer 面试题11
 */
public class Power
{
    //定义一个全局变量来标识是否出错
    //为了区分是出错时返回的0，还是底数为0时返回的0
    boolean g_InvalidInput = false;
    public double Power(double base, int exponent)
    {
        g_InvalidInput = false;
        double result =1.0;

        //处理负面测试
        if(equal(base, 0.0) && exponent < 0)
        {
            g_InvalidInput = true;
            return 0.0;
        }

        //当指数为负数的时候，可以先求其绝对值，
        //然后算出次方的结果之后再取倒数
        else
        {
            int absExponent = Math.abs(exponent);
            result = PowerWithAbsExponent(base, absExponent);
            if(exponent < 0)
                result = 1 / result;
        }
        return result;
    }

    public double PowerWithAbsExponent(double base, int absExponent)
    {
        double result = 1.0;
        for (int i = 0; i < absExponent; ++i)
            result *= base;

        return result;
    }

    //
    public double PowerWithAbsExponent2(double base, int absExponent)
    {
        if (absExponent == 0)
            return 1;
        else if(absExponent == 1)
            return base;
        else
        {
            double result = PowerWithAbsExponent2(base, absExponent >> 1);
            result *= result;
            if ((absExponent & 1) == 1)
                result *= base;
            return result;
        }
    }

    //由于精度原因不能用等号判断两个小数是否相等
    public boolean equal(double num1, double num2)
    {
        if((num1 - num2 > -0.0000001)
                &&(num1 - num2 < 0.0000001))
            return true;
        else
            return false;
    }
}
