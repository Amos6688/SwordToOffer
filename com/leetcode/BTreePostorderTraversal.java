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
    private ArrayList<Integer> list = new ArrayList<>();

    //基于循环实现二叉树的先序遍历
    public ArrayList<Integer> preOrderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode curNode = stack.pop();
            result.add(curNode.val);

            if (curNode.right != null)
            {
                stack.push(curNode.right);
            }
            if (curNode.left != null)
            {
                stack.push(curNode.left);
            }
        }

        return result;
    }

    //基于递归实现先序遍历
    public ArrayList<Integer> preOrderTraversal2(TreeNode root)
    {
        if (root != null)
        {
            list.add(root.val);
            preOrderTraversal2(root.left);
            preOrderTraversal2(root.right);
        }

        return list;
    }



    //基于循环实现二叉树的中序遍历
    public ArrayList<Integer> inOrderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode node = root;
        if (node == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty())
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

    //基于递归实现中序遍历
    public ArrayList<Integer> inOrderTraversal2(TreeNode root)
    {
        if (root != null)
        {
            inOrderTraversal2(root.left);
            list.add(root.val);
            inOrderTraversal2(root.right);
        }

        return list;
    }


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

    //基于递归实现后序遍历
    public ArrayList<Integer> postorderTraversal2(TreeNode root)
    {
        if (root != null)
        {
            postorderTraversal2(root.left);
            postorderTraversal2(root.right);
            list.add(root.val);
        }

        return list;
    }


}
