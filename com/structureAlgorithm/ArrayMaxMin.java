package com.structureAlgorithm;

/**
 * 如何寻找数组中的最大值与最小值
 *
 * @author Chuan
 */
public class ArrayMaxMin
{
    static int max;
    static int min;

    /**
     *基本思想：取双元素法。维持两个变量max和min，min标记最小值，max标记最大值。每次比较两个数，较大者与max比较，
     * 较小者与min比较。通过比较找出最大值和最小值。此种方法的比较次数为1.5N次
     * @param num
     */
    public static void getMaxAndMin(int[] num)
    {
        max = num[0];
        min = num[0];
        int len = num.length;

        for (int i = 1; i < len - 1; i += 2)
        {
            if (num[i] > num[i + 1])
            {
                if (num[i] > max)
                {
                    max = num[i];
                }
                if (num[i + 1] < min)
                {
                    min = num[i + 1];
                }

            }

            if (num[i] < num[i + 1])
            {
                if (num[i + 1] > max)
                {
                    max = num[i + 1];
                }
                if (num[i] < min)
                {
                    min = num[i + 1];
                }

            }
        }
    }


    public static void main(String[] args)
    {
        int[] num = {7, 3, 19, 40, 4, 7, 1, 2, 50};
        getMaxAndMin(num);
        System.out.println("max=" + max);
        System.out.println("min=" + min);
    }

}
