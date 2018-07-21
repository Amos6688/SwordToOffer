package com.structureAlgorithm;

/**
 * 包含min函数的栈，min函数的时间复杂度为O（1）
 *
 * @author Chuan
 */
public class MinInStack
{
    Stack<Integer> data;
    Stack<Integer> min;

    public MinInStack()
    {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int i)
    {
        data.push(i);
        if (min.isEmpty() || i < min.peek())
        {
            min.push(i);
        }
        else
        {
            min.push(min.peek());
        }
    }

    public int pop()
    {
        int top = Integer.MIN_VALUE;
        if (!data.isEmpty() && !min.isEmpty())
        {
            top = data.pop();
            min.pop();
        }
        return top;
    }

    public int min()
    {
        if (min.isEmpty())
        {
            return Integer.MAX_VALUE;
        }
        return min.peek();
    }

}
