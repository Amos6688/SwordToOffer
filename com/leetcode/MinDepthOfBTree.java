package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root
 * node down to the nearest leaf node.
 * 解题思路：利用二叉树的层序遍历，直到找到一个叶节点为止
 * @author Chuan
 */
public class MinDepthOfBTree
{
    public int run(TreeNode root)
    {
        return levelTraverse(root);
    }

    public int levelTraverse(TreeNode root)
    {
        int depth = 0;

        if (root == null) {
            return 0;
        }
        //层序遍历时保存节点的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            depth++;
            for (int i = 0; i < len; ++i)
            {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null)
                {
                    return depth;
                }
                if (currentNode.left != null)
                {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null)
                {
                    queue.offer(currentNode.right);
                }
            }
        }
        return depth;
    }
}


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val = x;
    }
}