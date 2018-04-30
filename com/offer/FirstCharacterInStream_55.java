package com.offer;



/**
 * 剑指offer面试题55
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 解题思路：定义一个容器来保存字符在字符流中的位置，当一个字符第一次从字符流中读出来时，把它在字符流中的位置保存到数据容器里。
 * 当这个字符再次字符流中被读出来时，那么它就不是只出现一次的字符，也就可以被忽略了。这时把它在数据容器里的位置的值更新为一个特殊的值（比如负值）。
 * <p>
 * 为了尽可能高效地解决这个问题，需要在O（1）时间内往数据容器里插入一个字符，以及更新一个字符对应的值。可以用字符的ASCII码作为哈希表的键值，
 * 而把字符在字符流中对应的位置作为哈希表的值
 */
public class FirstCharacterInStream_55
{
    private int[] occurrence = new int[256];
    private int index = 1;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (ch > 255) {
            throw new IllegalArgumentException(ch + "must be a ASCII char");
        }
        //ch只出现了一次
        if (occurrence[ch] == 0)
            occurrence[ch] = index;
            //ch出现了多次
        else
            occurrence[ch] = -1;

        ++index;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = '#';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; ++i) {
            if (occurrence[i] > 0 && occurrence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurrence[i];
            }
        }

        return ch;
    }
}
