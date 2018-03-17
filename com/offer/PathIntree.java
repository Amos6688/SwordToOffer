package com.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer 面试题25
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathIntree
{
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;
        LinkedList<TreeNode> path = new LinkedList<>();
        int currentSum = 0;
        findPathCore(root, target, path, currentSum, result);

        return result;
    }

    private void findPathCore
            (TreeNode root,
             int target,
             LinkedList<TreeNode> path,
             int currentSum,
             ArrayList<ArrayList<Integer>> result
            )
    {
        currentSum += root.val;
        path.push(root);

        //如果是也叶子节点，并且路径上的节点的和等于输入的值
        //保存这条路径
        boolean isLeaf = root.left == null && root.right == null;
        if(currentSum == target && isLeaf)
        {
            ArrayList<Integer> onePath = new ArrayList<>();
            int size = path.size();
            for(int i = size - 1; i >= 0; --i)
            {
                TreeNode node = path.get(i);
                onePath.add(node.val);
            }
            result.add(onePath);
        }

        //如果不是叶子节点，则遍历他的子节点
        if(root.left != null)
            findPathCore(root.left, target, path, currentSum, result);
        if(root.right != null)
            findPathCore(root.right, target, path, currentSum, result);

        //再返回到父节点之前，在路径上删除当前节点
        path.pop();
    }

}


/**
 * 超简洁解法
 */
class Solution2 {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}