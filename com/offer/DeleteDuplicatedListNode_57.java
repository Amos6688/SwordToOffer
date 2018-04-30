package com.offer;

/**
 * 剑指offer 面试题57
 *
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 *
 * 解题思路：遍历整个链表，如果当前结点（pNode）的值与下一个结点的值相同，那么她们就是重复的结点，都可以被删除。
 * 为了保证删除之后链表仍然是相连的而没有中间断开，需要把当前结点的前一个节点（pPreNode）与比pNode值要打的节点相连。
 * 要确保pPreNode始终与下一个没有重复的结点相连
 */

public class DeleteDuplicatedListNode_57
{
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;

        ListNode pPreNode = null;   //当前结点的前一个结点
        ListNode pNode = pHead;
        while (pNode != null)
        {
            ListNode pNext = pNode.next;    //当前结点的下一个结点
            boolean needDelete = false; //是否需要删除的标志位
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;

            if (!needDelete)    //没有重复
            {
                pPreNode = pNode;
                pNode = pNode.next;
            }
            else    //出现重复，执行删除操作
            {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == value)
                {
                    pNext = pToBeDel.next;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }

                if (pPreNode == null)   //头结点因重复被删除
                    pHead = pNext;
                else
                    pPreNode.next = pNext;

                pNode = pNext;
            }
        }

        return pHead;
    }
}
