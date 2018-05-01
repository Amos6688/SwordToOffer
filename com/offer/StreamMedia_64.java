package com.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指offer 面试题54
 * 题目描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 *解题思路：如果有一个数据容器可以使左边的数据都小于右边的数据，这样即使左右两边内部的数据没有排序，
 * 也可以根据左边最大的数及右边最小的数得到中位数。
 * 用两个堆，一个大根堆和一个小根堆来解决。大根堆实现左边的数据容器，小根堆实现右边的数据容器。
 */
public class StreamMedia_64
{
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num)
    {
        /**
         * 在数据总数目是偶数时把新数据插入到小根堆中。但是在此之前要将系元素插入到大根堆，
         * 接着把大根堆中最大的数字拿出来插入到小根堆中
         */
        if (count % 2  == 0)
        {
            maxHeap.add(num);
            Integer maxNum = maxHeap.poll();
            minHeap.add(maxNum);
        }
        /**
         * 在数据总数目是奇数时把新数据插入到大根堆中。但是在此之前要将系元素插入到小根堆，
         * 接着把小根堆中最小的数字拿出来插入到大根堆中
         */
        else {
            minHeap.add(num);
            Integer minNum = minHeap.poll();
            maxHeap.add(minNum);
        }

        ++count;
    }

    public Double GetMedian()
    {
        if (count % 2 == 0)
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        else
            return (double)(minHeap.peek());
    }
}
