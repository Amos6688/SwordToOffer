package com.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer 面试题23
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解题思想：每次打印一个节点的的时候，如果该节点有子节点（条件），则把该节点的子节点放到一个队列的末尾。
 * 接下来从队列的头部取出最早进入队列的节点。重复前面的操作，直至队列中所有的节点都被打印出来为止
 */
public class TreeValFomTopToBottom
{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        //定义一个数组链表，存放结果
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        //定义一个队列
        LinkedList<TreeNode> queueTreeNode = new LinkedList<>();

        queueTreeNode.add(root);
        while(!queueTreeNode.isEmpty())
        {
            TreeNode front = queueTreeNode.poll();
            result.add(front.val);

            if(front.left != null)
                queueTreeNode.add(front.left);
            if(front.right != null)
                queueTreeNode.add(front.right);
        }

        return result;
    }
}
