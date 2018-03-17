package com.offer;

/**
 * 剑指offer 面试题4
 */
public class ReplaceBlank
{

    public static void main(String[] args)
    {
        ReplaceBlank replaceBlank = new ReplaceBlank();
        String str = replaceBlank.replaceSpace(new StringBuffer("Hello World"));

        System.out.println(str);
    }

    //思路：从字符串后面向前替换
    public String replaceSpace(StringBuffer str)
    {
        if (str == null)
            return null ;

        //统计字符串中空格的总数
        int blankNum = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                blankNum++;

        //oldTail指针指向原始字符串的末尾
        int oldTail = str.length() - 1 ;
        //newTail指向替换之后的字符串的末尾，替换以后的字符串长度等于空格数的2倍加上原字符串的长度
        int newTail = 2 * blankNum + str.length() - 1;

        // 设置字符串最后的长度，注意字符串的长度比最大下标多1
        str.setLength(newTail + 1);

        //oldTail和newTail指向同一位置，表明所有空格已经替换完
        while(newTail > oldTail)
        {
            if (str.charAt(oldTail) != ' ')
            {
                str.setCharAt(newTail--, str.charAt(oldTail));
            }
            else
            {
                str.setCharAt(newTail--, '0');
                str.setCharAt(newTail--, '2');
                str.setCharAt(newTail--, '%');
            }

            oldTail--;
        }

        return str.toString();
    }
}
