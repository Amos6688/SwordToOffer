package com.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指offer 面试题五
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead
{
    //基于循环实现
    public ArrayList<Integer> printListFromTailToHeadp(ListNode listNode)
    {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null)
        {
            //压栈操作
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty())
        {
            list.add(stack.pop());
        }

        return list;
    }

    //基于递归实现
    ArrayList<Integer> list = new ArrayList<Integer>(); //ArrayList必须放在方法外面定义，不然每次递归都会新生成一个list
    public ArrayList<Integer> printListFromTailToHeadp2(ListNode listNode)
    {
        if (listNode != null)
        {
            if (listNode.next != null)
            {
                printListFromTailToHeadp2(listNode.next);
            }

            list.add(listNode.val);
        }

        return list;
    }

}


/**
 * 自定义链表结构
 */
class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
        this.val = val;
    }
}

