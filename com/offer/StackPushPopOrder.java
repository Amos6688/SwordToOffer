package com.offer;

import java.util.Stack;

/**
 * 剑指offer 面试题22
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 解题思路：建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈。
 * 规律：如果下一个弹出的数字刚好是栈顶元素，则直接弹出。如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，
 * 直到把下一个需要弹出的数字压入栈顶为止。如果所有的数字豆芽如了栈任然没有找到下一个弹出的数字，
 * 那么该序列不可能是一个弹出序列。
 */
public class StackPushPopOrder
{
    public boolean IsPopOrder(int [] pushA,int [] popA)
    {
        boolean bPossible = false;

        int pushLength = pushA.length;
        int popLength = popA.length;
        int length;

        if(pushLength != popLength)
            return bPossible;
        else
            length = pushLength;

        if(pushA != null && popA != null && length > 0)
        {
            int nextPushIndex = 0;
            int nextPopIndex = 0;

            Stack<Integer> dataStack = new Stack<>();

            while(nextPopIndex - 0 < length)
            {
                while(dataStack.isEmpty() || dataStack.peek() != popA[nextPopIndex])
                {
                    if(nextPushIndex - 0 == length)
                        break;

                    dataStack.push(pushA[nextPushIndex]);
                    ++nextPushIndex;
                }

                //此处判断是为了防御当pushA所有数字都压入栈了，但是还没有找到下一个要弹出的数字
                if(dataStack.peek() != popA[nextPopIndex])
                        break;

                dataStack.pop();
                ++nextPopIndex;
            }

            if(dataStack.isEmpty() && nextPopIndex == length)
                bPossible = true;
        }
        return bPossible;
    }
}
