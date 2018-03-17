package com.offer;

/**
 * j剑指offer 面试题17
 * 输入一个链表，反转链表后，输出链表的头结点
 */
public class ReverseList
{
    public ListNode reverseList(ListNode head)
    {
        ListNode reverseHead = null;    //反转后的头结点
        ListNode node = head;    //当前节点
        ListNode preNode = null;    //前一个节点

        while(node != null)
        {
            ListNode nextNode = node.next;    //当前节点的下一个节点

            if(nextNode == null)    //找到尾节点，即反转后的头结点
                reverseHead = node;

            //反转指针
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }

        return reverseHead;

    }
}
