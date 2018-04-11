package com.offer;

import java.util.Collections;
import java.util.ArrayList;

public class  KLeastNumbers
{
    public static void main(String[] args)
    {
        int[] input = {4,5,1,6,2,7,3,8};

        KLeastNumbers kLeastNumbers = new KLeastNumbers();
        ArrayList<Integer> result = kLeastNumbers.GetLeastNumbers_Solution(input, 8);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
    {
        int length = input.length;
        ArrayList<Integer> result =   new ArrayList<>();
        if (input == null || length <= 0 || k <= 0 || k > length)
            return result;

        for (int i = 0; i < k; ++i)
            result.add(input[i]);

        for (int i = k; i < length; ++i)
        {
            Collections.sort(result);
            int max = result.get(k - 1);
            if (max > input[i])
                result.set(k - 1, input[i]);
        }

        return result;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) throws Exception
    {
        int length = input.length;
        ArrayList<Integer> result =   new ArrayList<>();
        if (input == null || length <= 0 || k <= 0 || k >= length)
            return result;

        int start = 0;
        int end = length - 1;
        int index = partition(input, start, end);
        if (index != k - 1)
        {
            if (index > k -1)
            {
                end = index - 1;
                index = partition(input, start, end);
            }
            else
            {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; ++i)
            result.add(input[i]);
        return result;
    }


    private int partition(int[] array, int low, int high)
    {

        int pivot = array[low];

        //扫描一遍数组
        while (low < high)
        {
            while (low < high && array[high] >= pivot)
                high--;
            array[low] = array[high];

            while (low < high && array[low] <= pivot)
                low++;
            array[high] = array[low];
        }

        //扫描完成，记得将转轴归位
        array[low] = pivot;

        return low;
    }
}
