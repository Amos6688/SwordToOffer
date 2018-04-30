package com.offer;

/**
 * 剑指offer 面试题59
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 解题思路：通过比较二叉树的前序遍历和对称的前序遍历来判断二叉树是不是对称的。
 * 如果两个序列是一样的，那么二叉树是对称的。
 * 注意的是，需要将遇到的null指针也考虑进来，放置二叉树数字全一样的情况。
 */
public class SymmetricalBinaryTree_59
{
    public boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2)
    {
        if (pRoot1 == null && pRoot2 == null)
            return true;

        if (pRoot1 == null || pRoot2 == null)
            return false;

        if (pRoot1.val != pRoot2.val)
            return false;

        return isSymmetrical(pRoot1.left, pRoot2.right)
                && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
