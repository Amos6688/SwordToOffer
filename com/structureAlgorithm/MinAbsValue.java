package com.structureAlgorithm;

import java.util.Map;

/**
 * 如何求绝对值最小的数
 * 题目描述：有一个升序排列的数组，数组中可能有证书、负数和0，求数组中绝对值最小的元素
 * @author Chuan
 */
public class MinAbsValue
{
    /**
     * 思想：求绝对值最小的数可以分为三种情况:
     * 1、如果数组第一个元素为非负数，那么绝对值最小的数肯定为数组的第一个元素
     * 2、如果数组的最后一个元素为非正数，那么绝对值最小的肯定是数组最后一个元素
     * 3、数组中既有正数又有负数或0时，首先找到正数和负数的分界点，如果分界点恰好为0，那么0就是绝对值最小的数，
     * 否则通过比较分界点左右正数和负数的绝对值确定最小的数（利用二分法查找，每次枢轴取中间节点）
     * @param a
     * @return
     */
    public static int getMinAbsValue(int[] a)
    {
        int len = a.length;
        if (a == null || a.length < 1)
        {
            return Integer.MIN_VALUE;
        }

        //数组中没有负数
        if (a[0] >= 0)
        {
            return a[0];
        }

        //数组中没有正数
        if (a[len - 1] <= 0)
        {
            return a[len - 1];
        }

        //数组中既有正数又有负数或者0
        int mid = 0;
        int begin = 0;
        int end = len - 1;
        int absMin = 0;
        while (true)
        {
            mid = begin + (end - begin) / 2;
            //如果值为0，那么就是绝对值最小的数
            if(a[mid] == 0)
            {
                return 0;
            }
            //如果值大于0，那么正负数分界点在左半部分
            else if (a[mid] > 0)
            {
                //继续在数组的左半部分查找
                if (a[mid - 1] == 0)
                {
                    return 0;
                }
                else if (a[mid - 1] > 0)
                {
                    end = mid - 1;
                }
                else
                {
                    break;
                }
            }
            //在数组的右半部分继续查找
            else
            {
                if (a[mid + 1] == 0)
                {
                    return 0;
                }
                else if (a[mid + 1] < 0)
                {
                    begin = mid + 1;
                }
                else
                {
                    break;
                }
            }
        }

        //获取正负分界点的最小值
        if (a[mid] > 0)
        {
            if (a[mid] < Math.abs(a[mid - 1]))
            {
                absMin = a[mid];
            }
            else absMin = a[mid - 1];
        }
        else
        {
            if (Math.abs(a[mid]) < a[mid + 1])
            {
                absMin = a[mid];
            }
            else
            {
                absMin = a[mid + 1];
            }
        }

        return absMin;
    }

    public static void main(String[] args)
    {
        int[] a = {-10,-5,-2,7,15,50};
        int[] b = {2,4,6,8,27};
        int[] c = {-13,-9,-7,-3};

        System.out.println(getMinAbsValue(a));
        System.out.println(getMinAbsValue(b));
        System.out.println(getMinAbsValue(c));
    }


}
