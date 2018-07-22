package com.sort;

/**
 * 堆排序
 * 基本思想：将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。
 * 将其与堆数组的末尾元素交换，此时末尾就是最大值。然后将剩余的n-1个元素重新狗仔成一个大顶堆，
 * 这样就会得到n个元素中的次最大值。如此反复执行，直到堆中只剩一个元素，就能得到一个有序序列了
 * @author Chuan
 */
public class HeapSort
{
    /**
     *
     * @param num 需要排序的数组
     * @param pos 需要构建堆的根节点的序号
     * @param len 数组的长度
     */
    public static void adjustMaxHeap(int[] num, int pos, int len)
    {
        int child;
        int father;
        for (father = num[pos]; 2 * pos + 1 < len; pos = child)
        {
            child = 2 * pos + 1;    //左子节点下标位置
            if (child < len - 1 && num[child] < num[child + 1])
            {
                child++;
            }
            if (num[child] > father)
            {
                num[pos] = num[child];
            }
            else
            {
                break;
            }
        }
        num[pos] = father;
    }

    public static void hearSort(int[] num)
    {
        int len = num.length;
        int i, temp;
        //从下往上调整
        for (i = len / 2; i >= 0; --i)
        {
            adjustMaxHeap(num, i, len);
        }

        for (i = len - 1; i >= 0; --i)
        {
            temp = num[0];
            num[0] = num[i];
            num[i] = temp;
            adjustMaxHeap(num, 0, i);
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        hearSort(a);
        for (int i : a)
        {
            System.out.println(i);
        }
    }
}
