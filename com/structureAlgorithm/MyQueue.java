package com.structureAlgorithm;

/**
 * 基于链表实现队列，及其基本操作
 *
 * @author Chuan
 */
public class MyQueue<E>
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

    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty()
    {
        if (head == null && tail == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //入队操作
    public void put(E data)
    {
        Node<E> newNode = new Node<>(data);
        if (isEmpty())
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //出队操作
    public E pop()
    {
        if (isEmpty())
        {
            return null;
        }

        E data = head.data;
        head = head.next;
        return data;
    }

    //计算队列中元素的个数
    public int size()
    {
        Node<E> tmp = head;
        int n = 0;
        while (tmp != null)
        {
            ++n;
            tmp = tmp.next;
        }

        return n;
    }

    public static void main(String[] args)
    {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println("队列长度为：" + queue.size());
        System.out.println("队列首元素：" + queue.pop());
        System.out.println("队列首元素：" + queue.pop());
    }
}
