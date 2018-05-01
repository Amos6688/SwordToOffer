package com.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 剑指offer 面试题65
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *
 * 解题思路：
 */
public class MaxInSlidingWindow_65
{

    /******************************************************************
     *两端开口队列法
     *滑动窗口的最大值总是保存在队列首部，队列里面的数据总是从大到小排列。
     * @param num 数组
     * @param size 串口大小
     * @return 所有滑动窗口里数值的最大值
     ***************************************************************/
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size > num.length || size <= 0)
            return result;

        Deque<Integer> deque = new LinkedList<>();  //定义一个两端开口的队列
        for (int i = 0; i < num.length; ++i)
        {

            if (!deque.isEmpty())
            {
                //如果队头元素不在滑动窗口了，就删除头元素
                if (i >= deque.peek() + size)
                    deque.pop();

                //如果当前数字大于队列尾部元素，则删除尾部元素，直到当前数字小于队列尾，或者队列尾空
                while (!deque.isEmpty() && num[i] >= num[deque.getLast()])
                    deque.removeLast();
            }

            deque.offer(i); //入队列，入的是数组的的下标

            //当滑动窗口经过一个窗口大小时，保存当前的最大值，也就是队列头部的元素
            if (i + 1 >= size)
                result.add(num[deque.peek()]);
        }

        return result;

    }


    /******************************************************************
     *最大堆方法
     *构建一个窗口size大小的最大堆，每次从堆中取出窗口的最大值，随着窗口往右滑动，需要将堆中不属于窗口的堆顶元素删除。
     * @param num 数组
     * @param size 串口大小
     * @return 所有滑动窗口里数值的最大值
     ***************************************************************/
    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || size >= num.length || size <= 0)
            return result;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; ++i)
            maxHeap.add(num[i]);
        result.add(maxHeap.peek());
        for (int i = 1; i < num.length - size + 1; ++i)
        {
            maxHeap.remove(num[i - 1]);
            maxHeap.add(num[i + size - 1]);
            result.add(maxHeap.peek());
        }

        return result;
    }

}
