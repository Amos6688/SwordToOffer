package com.offer;

/**
 * 剑指offer 面试题45
 * 题目描述：约瑟夫环问题。0,1,2,...,n-1个数字排成一个圆圈，从数字0，开始每次从这个圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字
 *
 * 解题思路：方法一，利用循环链表；方法二
 */
public class LastNumberInCircle_45
{
    /************************************************************************
     * 解法1：利用循环链表。
     * @param n n个数字
     * @param m 每次删除第m个数字
     * @return 最后剩下的数字
     **********************************************************************/
    public int LastRemaining_Solution(int n, int m)
    {
        if (n < 1 || m <1)
            return -1;

       CircleNode head = new CircleNode(0);
       CircleNode tail = head;
       for (int i = 1; i < n; ++i)
           tail = (tail.next = new CircleNode(i));

       //形成循环链表
       tail.next = head;
       while (tail != tail.next)
       {
           for (int i = 1; i < m; ++i)
               tail = tail.next;
           //此时tail 是要出列节点的前一个节点
           tail.next = tail.next.next;
       }

        return tail.value;
    }


    /********************************************************************************
     * 解法2：创新的解法，试着找到每次被删除的数字有哪些规律
     ******************************************************************************/
    public int LastRemaining_Solution2(int n, int m)
    {
        if(n < 1 || m < 1)
            return -1;

        int last = 0;
        for (int i = 2; i <= n; ++i)
            last = (last + m) % i;

        return last;
    }

}

class CircleNode
{
    int value;
    CircleNode next;

    public CircleNode(int value)
    {
        this.value = value;
    }
}
