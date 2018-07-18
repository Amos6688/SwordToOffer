package com.offer;

/**
 * 剑指offer 面试题6
 */
public class ConstructBinaryTree
{

    public TreeNode reConstructBinaryTree(int[] pre,int[] in)
    {
        TreeNode root = constructCore(pre, in, 0, pre.length - 1 , 0, in.length - 1);
        return root;
    }

    private TreeNode constructCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd)
    {
        //递归停止条件
        if (preStart > preEnd || inStart > inEnd)
            return null;

        //前序遍历的第一个数字是根节点的值
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = root.right = null;

        //再中序遍历中找到根节点
        for (int i = inStart; i <= inEnd; i++)
        {
           if (in[i] == root.val)
           {
               //注意下标的确定    
               root.left = constructCore(pre, in, preStart + 1, preStart + (i - inStart), inStart, i - 1);
               root.right = constructCore(pre, in, preStart + (i - inStart) + 1, preEnd, i + 1, inEnd);
           }
        }

        return root;
    }
}

/**
 * 自定义一个二叉树结构
 */
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
    }
}