package com.offer;

/**
 * 剑指offer 面试题13
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 */
public class DeleteNodeInList
{

    public static void main(String[] args)
    {
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        head.next=second;
        second.next=third;
        DeleteNodeInList p13=new DeleteNodeInList();
        p13.deleteNode(head, third);
        System.out.println(head.next.val);
    }

    private void deleteNode(ListNode head, ListNode pToBeDeleted)
    {
        if (head == null || pToBeDeleted == null)
            return;
        //要删除的节点不是尾节点
        if (pToBeDeleted.next != null)
        {
            ListNode pNext = pToBeDeleted.next;
            pToBeDeleted.val = pNext.val;
            pToBeDeleted.next = pNext.next;
            pNext = null;
        }
        else
        {
            if (head == pToBeDeleted)
                head = null;
            else
            {
                ListNode pNext = head;
                while (pNext.next != pToBeDeleted)
                    pNext = pNext.next;
                pNext.next = null;
            }
        }
    }
}