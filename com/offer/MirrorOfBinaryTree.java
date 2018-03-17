package com.offer;

import java.util.Stack;

/**
 * 剑指offer 面试题19
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorOfBinaryTree
{
    /**
     * 递归实现
     * @param root
     */
    public void Mirror(TreeNode root)
    {
        if(root == null)
            return;
        //递归种子条件，交换完所有非叶子节点的左右子节点之后
        if(root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

    /**
     * 循环实现
     * @param root
     */
    public void Mirror2(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null || node.right != null) {
                TreeNode nodeLeft = node.left;
                TreeNode nodeRight = node.right;
                node.left = nodeRight;
                node.right = nodeLeft;
            }
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
    }
}
