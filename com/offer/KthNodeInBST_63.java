package com.offer;

/**
 * 剑指offer ，面试题63
 *
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k大的结点。
 *
 * 解题思路：如果按照中序遍历的顺序遍历一棵二叉搜索树，遍历序列的数值是递增排序的。
 * 只需要用中序遍历算法遍历一棵二叉搜索树，就很容易找出它的第k大结点。
 */
public class KthNodeInBST_63
{
    private TreeNode target = null;

    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 1) {
            return null;
        }

        int[] tmp = {k}; //Java中基本数据类型没有引用一说，所以采用数组来保存
        return kthNodeCore(pRoot, tmp);
    }

    private  TreeNode kthNodeCore(TreeNode root, int[] k)
    {
        // 先成左子树中找
        if (root.left != null) {
            target =  kthNodeCore(root.left, k);
        }

        // 如果在左子树中没有找到
        if (target == null) {
            // 说明当前的根结点是所要找的结点
            if(k[0] == 1) {
                target = root;
            } else {
                // 当前的根结点不是要找的结点，但是已经找过了，所以计数器减一
                k[0]--;
            }
        }

        // 根结点以及根结点的左子树都没有找到，则找其右子树
        if (target == null && root.right != null) {
            target = kthNodeCore(root.right, k);
        }

        return target;
    }

    /**
     * 解法二
     */
    int index = 0; //计数器
    TreeNode KthNode2(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

}
