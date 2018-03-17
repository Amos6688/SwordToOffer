package com.offer;

/**
 * 剑指offer 面试题4相关题目
 * 两个已经排序的数组A和B，从数组A和B的尾部遍历比较元素，大的放在新数组的后面。最后如果B中还有元素，将其加入新数组中。
 */
public class SortedArrayMerge
{

    public static void main(String[] args)
    {
        SortedArrayMerge sortedArrayMerge = new SortedArrayMerge();
        int arr1[] = {1,4,5,7,10,11,15};
        int arr2[] = {2,3,6,8,9,13,14,17};
        sortedArrayMerge.merge(arr1,arr2);
    }


    private void merge(int[] a, int[] b)
    {
        int newLength = a.length + b.length;

        //用于存放结果
        int[] c = new int[newLength];

        int mergeTail = newLength - 1;
        int aTail = a.length -1;
        int bTail = b.length -1;

        while (bTail >= 0 && aTail >= 0)
        {
            if (b[bTail] >= a[aTail])
            {
                c[mergeTail] = b[bTail--];
            }
            else
            {
                c[mergeTail] = a[aTail--];
            }
            mergeTail--;
        }

        //注意两个数组比较完成之后，可能会有一个数组中仍然有元素，需要将其也放入c数组
        while (aTail >= 0)
        {
            c[mergeTail--] = a[aTail--];
        }
        while (bTail >= 0)
        {
            c[mergeTail--] = b[bTail--];
        }

        for (int i : c)
            System.out.println(i);
    }
}
