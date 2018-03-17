package com.offer;

/**
 * 剑指offer 面试题24
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 */
public class SequenceOfBST
{
    public boolean VerifySquenceOfBST(int [] sequence)
    {
        //注意sequence == null 与 sequence.length == 0 不等价
        if(sequence == null || sequence.length == 0)
            return false;
        return verifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    public boolean verifySquenceOfBSTCore(int[] sequence, int start, int end)
    {
        //切记设置递归的终止条件：end <= start
        //即当传入的序列长度为1时，停止。说明已经是二叉搜索树了
        if(end <= start)
            return true;

        int root = sequence[end];

        //在二叉搜索树中左子树的节点小于根节点
        int i = start;
        for(; i < end; ++i)
        {
            if(sequence[i] > root)
                break;
        }

        //在二叉搜索树中右子树的节点大于根节点
        int j = i;
        for(; j < end; ++j)
        {
            if(sequence[j] < root)
                return false;
        }

        //判断左子树是不是二叉搜索树
        boolean left = true;
        if(i > 0)
            left = verifySquenceOfBSTCore(sequence, 0, i - 1);

        //判断右子树是不是二叉搜索树
        boolean right = true;
        if(i < end)
            right = verifySquenceOfBSTCore(sequence, i, end - 1);


        return (left && right);
    }
}
