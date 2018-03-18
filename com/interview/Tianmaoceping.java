package com.interview;

import java.util.ArrayList;
import java.util.List;

public class Tianmaoceping
{
    private ArrayList<Integer> list = new ArrayList<>();
    private static int minSum = Integer.MAX_VALUE;

    public void combinationCore(int[] a, int[] b, int aStart, int bStart, int length, ArrayList<Integer> list)
    {
        ArrayList<Integer> result = new ArrayList<>(list);
        if(aStart  == length)
        {
            while (bStart < length)
                result.add(b[bStart++]);
            printList(result);
            computeMinSum(result);
            return;
        }
        if (bStart == length)
        {
            while (aStart < length)
                result.add(a[aStart++]);
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

    private void computeMinSum(List<Integer> list)
    {
        int sum = 0;
        for (int i = 0; i <list.size() - 1; i += 2)
        {
            sum += list.get(i) * list.get(i + 1);
        }
        if (sum < minSum)
            minSum = sum;
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};


        Tianmaoceping tianmaoceping = new Tianmaoceping();
        tianmaoceping.combinationCore(a, b, 0, 0, a.length, tianmaoceping.list);

        System.out.println("最小和为" + tianmaoceping.minSum);
    }
}
