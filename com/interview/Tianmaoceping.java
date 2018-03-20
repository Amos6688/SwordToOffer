package com.interview;

import java.util.ArrayList;
import java.util.List;

public class Tianmaoceping
{
    private static int minSum = Integer.MAX_VALUE;

    public void combineArrayAndComputeMin(int[] a, int[] b)
    {
        if (a.length != b.length || a.length <= 0)
            return;
        combinationCore(a, b, 0, 0, a.length, new ArrayList<>());
    }

    private void combinationCore(int[] a, int[] b, int aStart, int bStart, int length, ArrayList<Integer> list)
    {
        ArrayList<Integer> result = new ArrayList<>(list);

        if(aStart  == length || bStart == length)
        {
            while (aStart < length)
                result.add(a[aStart++]);

            while (bStart < length)
                result.add(b[bStart++]);

            printList(result);
            computeMinSum(result);
            return;
        }

        result.add(a[aStart]);
        combinationCore(a, b, aStart  + 1, bStart, length, result);
        result.remove(result.size() - 1);
        result.add(b[bStart]);
        combinationCore(a, b, aStart, bStart + 1, length, result);
    }

    private void printList(List<Integer> list)
    {
        for (Integer i : list)
            System.out.print(i + " ");
        System.out.println( );
    }

    //求最小值
    private void computeMinSum(List<Integer> list)
    {
        int sum = 0;
        for (int i = 0; i <list.size() - 1; i += 2)
            sum += list.get(i) * list.get(i + 1);

        if (sum < minSum)
            minSum = sum;
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        Tianmaoceping tianmaoceping = new Tianmaoceping();
        tianmaoceping.combineArrayAndComputeMin(a, b);

        System.out.println("最小和为" + tianmaoceping.minSum);
    }
}
