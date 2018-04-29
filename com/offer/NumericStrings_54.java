package com.offer;

/**
 * 剑指offer 面试题54
 * 题目描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 解题思路：三种方法，推荐第一种方法
 */
public class NumericStrings_54
{
    private int index;

    /********************************************************************************
     * 方法一：
     * 1. 合法的数值可以表示为A[.[B]][e|EC]或者.B[e|EC].
     * 2. 其中A为整数部分，B为小数部分，C为e|E的指数部分。在纯小数的时候，可能没有整数部分，如小数.123等于0.123，是合法的。所以A部分不是必须的。
     * 3. A和C都是整数，可以带符号，也可不带。B是一个无符号整数
     * @param str 需要判断的字符串（已经转化为字符数组）
     * @return 是否为数字
     *****************************************************************************/
    public boolean isNumeric(char[] str)
    {
        if(str == null || str.length == 0)
            return false;

        index = 0;
        boolean numeric = scanInteger(str);
        //判断小数部分
        if (index < str.length && str[index] == '.')
        {
            ++index;
            // 之所以使用||，而没有使用&&的原因。小数可以没有整数部分，
            // 如.123等于0.123；小数点后面可以没有数字，如233.等于233.0；当然，小数点前后都可以有数字，如1.123；
            numeric = scanDigital(str) || numeric;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e'))
        {
            ++index;
            numeric = scanInteger(str) && numeric;
        }

        return  numeric && index >= str.length;

    }

    //判断是否是整数
    private boolean scanInteger(char[] str)
    {
        //注意数组边界判断
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            ++index;

        return scanDigital(str);
    }

    //判断是否为数字
    private boolean scanDigital(char[] str)
    {
        int i = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            ++index;

        return index > i;
    }

    /********************************************************************************
     * 方法二：
     *1. 使用正则表达式匹配
     *2. 虽然这可能并不是该题的本意，但本着“英雄不问出处，好汉亦可流氓”的原则，仍在此给出实现。
     * @param str 需要判断的字符串（已经转化为字符数组）
     * @return 是否为数字
     *****************************************************************************/
    public boolean isNumeric2(char[] str)
    {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    /********************************************************************************
     * 方法三：
     *1.利用系统自身的校验机制。
     *2.此方法为了解题而解题，不鼓励使用
     * @param str 需要判断的字符串（已经转化为字符数组）
     * @return 是否为数字
     *****************************************************************************/
    public boolean isNumeric3(char[] str)
    {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
