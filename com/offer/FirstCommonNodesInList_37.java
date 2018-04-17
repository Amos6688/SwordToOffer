package com.offer;

/**
 * 剑指offer 面试题37
 * 题目描述：输入两个单向链表，找出他们的第一个公共节点
 *
 * @author chuan
 */
public class FirstCommonNodesInList_37
{
    /**
     * 解题思路：经分析发现，如果两个链表有公共节点，那么公共节点出现在两个链表的尾部（后半部分），所以借助可以用两个辅助栈。
     * 但是这种算法不是最优的，因为牺牲了空间来换取时间效率。
     * 之所以用到栈，是因为我们想同时遍历到达两个栈的尾节点。当两个链表的长度不一致时，如果我们从头开始到达尾节点的时间就不一致。
     * 解决办法是首先遍历两个链表得到他们的长度，就知道哪个链表比较长，以及长链表比短链表多几个节点。在第二次便利的时候，在较长的链表上先走若干步，
     * 接着再同时在两个链表上遍历，找到的第一个相同的节点就是他们的第一个公共节点。
     * @param pHead1 第一个链表头结点
     * @param pHead2 第二个链表头结点
     * @return 第一个公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        //得到两个链表的长度
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);

        int lengthDif  = length1 - length2;
        ListNode listHeadLong = pHead1;
        ListNode listHeadShort = pHead2;

        if (lengthDif < 0)
        {
            listHeadLong = pHead2;
            listHeadShort = pHead1;
            lengthDif = -lengthDif;
        }

        //先在长链表上走几步，再同时在两个链表上遍历
        for (int i = 0; i < lengthDif; ++i)
        {
            listHeadLong = listHeadLong.next;
        }

        while (listHeadLong != null && listHeadShort != null
                && (listHeadLong != listHeadShort))
        {
            listHeadLong = listHeadLong.next;
            listHeadShort = listHeadShort.next;
        }

        //得到第一个公共节点
        ListNode firstConmmonNode = listHeadLong;

        return firstConmmonNode;
    }

    private int getListLength(ListNode head)
    {
        int length = 0;
        ListNode node = head;
        while (node != null)
        {
            ++length;
            node = node.next;
        }

        return length;
    }
}
