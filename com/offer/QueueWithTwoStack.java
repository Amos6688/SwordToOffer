package com.offer;

import java.util.Stack;

/**
 * 剑指offer 面试题7
 */
public class QueueWithTwoStack
{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node)
    {
        stack1.push(node);
    }

    /**
     * 当stack2不为空时，stack2的栈顶元素就是最先进入队列的元素，可以弹出。
     * 如果stack2为空，就把stack1中的元素逐个弹出压入stack2。
     * @return
     * @throws Exception
     */
    public int pop() throws Exception
    {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                int data = stack1.pop();
                stack2.push(data);
            }
        }

        if (stack2.isEmpty())
        {
            throw new Exception("queue is empty");
        }

        int head = stack2.pop();

        return head;

    }
}
