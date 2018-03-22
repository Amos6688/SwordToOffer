package com.offer;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class KLeastNumbers
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
        int index = partition(input, length, start, end);
        if (index != k - 1)
        {
            if (index > k -1)
            {
                end = index - 1;
                index = partition(input, length, start, end);
            }
            else
            {
                start = index + 1;
                index = partition(input, length, start, end);
            }
        }

        for (int i = 0; i < k; ++i)
            result.add(input[i]);
        return result;
    }


    private int partition(int[] array, int length, int start, int end) throws Exception {
        if (array == null || length <= 0 || start < 0 || end >= length)
            throw new Exception("Invalid Parameter");

        Random random = new Random();
        int index = random.nextInt(length);
        swap(array, index, end);

        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (array[index] < array[end]) {
                ++small;
                if (small != index)
                    swap(array, small, index);
            }
        }

        ++small;
        swap(array, small, end);

        return small;
    }

    private void swap(int[] data, int index, int end) {
        int temp = data[index];
        data[index] = data[end];
        data[end] = temp;
    }
}
