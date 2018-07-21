package com.structureAlgorithm;

import java.util.Arrays;

/**
 * 基于数组实现栈，斌实现基本的操作
 * @author Chuan
 */
public class MyStack<E>
{
    private Object[] stack;
    private int size;   //数组中存储元素个数

    public MyStack()
    {
        stack = new Object[10]; //初始长度为10
    }

    //判断堆栈是否为空
    public boolean isEmpty()
    {
        return size == 0;
    }

    //获取栈顶元素
    public E peek()
    {
        if (isEmpty())
        {
            return null;
        }
        return (E) stack[size - 1];
    }

    //弹出栈顶元素
    public E pop()
    {
        E e = peek();
        stack[size - 1] = null;
        --size;
        return e;
    }

    //将元素压栈
    public E push(E item)
    {
        ensureCapacity(size + 1);
        stack[size++] = item;
        return item;
    }

    //判断数组是否已满，若已满，则扩充数组空间
    public  void ensureCapacity(int size)
    {
        int len = stack.length;
        if (size > len)
        {
            int newLen = 10; //每次数组扩充的容量
            stack = Arrays.copyOf(stack, len + newLen);
        }
    }

    public static void main(String[] args)
    {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        System.out.println("栈中的元素个数：" + stack.size);
        System.out.println("栈顶元素为：" + stack.pop());
        System.out.println("栈顶元素为：" + stack.pop());

    }
}
