package com.structureAlgorithm;

/**
 * 基于链表实现栈，及其基本操作
 *
 * @author Chuan
 */

public class Stack<E>
{
    class Node<E>
    {
        E data;
        Node<E> next = null;

        public Node(E data)
        {
            this.data = data;
        }
    }

    Node<E> top = null; //指向栈顶元素

    //判断栈是否为空
    public boolean isEmpty()
    {
        return top == null;
    }

    //将新元素入栈
    public void push(E data)
    {
        Node<E> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    //出栈
    public E pop()
    {
        if (isEmpty())
        {
            return null;
        }

        E data = top.data;
        top = top.next;
        return data;
    }

    //得到栈顶元素
    public E peek()
    {
        if (isEmpty())
        {
            return null;
        }

        return top.data;
    }

}
