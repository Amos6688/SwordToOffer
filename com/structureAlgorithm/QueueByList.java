package com.structureAlgorithm;

import java.util.LinkedList;

/**
 *基于数组（List）实现队列，及其基本操作
 * @author Chuan
 */
public class QueueByList<E>
{
    private LinkedList<E> list = new LinkedList<>();
    private int  size = 0;

    public void put(E e)
    {
        list.add(e);
        size++;
    }

    public E pop()
    {
        if (isEmpty())
        {
            return null;
        }
        size--;
        return list.removeFirst();
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

}
