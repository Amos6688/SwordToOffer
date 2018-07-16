package com.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 *题目描述：Given a binary tree, return the postorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author Chuan
 */
public class BTreePostorderTraversal
{
    public ArrayList<Integer> postorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode temp = stack.peek();   //得到栈顶元素，并不弹出
            if (temp.left == null && temp.right == null)
            {
                TreeNode node = stack.pop();
                result.add(node.val);
            }
            else
            {
                if (temp.right != null)
                {
                    stack.push(temp.right);
                    temp.right = null;
                }
                if (temp.left != null)
                {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return result;
    }
}
