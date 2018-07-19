package com.leetcode;

/**
 * 题目描述：Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 *
 * 解题思路：第一步利用快慢指针将链表分为两段；第二步将后半段翻转；第三步合并两段链表
 * @author Chuan
 */
public class ReorderList
{
    public static void main(String[] args)
    {
        ListNode ln1 =new ListNode(1);
        ListNode ln2 =new ListNode(2);
        ListNode ln3 =new ListNode(3);
        ListNode ln4 =new ListNode(4);
        ListNode ln5 =new ListNode(5);
        ListNode ln6 =new ListNode(6);
        ListNode ln7 =new ListNode(7);
        ListNode ln8 =new ListNode(8);
        ListNode ln9 =new ListNode(9);
        ListNode ln10 =new ListNode(10);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = ln9;
        ln9.next = ln10;

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(ln1);
        while (ln1 != null){
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }

    }

    public void reorderList(ListNode head)
    {
        if (head == null)
        {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        second = reverseList(second);

        mergeList(head, second);
    }

    //头插法翻转链表
    private ListNode reverseList(ListNode head)
    {
        ListNode curNode = head;
        ListNode pre = null ;
        ListNode next;
        while (curNode != null)
        {
            next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }

        return pre;
    }

    //合并两个链表
    private void mergeList(ListNode first, ListNode second)
    {
        ListNode curNode = second;
        ListNode temp;
        while (curNode != null)
        {
            temp = curNode;
            curNode = curNode.next;
            temp.next = first.next;
            first.next = temp;
            first = first.next.next;
        }
    }
}
