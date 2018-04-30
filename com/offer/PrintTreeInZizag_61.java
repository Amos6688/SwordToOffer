package com.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指offer 面试题61
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解题思路：按之字形顺序打印二叉树需要两栈。在打印某一行结点时，把下一层的子节点保存到相应哦栈里。
 * 如果当前打印的的是奇数层，则先保存左子节点在保存右子结点。如果当前打印的是偶数层，则先保存右子结点，再保存左子节点。
 */
public class PrintTreeInZizag_61
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> level1 = new Stack<>();
        Stack<TreeNode> level2 = new Stack<>();

        level1.push(pRoot);
        while (!level1.isEmpty() || !level2.isEmpty())
        {
            if (!level1.isEmpty())
            {
                while (!level1.isEmpty())
                {
                    TreeNode pNode = level1.pop();
                    list.add(pNode.val);

                    if (pNode.left != null)
                        level2.push(pNode.left);
                    if (pNode.right != null)
                        level2.push((pNode.right));
                }
                result.add(new ArrayList<>(list));
                list.clear();

            }
            if (!level2.isEmpty())
            {
                while (!level2.isEmpty())
                {
                    TreeNode pNode = level2.pop();
                    list.add(pNode.val);

                    if (pNode.right != null)
                        level1.push(pNode.right);
                    if (pNode.left != null)
                        level1.push(pNode.left);
                }
                result.add(new ArrayList<>(list));
                list.clear();
            }

        }
        return result;
    }
}
