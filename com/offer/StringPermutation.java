package com.offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 剑指offer 面试题28
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class StringPermutation
{
    ArrayList<String> result = new ArrayList<String>();
    TreeSet<String> set = new TreeSet<String>();

    public ArrayList<String> Permutation(String str)
    {
        if(str == null)
            return result;
        char[] chs = str.toCharArray();
        permutaitionCore(chs, 0);

        result.addAll(set);
        return result;
    }

    private void permutaitionCore(char[] chs, int begin)
    {
        if(begin == chs.length - 1)
            set.add(String.valueOf(chs));
        else
        {
            for(int i = begin; i < chs.length; ++i)
            {
                //第一步，将第一项与其他项互换位置
                char temp = chs[i];
                chs[i] = chs[begin];
                chs[begin] = temp;

                //做一次排列
                permutaitionCore(chs, begin + 1);

                //恢复原位置，为下一次排列做准备
                temp = chs[i];
                chs[i] = chs[begin];
                chs[begin] = temp;
            }
        }
    }
}
