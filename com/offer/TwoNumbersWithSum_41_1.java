package com.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer 面试题41
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 解题思路：可以设置两个指针，第一个指向数组的第一个数字，第二个指向数组的最后一个数字。
 * 计算这两个数字的当前和，如果当前和等于sum，则已找到（a和b越远乘积越小，而一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况。
 * 如果是乘积最大的情况就是一直找到两个指针重合，每次找到一个就将之前返回的结果向量清空然后更新为新找到的）。如果当前和小于sum，
 * 我们希望两个数字的和再大一点，由于数组已经排好序，就可以考虑选择较小数字后面的数字。如果当前和大于sum，我们希望两个数字的和再小一点，
 * 就可以考虑较大数字前面的数字。
 */
public class TwoNumbersWithSum_41_1
{

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if (array == null || array.length < 2 || sum < 3)
            return result;

        int ahead = array.length - 1;
        int behind = 0;

        while (ahead > behind)
        {
            long curSum = array[ahead] + array[behind];

            if (curSum == sum)
            {
                result.add(array[behind]);
                result.add(array[ahead]);
                break;
            }
            else if (curSum > sum)
                ahead--;
            else
                behind++;
        }

        return result;
    }
}
