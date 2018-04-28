package com.offer;

/**
 * 剑指offer 面试题51
 * 题目描述：在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的。
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次，请找出数组中任意一个重复的数字。
 *
 *解题思路：从头到尾扫描这个数组中的每个数字。当扫描到下标为i的数字m时，比较m是否等于i，
 * 如果等于，接着扫描下一个数字。如果不是，再拿m 和下标为m 的数字比较。如果相等，
 * 找到了一个重复的数字；如果不相等就把第i个个数字和下标为m的数字交换位置，把m放到它属于的位置。
 * 接下来再重复这个比较，交换的过程，直到我们发现这个重复的数字。
 */
public class DuplicationInArray_51
{
    /**
     * @param numbers 传入的数组
     * @param length 数组的长度
     * @param duplication 该数组的第一个元素用来保存找到的重复数字
     * @return 是否找到重复的数字
     */
    public boolean duplicate(int numbers[],int length,int [] duplication)
    {
        if (numbers == null || length <= 0)
            return false;

        //遍历一遍数组，查看是否有不符合要求的元素.即小于0或者大于length - 1
        for (int i = 0; i < length; ++i )
        {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
        }

        for (int i = 0; i < length; ++i)
        {
            while (numbers[i] != i)
            {
                if (numbers[i] == numbers[numbers[i]])
                {
                    duplication[0] = numbers[i];
                    return true;
                }

                //交换numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i]= numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }

        return false;
    }
}
