package com.offer;

/**
 * 对某个公司的几万名员工的年龄进行排序，要求时间效率为O（n），可以借助辅助空间
 */
public class SortAges
{
    public void SortAges(int[] ages, int length) throws Exception
    {
        //判断输入参数是否合法
        if (ages == null || length < 0)
            return;

        //假定公司的年龄范围为0~99
        final int oldestAge = 99;
        //定义100个辅助空间
        int[] ageTimes= new int[oldestAge + 1];

        //遍历一遍数组，统计每个年龄出现的次数
        for (int i = 0; i < length; i++)
        {
            int age = ages[i];
            if (age < 0 || age > oldestAge)
                throw new Exception("age out of range!!!!");
            ageTimes[age]++;
        }

        //按从小到大的顺序对ages数组中的元素进行排序
        int index = 0;
        for (int i= 0; i < oldestAge; i++)
        {
            for (int j = 0; j < ageTimes[i]; j++)
            {
                ages[index] = i;
                index++;
            }
        }
    }
}
