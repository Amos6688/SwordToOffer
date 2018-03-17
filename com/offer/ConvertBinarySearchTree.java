package com.offer;

/**
 * 剑指offer 面试题27
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBinarySearchTree
{

    //注意此处一定要把lastNodeInList定义为类的成员变量，否则每次递归返回后又变为原来的值
    private TreeNode lastNodeInList = null;

    public TreeNode Convert(TreeNode pRootOfTree)
    {

        convertNode(pRootOfTree);

        //lastNodeInList指向双向链表的尾节点
        //需要返回头结点
        TreeNode headOfList = lastNodeInList;
        while(headOfList != null && headOfList.left != null)
            headOfList = headOfList.left;

        return headOfList;
    }

    private void convertNode(TreeNode node)
    {
        if(node == null)
            return;

        TreeNode currentNode = node;

        if(currentNode.left != null)
            convertNode(currentNode.left);

        currentNode.left = lastNodeInList;
        if(lastNodeInList != null)
            lastNodeInList.right = currentNode;

        lastNodeInList = currentNode;

        if(currentNode.right != null)
            convertNode(currentNode.right);
    }


    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;

        node1.right = node5;
        node5.left = node6;
        node5.right = node7;

        ConvertBinarySearchTree convertBinarySearchTree =  new ConvertBinarySearchTree();
        convertBinarySearchTree.Convert(node1);



    }
}
