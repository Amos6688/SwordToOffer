package com.offer;

/**
 * 剑指offer 面试题58
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解题思路，分为三种情况：
 * 1、如果该结点有右子树，那么下一个结点就是它右子树的最左子结点；
 * 2、如果该节点没有右子树，且是父结点的左子树，那么下一个结点就是其父结点；
 * 3、如果该结点没有右子树，且是父结点的右子树，那么就要沿着其指向父结点的指针一直向上遍历，
 * 直到找到一个是他父结点的左子树的结点。如果存在这样的结点，那么该结点的父结点就是下一个结点
 */
public class NextNodeInBinaryTree_58
{
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        TreeLinkNode pNext = null;
        if (pNode.right != null)
        {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null)
                pRight = pRight.left;

            pNext = pRight;
        }
        else if (pNode.next != null)
        {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pCurrent == pParent.right)
            {
                pCurrent = pParent;
                pParent = pParent.next;
            }

            pNext = pParent;
        }

        return pNext;
    }
}

class TreeLinkNode
{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}