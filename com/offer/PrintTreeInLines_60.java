package com.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer 面试题60
 *
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 解题思路：可以用一个队列来保存要打印的结点。为了把二叉树的每一行单独打印到一行里，
 * 需要两个变量，一个变量表示当前层中还没有打印的结点数，另一个变量表示下一层的结点数目。
 */
public class PrintTreeInLines_60
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(pRoot);
        int nextLevel = 0;  //下一层的结点数目
        int toBePrint = 1;  //当前层中还没有打印的结点数，
        while (!nodes.isEmpty())
        {
            TreeNode pNode = nodes.getFirst();
            list.add(pNode.val);

            if (pNode.left != null)
            {
                nodes.add(pNode.left);
                ++nextLevel;
            }
            if (pNode.right != null)
            {
                nodes.add(pNode.right);
                ++nextLevel;
            }

            nodes.remove();
            --toBePrint;

            if (toBePrint == 0)
            {
                result.add(new ArrayList<>(list));  //此处直接add(list)无法成功
                list.clear();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }
}
