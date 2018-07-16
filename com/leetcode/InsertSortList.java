package com.leetcode;

/**
 * Sort a linked list using insertion sort.
 *
 * @author Chuan
 */
public class InsertSortList
{
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null)
        {
            return null;
        }

        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;

        while (cur != null)
        {
            ListNode next = cur.next;   //保存下一个结点
            pre = helper;
            //将当前结点插入排好序链表的合适位置
            while (pre.next != null && pre.next.val <= cur.val)
            {
                pre = pre.next;
            }
            cur.next = null;
            pre.next = cur;

            //继续下一节点
            cur = next;
        }

        return helper.next;
    }
}