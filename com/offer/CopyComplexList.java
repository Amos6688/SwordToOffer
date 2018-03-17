package com.offer;

/**
 * 剑指offer 面试题26
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 解题思想：分而治之
 */
public class CopyComplexList
{
    public RandomListNode Clone(RandomListNode pHead)
    {
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

    //第一步，根据原始链表的每个节点N创建对应N'。并把N'链接在N后面
    private void cloneNodes(RandomListNode head)
    {
        RandomListNode node = head;
        while(node != null)
        {
            RandomListNode cloned = new RandomListNode(0);
            cloned.label = node.label;
            cloned.next = node.next;
            cloned.random =  null;

            node.next = cloned;

            node = cloned.next;
        }
    }

    //第二步，设置赋值出来的节点random
    private void connectRandomNodes(RandomListNode head)
    {
        RandomListNode node = head;
        while(node != null)
        {
            RandomListNode cloned = node.next;
            if(node.random != null)
            {
                cloned.random = node.random.next;
            }

            node = cloned.next;
        }
    }

    //第三步，把这个长链表拆分成两个链表：
    //把奇数位置的节点用next链接起来就是原始链表
    //把偶数位置的节点用next链接起来就是复制出来的链表
    private RandomListNode reconnectNodes(RandomListNode head)
    {
        RandomListNode node = head;
        RandomListNode clonedHead = null;
        RandomListNode clonedNode = null;

        //初始化
        if(node != null)
        {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        //循环
        while(node != null)
        {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
