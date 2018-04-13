package com.offer;

import java.util.*;

/**
 * 剑指offer 面试题33
 * 把数组排成最小的数
 * 思路：两个数字吗，能拼接成数字mn和nm。如果mn<nm,则mn为所求结果，此时定义m<n;反之n<m.
 * 所以我们需要定义一个排序规则，先对数组进行排序。最后将数组中数字从头到尾拼接起来。
 * 数学证明略
 * @author chuan
 */
public class SortArrayForMinNumber_33
{
    public String PrintMinNumber(int [] numbers)
    {
        int arrayLength = numbers.length;
        String minNumber = null;

        List<Integer> numberList = new ArrayList<>();
        for (int i : numbers)
        {
            numberList.add(i);
        }
        Collections.sort(numberList, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer i1, Integer i2)
            {
                String str1 = i1 + "" + i2;
                String str2 = i2 + "" + i1;
                return str1.compareTo(str2);
            }
        });

        for (Integer i : numberList)
        {
            minNumber += i;
        }

        return minNumber;
    }
}
