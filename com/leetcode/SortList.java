package com.leetcode;


/**
 * 题目描述：Sort a linked list in O(n log n) time using constant space complexity.
 *解题思路：使用o(nlogn)的时间复杂度和常量空间复杂度，对链表排序，只能使用归并排序。归并排序是将两个或两个以上的有序链表合并成一个新的链表。常见的是二路归并排序算法，
 * 思想是将数组或链表中前后相邻的两个有序序列归并为一个有序序列，时间复杂度为o(nlogn)，需要等数量的辅助空间
 * @author Chuan
 */
public class SortList
{
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        //通过快慢指针将链表分为两段
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        fast = sortList(head);
        slow = sortList(slow);
        return mergeList(fast, slow);
    }

    private ListNode mergeList(ListNode sub1, ListNode sub2)
    {
        if (sub1 == null)
        {
            return  sub2;
        }
        if (sub2 == null)
        {
            return sub2;
        }

        ListNode head = null;
        if (sub1.val < sub2.val)
        {
            head = sub1;
            sub1 = sub1.next;
        }
        else
        {
            head = sub2;
            sub2 = sub2.next;
        }

        ListNode p = head;
        while (sub1 != null && sub2 != null)
        {
            if (sub1.val < sub2.val)
            {
                p.next = sub1;
                sub1 = sub1.next;
            }
            else
            {
                p.next = sub2;
                sub2 = sub2.next;
            }
            p = p.next;
        }

        if (sub1 != null)
        {
            p.next = sub1;
        }
        if (sub2 != null)
        {
            p.next = sub2;
        }

        return head;
    }
}


//Definition for singly-linked list.
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

