package com.offer;

/**
 * 剑指offer 面试题40
 * 题目描述：一个整型数组里除了两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字，要求时间复杂度为O（n）,空间复杂度是O（1）
 *
 * 解题思路：如果只有一个数字出现了一次，那么可以利用异或的性质。任何一个数字异或它自己都等于0，
 * 也就是说，如果我们从头到尾依次异或数组中的每一个数字，那么最终出现的结果刚好是那个只出现了依次的数字，
 * 因为那些成对出现两次的数字全部在异或中抵消了。
 * 下面考虑有两个数字只出现一次的情况：我们可以把原数组分成两个数组，使得每个子数组包含一个只出现一次的数字，而其他数字都成对出现两次。
 * 如何将原数组分为上述的两个子数组呢？由于原数组中存在两个只出现一次的数字，那么原数组的异或结果肯定不为0。
 * 也就是说这个结果数字的二进制表示中至少有一位为1。我们在结果数字的二进制表示中右数第一个为1的位置，记为n位。然后按照每个数字的二进制表示的第n
 * 位是否为1将原数组分为两个数组，再对两个子数组分别进行异或运算，最终的两个结果就是出现一次的两个数字。
 */
public class NumbersApearOnce_40
{
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[])
    {
        if (array ==null || array.length < 2)
            return;

        int resultExclusiveOR = 0;  //任何数字异或0都等于其本身
        //得到原数组的异或结果
        for (int i : array)
            resultExclusiveOR ^= i;
        //确定n位
        int indexOf1 = findFirstBitIs1(resultExclusiveOR);

        //将原数组按照第n位是否为1分为两个数组，对两个数组分别从头到尾依次异或数组中的每一个数字
        //num1[0]保存第一个数组中只出现一次的数字，num2[0]保存第二个数组中只出现一次的数字，
        num1[0] = num2[0] = 0;
        for (int i : array)
        {
            if (isBit1(i, indexOf1))
                num1[0] ^= i;
            else
                num2[0] ^= i;
        }

    }

    /**
     * 在整数num的二进制表示中找到最右边是1的位。
     * @param num 传入整数
     * @return 找到的最右边是1的位
     */
    private static int findFirstBitIs1(int num)
    {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit < 8 * 4))
        {
            num = num >> 1;
            ++indexBit;
        }

        return indexBit;
    }

    /**
     * 判断在num的二进制表示中从右边数起的indexBit位是不是1
     * @param num 传入整数
     * @param indexBit 传入要判断的indexBit
     * @return num的二进制表示中从右边数起的indexBit位是不是1
     */
    private static boolean isBit1(int num, int indexBit)
    {
        num = num >> indexBit;
        return (num & 1) == 1;
    }
}
