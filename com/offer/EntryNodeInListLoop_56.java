package com.offer;

/**
 * 剑指offer 面试题56
 * 题目描述：一个链表中包含环，请找出该链表的环的入口结点。
 *
 * 解题思路：先定义两个指针p1和p2指向链表头结点。如果链表中的环有n个结点，指针p1现在链表上向前移动n步，
 * 然后两个指针以相同的速度向前移动。当第二个指针指向环的入口结点时，第一个指针已经围绕着环走了一圈回到了入口节点。
 *
 * 然后就是需要求出环中结点的个数。利用快慢指针先找到环中的一个结点，然后很容易就求出结点的个数
 */
public class EntryNodeInListLoop_56
{

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        //先找到环中的一个节点
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null)
            return null;

        //得到环中节点的个数
        int nodeInloop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode)
        {
            pNode1 = pNode1.next;
            ++nodeInloop;
        }

        //移动pNode1
        pNode1 = pHead;
        for (int i = 0; i < nodeInloop; ++i)
            pNode1 = pNode1.next;

        //同时移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2)
        {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }
    /**
     * 找到一快一慢两个指针相遇的节点
     * 思想：定义两个指针，P1指向头结点，P2指向头结点的下一个结点。P1走一步，P2走两步。
     * 如果P2能追上P1说明链表存在环，否则不存在。
     * @param pHead 存在环的链表
     * @return 返回一快一慢指针相遇的节点
     */
    private ListNode meetingNode(ListNode pHead)
    {
        if (pHead == null)
            return null;

        ListNode pSlow = pHead;
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null)
        {
            if (pFast == pSlow)
                return pFast;
            //慢指针走一步
            pSlow = pSlow.next;

            //快指针走两步
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
        }

        return null;
    }


}
