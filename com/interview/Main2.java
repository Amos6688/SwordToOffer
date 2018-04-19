package com.interview;

import java.util.Scanner;

/**
 * 华为机试题2
 * 从1900年1月1日（星期一），开始经过的n年当中，没个月的13号这一天是星期一，星期二，星期三...星期日的次数分别是多少
 *
 * @author chuan
 */
public class Main2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt())
        {
            int years = in.nextInt();
            int[] times = getTimes(years);

            for (int i = 1; i <= 6; i++) {
                System.out.print(times[i] + " ");
            }
            System.out.print(times[0] + " ");
        }
    }

    private static int[] getTimes(int yesrs)
    {
        //下标0-6分别表示星期日到星期六，数值表示13在星期几出现几次
        int[] times = new int[7];
        int week = 6;   //1990年第一个13号出现在星期六

        for (int i = 1900; i < 1900 + yesrs; ++i)
        {
            for (int m = 1; m <= 12; ++m)
            {
                times[week % 7]++;
                week += getMonthDays(i, m);
            }
        }
        return times;
    }

    private static int getMonthDays(int year, int month)
    {
        boolean isLeapYear = false;
        //判断是否为闰年
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            isLeapYear = true;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month  == 10 || month == 12)
            return 31;
        else if (month == 2)
        {
            if (isLeapYear)
                return 29;
            else return 28;
        }
        else
            return 30;
    }
    public static boolean tag(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if ((year & 3) == 0)
            return true;
        else
            return false;
    }
}
