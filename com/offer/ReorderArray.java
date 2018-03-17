package com.offer;

/**
 * 剑指offer 面试题14
 * 输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得所有奇数位于数组的前半部分，所有的数组位于数组的后半部分。
 */
public class ReorderArray
{

    public static void main(String args[])
    {
        int[] array={1,2,3,4,5,6,7};
        ReorderArray test=new ReorderArray();
        test.reOrderArray(array);
        for(int item:array)
            System.out.println(item);
    }

    private void reOrderArray(int [] array)
    {
        int length = array.length;
        if(array == null || length == 0)
            return;

        int begin = 0;
        int end = length - 1;

        while(begin < end)
        {
            //向后移动begin，直到它指向偶数
            while(begin < end && !isEven(array[begin]))
                ++begin;
            //向前移动end,直到他指向奇数
            while(begin < end && isEven(array[end]))
                --end;
            //注意此处需要判断
            if(begin < end)
            {
                int tmp = array[begin];
                array[begin] = array[end];
                array[end]= tmp;
            }
        }
    }

    /**
     * 判断n是奇数还是偶数
     * @param n
     * @return
     */
    private boolean isEven(int n)
    {
        return (n & 1) == 0;
    }
}
