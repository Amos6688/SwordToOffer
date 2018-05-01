package com.offer;

/**
 * 剑指offer 面试题62
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 解题思路：如果二叉树的序列化是从根结点开始的话，那么相应的反序列化在根结点的数值读出来的时候就可以开始了。
 * 因此可以根据前序遍历的顺序来序列化二叉树，因为前序遍历是从根结点开始的。当在遍历二叉树碰到null指针时，
 * 将这些null指针序列化成一个特殊的字符（比如‘$’）。另外，结点的数值之间要用一个特殊字符（比如‘,’）隔开。
 */
public class SerializeBinaryTrees_62
{
    private int index = -1;

    public String Serialize(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return null;

        serializeCore(root, sb);
        return sb.toString();
    }

    //序列化核心函数
    private void serializeCore(TreeNode root, StringBuilder sb)
    {
        //递归终止条件
        if (root == null)
        {
            sb.append("$,");
            return ;
        }
        sb.append(root.val + ",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    public TreeNode Deserialize(String str)
    {
        if (str == null)
            return null;
        String[] nodes = str.split(",");

        return deserializeCore(nodes);
    }

    //反序列化核心函数
    private TreeNode deserializeCore(String[] nodes)
    {
        ++index;
        if (!nodes[index].equals("$"))
        {
            TreeNode pNode = new TreeNode(0);
            pNode.val = Integer.parseInt(nodes[index]);
            pNode.left = deserializeCore(nodes);
            pNode.right = deserializeCore(nodes);
            return pNode;
        }
            return null;
    }
}
