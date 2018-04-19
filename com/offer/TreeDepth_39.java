package com.offer;

/**
 * 剑指offer 面试题39
 * 输入一棵二叉树的根节点，求该二叉树的深度
 * 解题思路： 二叉树的深度等于其根节点左右子树深度的较大值加1,利用递归求解
 *
 * @author chuan
 */
public class TreeDepth_39
{
    public int TreeDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        int nLeft = TreeDepth(root.left);
        int nRigth = TreeDepth(root.right);

        return (nLeft > nRigth) ? (nLeft + 1) : (nRigth + 1);
    }
}
