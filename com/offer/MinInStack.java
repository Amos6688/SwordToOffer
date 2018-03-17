package com.offer;

import java.util.Stack;

/**
 * 剑指offer 面试题21
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 解题思想：把每次的最小元素（之前的最小元素和新入栈的元素，两者的最小值）
 * 都保存起来放到另外一个辅助栈中。每次数据栈出栈的时候，辅助栈也跟着出栈，
 * 这样最小值永远是辅助栈的栈顶元素
 */
public class MinInStack
{
    Stack<Integer> data = new Stack<Integer>();    //数据栈
    Stack<Integer> min = new Stack<Integer>();    //辅助栈

    public void push(int node)
    {
        data.push(node);
        if(min.isEmpty() || node < min.peek())
            min.push(node);
        else
            min.push(min.peek());
    }

    public void pop()
    {
        if(!data.isEmpty() && !min.isEmpty())
        {
            data.pop();
            min.pop();
        }
    }

    public int top()
    {
        if(!data.isEmpty())
            return data.peek();
        else
            return -1; //此处当栈为空时，返回-1.不是很合适
    }

    public int min()
    {
        if(!data.isEmpty() && !min.isEmpty())
        {
            return min.peek();
        }
        else return -1;
    }
}
