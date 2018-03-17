package com.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 剑指offer 面试题28扩展
 * 输入一个字符串,按字典序打印出该字符串中字符的所有组合。
 * 解题思想：把n个字符分成两部分，第一个字符和其他的所有字符。如果组合里包含第一个字符，则下一步再剩余的n-1个字符里选取m-1个字符。
 * 如果组合里不包含第一个字符，则下一步在剩余的n-1个字符里选取m个字符。其中m为组合元素的个数
 */
public class StringCombination
{
    ArrayList<String> result = new ArrayList<>();
    TreeSet<String> set = new TreeSet<>();

    public ArrayList<String> Combination(String str)
    {
        if (str == null)
            return result;

        StringBuilder sb = new StringBuilder();
        int length = str.length();

        for (int i = 0; i < length; ++i)
            combinationCore(str, 0, i, sb);

        result.addAll(set);
        return result;
    }

    private void combinationCore(String str, int index, int number, StringBuilder sb)
    {
        //当组合的最后一位填好，表示一个组合已生成
        if (number == -1)
        {
            set.add(String.valueOf(sb));
            return;
        }

        if (index == str.length())
            return;

        sb.append(str.charAt(index));
        combinationCore(str, index + 1, number - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        combinationCore(str, index + 1, number, sb);
    }

    public static void main(String[] args)
    {
        StringCombination sc = new StringCombination();
        sc.Combination("aba");
        for (Iterator<String> iterator = sc.result.iterator(); iterator.hasNext();)
            System.out.println(iterator.next());
    }
}
