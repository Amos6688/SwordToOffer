package com.structureAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Node
{
    int data;
    Node next = null;

    public Node(int data)
    {
        this.data = data;
    }
}

/**
 * 自定义链表，并实现基本操作
 * @author Chuan
 */
public class MyLinkedList
{
    Node head = null;   //链表头的引用

    /**
     * 向链表中插入数据
     * @param d：插入数据的内容
     */
    public void addNode(int d)
    {
        Node newNode = new Node(d);
        if (head == null)
        {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        //将新节点插入链表尾部
        temp.next = newNode;
    }

    /**
     *
     * @param index：删除第index个节点
     * @return 成功返回true，失败返回false
     */
    public boolean deleteNode(int index)
    {
        //删除节点的位置不合理
        if (index < 1 || index > length())
        {
            return false;
        }

        //删除链表的第一个元素
        if (index == 1)
        {
            head = head.next;
            return true;
        }

        int i = 2;
        Node preNode = head;
        Node curNode = head.next;
        while (curNode != null)
        {
            if (i == index)
            {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            ++i;
        }

        return true;
    }

    /**
     *
     * @return 返回链表的长度
     */
    public int length()
    {
        int length = 0;
        Node temp = head;
        while (temp != null)
        {
            ++length;
            temp = temp.next;
        }

        return length;
    }

    /**
     * 对链表进行排序
     * @return 返回排序后的头结点
     */
    public Node orderList()
    {
        Node nextNode = null;
        int temp =0;
        Node curNode = head;
        while (curNode.next != null)
        {
            nextNode = curNode.next;
            while (nextNode != null)
            {
                if (curNode.data > nextNode.data)
                {
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }

        return head;
    }

    /**
     * 从头到尾打印链表
     */
    public void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 从链表中删除重复元素
     * 借助HashMap，使用了额外的辅助空间，降低了时间复杂度
     */
    public void deleteDuplicate()
    {
        Map<Integer, Integer> map = new HashMap<>();
        Node temp = head;
        Node pre = null;

        while (temp != null)
        {
            if (map.containsKey(temp.data))
            {
                pre.next = temp.next;
            }
            else
            {
                map.put(temp.data, 1);
                pre = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 从链表中删除重复元素
     * 借助HashMap，使用双重循环遍历链表，时间复杂度较高，但没有使用额外的辅助空间
     */
    public void deleteDuplicate2()
    {
        Node curNode = head;
        Node temp = null;
        while (curNode != null)
        {
            temp = curNode;
            while (temp.next != null)
            {
                if (temp.next.data == curNode.data)
                {
                    curNode.next = temp.next.next;
                }
                else
                {
                    temp = temp.next;
                }
            }
            curNode = curNode.next;
        }
    }

    /**
     * 在单链表中查找倒数第k个元素
     * 思想：设置两个指针，让其中以这个指针比另一个指针先迁移k-1步，然后两个指针在同时往前移动。
     * 循环直到先行的指针为null时，拎一个指针指向的位置就是所要找的节点
     * @param k 需要查找的位置
     * @return 查找到的节点
     */
    public Node findElem(int k)
    {
        if (k < 1)
        {
            return null;
        }

        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k - 1 && fast != null; ++i)
        {
            fast = fast.next;
        }

        if (fast == null)
        {
            System.out.println("k不合法！！！");
            return null;
        }

        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     *从味道通输出链表
     * 思想：输出当前结点之前，先输出其下一节点。利用递归实现
     * @param head 传入链表的头结点
     */
    public static void printListReversely(Node head)
    {
        if (head != null)
        {
            printListReversely(head.next);
            System.out.println(head.data);
        }
    }

    /**
     * 寻找单链表的中间节点
     * 思想：利用快慢指针。快指针一次走两步，慢指针一次走一步。当快指针走到链表尾节点时，
     * 慢指针指向的就是中间节点
     * @param head 传入链表的头结点
     * @return 返回找到的中间节点
     */
    public static Node searchMid(Node head)
    {
        if (head == null)
        {
            return null;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     * 判断一个链表是否有环
     * 思想，利用快慢指针，fast和slow初始都指向head。fast每次走两步，slow每次走一步，
     * 快指针每走一次都要和慢指针比较，如果相等则说明带环。否则，没有环。
     * @param head 传入链表的头结点
     * @return 如果单链表中存在环，返回true，否则，返回false
     */
    public static boolean isLoop(Node head)
    {
        if (head == null)
        {
            return false;
        }

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                return true;
            }
        }

        return !(fast == null || fast.next == null);
    }


    /**
     * 在不知道头结点的情况下删除指定节点
     * @param node 要删除的指定节点
     * @return 删除成功返回true，失败返回false
     */
    public static boolean deleteNode(Node node)
    {
        //当要删除的节点为空返回false
        //当要删除的节点为尾节点也返回false，因为无法使其前驱节点的next指针为空
        if (node == null || node.next == null)
        {
            return false;
        }

        //若待删除的节点不是尾节点，则可以通过交换这个节点与其后继节点的值，然后删除其后继节点
        int temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
        node.next = node.next.next;
        return true;
    }


    /**
     * 解题思路：如果两个链表相交，那么一定有共同的尾节点
     * @param h1 链表一
     * @param h2 连表二
     * @return 如果两个链表有交点，返回true，否则返回false
     */
    public static boolean isIntersect(Node h1, Node h2)
    {
        if (h1 == null || h2 == null)
        {
            return false;
        }

        Node tail1 = h1;
        while (tail1.next != null)
        {
            tail1 = tail1.next;
        }

        Node tail2 = h2;
        while (tail2.next != null)
        {
            tail2 = tail2.next;
        }

        return tail1 == tail2;
    }

    /**
     * 找到两个链表相交的第一个节点
     * @param h1 链表一
     * @param h2 链表二
     * @return 返回两个链表相交的第一个节点
     */
    public static Node getFirstMeetNode(Node h1, Node h2)
    {

        if (h1 == null || h2 == null)
        {
            return null;
        }

        Node tail1 = h1;
        int len1 = 1;
        while (tail1.next != null)
        {
            tail1 = tail1.next;
            ++len1;
        }

        Node tail2 = h2;
        int len2 = 1;
        while (tail2.next != null)
        {
            tail2 = tail2.next;
            ++len2;
        }
        //如果两个链表不相交，返回null
        if (tail1 != tail2)
        {
            return null;
        }

        Node t1 = h1;
        Node t2 = h2;
        //找出较长的链表先遍历
        if (len1 > len2)
        {
            int d = len1 - len2;
            while (d != 0)
            {
                t1 = t1.next;
                --d;
            }
        }
        else
        {
            int d = len2 - len1;
            while (d != 0)
            {
                t2 = t2.next;
                --d;
            }
        }

        while (t1 != t2)
        {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public static void main(String[] args)
    {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addNode(5);
        linkedList.addNode(3);
        linkedList.addNode(1);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(6);
        linkedList.findElem(2);
        System.out.println("listLen=" + linkedList.length());
        System.out.println("before order:");
        linkedList.printList();
        linkedList.orderList();
        System.out.println("after order:");
        linkedList.printList();
        linkedList.deleteDuplicate2();
        System.out.println("after deleteDuplicate:");
        linkedList.printList();
        System.out.println("after printListReversely");
        printListReversely(linkedList.head);
        System.out.println("list's mid num is :" +  searchMid(linkedList.head).data);
    }
}
