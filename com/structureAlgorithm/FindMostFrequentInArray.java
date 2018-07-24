package com.structureAlgorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 如何找出数组中重复次数最多的数
 *
 * @author Chuan
 */
public class FindMostFrequentInArray
{
    /**
     * 思想：使用Map映射表。通过引入Map映射表来记录一个元素出现的次数，然后判断次数大小，进而找到重复次数最多的元素
     * @param num 待差
     * @return 返回重复次数最多的元素
     */
    public static int findMostFrequentInArray(int[] num)
    {
        int result = 0;
        int len = num.length;
        if (len == 0)
        {
            return Integer.MAX_VALUE;
        }

        //记录元素出现的次数
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < len; ++i)
        {
            if (m.containsKey(num[i]))
            {
                m.put(num[i], m.get(num[i]) + 1);
            }
            else
            {
                m.put(num[i], 1);
            }
        }

        int most = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = m.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > most)
            {
                result = key;
                most = val;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] num = {1,5,4,3,4,4,5,4,5,5,6,6,6,6,6};
        int maxFrequenceNum = findMostFrequentInArray(num);
        System.out.println(maxFrequenceNum);
    }


}
