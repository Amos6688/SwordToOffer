package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer 面试题35
 *需要注意的是如果输入空字符串需要返回-1
 * @author chuan
 */
public class FirstNotRepeatingChar_35
{
    public int FirstNotRepeatingChar(String str)
    {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); ++i)
        {
            char ch = str.charAt(i);
            if (map.containsKey(ch))
            {
                int times = map.get(ch);
                map.put(ch, times);
            }
            else
            {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < str.length(); ++i)
        {
            if (map.get(str.charAt(i)) == 1)
            {
                return i;
            }

        }
        return -1;
    }
}
