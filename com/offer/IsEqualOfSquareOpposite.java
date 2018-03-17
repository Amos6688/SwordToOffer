package com.offer;

import java.util.HashSet;
import java.util.Iterator;


/**
 * 剑指offer 面试题28相关提
 * 输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上（从上面到下面（都为从左上角逆时针）依次放置），
 * 使得正方体上的三组对面上的4个顶点和都相等。
 * 解题思路：首先对这八个数字进行全排列，然后判断有没有一个排列符合题目给定的条件
 */
public class IsEqualOfSquareOpposite
{
    HashSet<int[]> result = new HashSet<>();
    public void findMapPerMutation(int[] array)
    {
        if (array == null || array.length != 8)
            return;
        findMapPerMutationCore(array, 0);
    }

    private void findMapPerMutationCore(int[] array, int begin)
    {
        if (begin == array.length - 1)
        {
            //找到一个排列，看是否符合条件
            if (isEqual(array))
                result.add(array);
            return;
        }
        else
        {
            for (int i = begin; i < array.length; ++i)
            {
                int temp = array[i];
                array[i] = array[begin];
                array[begin] = temp;

                findMapPerMutationCore(array, begin + 1);

                temp = array[i];
                array[i] = array[begin];
                array[begin] = temp;
            }
        }
    }

    private boolean isEqual(int[] array)
    {
        boolean isEqual = false;
        if
                (array[0] + array[1] + array[2] + array[3] == array[4] + array[5] + array[6] + array[7]
                && array[0] + array[2] + array[4] + array[6] == array[1] + array[3] + array[5] + array[7]
                && array[0] + array[1] + array[4] + array[5] == array[2] + array[3] + array[6] + array[7]
                )
            isEqual = true;

        return isEqual;
    }


    public static void main(String[] args)
    {
        int[] a = {1,2,3,1,2,3,2,2};

        IsEqualOfSquareOpposite isEqual = new IsEqualOfSquareOpposite();
        isEqual.findMapPerMutation(a);

        HashSet<int[]> set = isEqual.result;
        for (Iterator<int[]> iterator = set.iterator(); iterator.hasNext();)
        {
            int[] array = iterator.next();
            for (int i : array)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
