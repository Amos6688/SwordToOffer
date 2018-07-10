package com.leetcode;


import java.util.Stack;

/**
 * 题目描述：Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 *   解决思路：我们每次碰到数字的时候就将它压入栈中，碰到计算符号时就将栈顶的两个元素弹出来参与计算，
 *   并将计算后的结果放到栈里面。
 * @author Chuan
 */
public class EvaluateReversePolishNotation
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens)
        {
            if (str.equals("+"))
            {
                stack.push(stack.pop() + stack.pop());
            }
            else if (str.equals("-"))
            {
                int second = stack.pop();
                stack.push(stack.pop() - second);
            }
            else if (str.equals("*"))
            {
                stack.push(stack.pop() * stack.pop());
            }
            else if (str.equals("/"))
            {
                int second = stack.pop();
                stack.push(stack.pop() / second);
            }
            else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
