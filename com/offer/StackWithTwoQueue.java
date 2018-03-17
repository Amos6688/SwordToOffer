package com.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer 面试题7相关题目
 * 用两个队列实现一个栈
 */
public class StackWithTwoQueue
{
    //Java中Queue是一个接口，LinkedList实现了这个接口，因此LinkedList可以当做Queue使用
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    //压栈操作
    public void push(int node)
    {
        //无论何时两个队列一定是一个为空，一个非空。只要queue2为空，就把数据插入queue1，否则插入queue2
        if (queue2.isEmpty())
            queue1.add(node);
        else
            queue2.add(node);
    }

    //出栈操作
    public int pop()
    {
        int stackSize = queue1.size() + queue2.size();
        int tail = 0;
        /**
         * 无论何时两个队列一定是一个为空，一个非空。
         * 弹出栈顶元素的时候，需从非空队列弹出stackSize - 1个元素放置空队列中
         */
        if ( stackSize > 0)
        {
            if (!queue1.isEmpty())
            {
                move();
                tail = queue1.poll();
            }
            else if (!queue2.isEmpty())
            {
                move();
                tail = queue2.poll();
            }

            return tail;
        }

        else
        {
            System.out.println("栈已为空！！！！！");
            return -1;
        }


    }

    private void move()
    {
        if (!queue2.isEmpty())
        {
            while (queue2.size() - 1 > 0)
                queue1.add(queue2.poll());
        }
        else if (!queue1.isEmpty())
        {
            while (queue1.size() - 1 > 0)
                queue2.add(queue1.poll());
        }
    }


    public static void main(String[] args)
    {
        StackWithTwoQueue stack=new StackWithTwoQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
