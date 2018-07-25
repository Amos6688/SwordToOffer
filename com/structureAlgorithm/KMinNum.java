package com.structureAlgorithm;

/**
 * 如何查找数组中第k个最小的数
 *
 * @author Chuan
 */
public class KMinNum
{
    /**
     * “剪枝”法
     * 采用快速排序的思想来实现。主要事项如下:
     * 选取一个数pivot = num[low]作为枢轴，把比它小的数都放在它的左边，比它大的数都放在它的右边。
     * 然胡判断它的位置，如果它的位置为k-1，那么它就是第k个最小的数；如果它的位置小于k-1，那么说明第k个小的元素
     * 一定在数组的右半部分，采用递归的方法在数组的右半部分继续查找；否则第k个小的元素在数组的左半部分，采用递归的方法
     * 在数组的左半部分继续查找。
     * @param num 传入待查找的数组
     * @param low 数组的起始位置
     * @param high 数组的终止位置
     * @param k 要查找的第k小元素
     */
    public static int KMinPartition(int[] num, int low, int high, int k)
    {
        if (low > high)
        {
            return Integer.MAX_VALUE;
        }

        int pivot = num[low];
        int i = low, j = high;
        while (i < j)
        {
            while (i < j && num[j] >= pivot)
            {
                j--;
            }
            num[i] = num[j];
            while (i < j && num[i] <= pivot)
            {
                i++;
            }
            num[j] = num[i];
        }

        num[i] = pivot;

        if (i + 1 == k)
        {
            return pivot;
        }
        else if (i + 1 < k)
        {
            return KMinPartition(num,i + 1, high, k);
        }
        else
        {
            return KMinPartition(num, low, i - 1, k);
        }
    }

    public static int getKMin(int[] num, int k)
    {
        if (num == null || num.length < k)
        {
            return Integer.MAX_VALUE;
        }

        return KMinPartition(num, 0, num.length - 1, k);
    }

    public static void main(String[] args)
    {
        int[] num = {1,5,2,6,8,0,6};
        int kMin = getKMin(num, 1);
        System.out.println(kMin);
    }

}
