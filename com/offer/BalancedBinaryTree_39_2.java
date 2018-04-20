package com.offer;

/**
 * 剑指offer 面试题39第二题
 * 题目描述：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
 *
 * 解题思路：我们用后序遍历的方式遍历二叉树的每一个节点，在遍历到一个节点之前我们就已经
 * 遍历了它的左右子树（后续遍历可以保证每个节点只被访问一次）。只要在遍历没个节点的时候记录它的深度（
 * 某一节点的深度等于它到叶节点的路径的长度），这样就可以一边遍历一边判断每个节点是不是平衡的。
 */
public class BalancedBinaryTree_39_2
{
    private static boolean isBalanced = false;

    public boolean IsBalanced_Solution(TreeNode root)
    {
        isBalanced(root);
        return isBalanced;
    }

    private static int isBalanced(TreeNode root)
    {
        if (root == null)
            return 0;

        int nLeft = isBalanced(root.left);
        int nRight = isBalanced(root.right);

        if (Math.abs(nLeft - nRight) > 1)
            isBalanced = false;
        else
            isBalanced = true;

        //记录节点root的深度，等于左右子树较大深度加1
        return 1 + (nLeft > nRight ? nLeft : nRight);
    }
}
