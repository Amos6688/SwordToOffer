package com.structureAlgorithm;

import java.util.Arrays;

/**
 *
 * 如何求数组中两两相加等于20的组合种数
 * @author Chuan
 */
public class FindSum
{
    /**
     * “蛮力”法
     * 采用两重循环遍历数组来判断两个数的和是否为sum
     * 因为采用了双重循环，因此这个算法的时间复杂度为O（n2）
     * @param num
     * @param sum
     */
    public static void findSum(int[] num, int sum)
    {
        int len = num.length;
        int i, j;
        for (i = 0; i < len; ++i)
        {
            for (j = i + 1; j < len; ++j)
            {
                if (num[i] + num[j] == sum)
                {
                    System.out.println(num[i] + ", " + num[j]);
                }
            }
        }
    }

    /**
     *排序法
     * 思想，先对数组元素进行排序，此时算法的时间复杂度为O（nlogn）,然后对排序后的的数组分别从前到后和从后到前遍历，
     * 假设从前往后遍历的下标为begin，从后往前遍历的下表哦为end，那么当num[begin] + num[end] < sum时，如果
     * 存在两个数的和为sum，那么这两个数一定在[begin+1, end]之间；当满足num[begin] + num[end] > sum时，如果
     * 存在两个数的和为sum，那么这两个数一定在[begin,end+1]之间。这个过程的时间复杂度为O（n）。因此整个算法的时间复杂度为
     * O（nlogn）
     * @param num
     * @param sum
     */
    public static void  findSum2(int[] num, int sum)
    {
        Arrays.sort(num);
        int begin = 0;
        int end = num.length - 1;
        while (begin < end)
        {
            if (num[begin] + num[end] < sum)
            {
                ++begin;
            }
            else if (num[begin] + num[end] > sum)
            {
                --end;
            }
            else
            {
                System.out.println(num[begin] + ", " + num[end]);
                ++begin;
                --end;
            }
        }
    }


  public static void main(String[] args)
    {
        int[] num = {1,7,17,2,6,13,14};
        findSum(num, 20);
        findSum2(num, 20);
    }

}
