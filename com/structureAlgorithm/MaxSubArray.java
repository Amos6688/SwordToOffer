package com.structureAlgorithm;

/**
 * 如何求最大子数组之和
 * @author Chuan
 */
public class MaxSubArray
{

    /**
     * “蛮力”法：找出所有子数组，然后求出子数组的和，在所有子数组的和中取最大值
     * 此方法的时间复杂度为O（n3），效率较低
     * @param num 传入待求最大子数组之和的原始数组
     * @return 返回找到的最大子数组之和
     */
    public static int maxSubArray(int[] num)
    {
        int len = num.length;
        int thisSum = 0, maxSum = 0, i, j, k;

        for (i = 0; i < len; ++i)
        {
            for (j = i; j < len; ++j)
            {
                thisSum = 0;
                for (k = i; k <= j; ++k)
                {
                    thisSum += num[k];
                }
                if (thisSum > maxSum)
                {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * 重复利用已经计算的子数组和
     * 例如sum[i,j] = sum[i, j-1] + num[j],采用这种方法可以省去计算sum[i,j-1]的时间，
     * 因此可以提高程序效率.此方法的时间复杂度是O（n2）
     * @param num
     * @return
     */
    public static int maxSubArray2(int[] num)
    {
        int len = num.length;
        int maxSum = Integer.MIN_VALUE, i, j, sum;

        for (i = 0; i < len; ++i)
        {
            sum = 0;
            for (j = i; j < len; ++j)
            {
                sum += num[j];
                if (sum > maxSum)
                {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    /**
     * 动态规划算法
     * 首先可以根据数组的最后一个元素num[n-1]与最大数组的关系分为以下3种情况：
     * 1）最大子数组包含nun[n-1],即以num[n-1]结尾
     * 2）num[n-1]单独构成最大数组
     * 3）最大子数组不包含nun[n-1]，那么求num[1,...,n-1]的最大子数组可以转化为求num[1,...,n-2]的最大子数组
     * 通过以上分析可以得出如下结论：假设已经计算出（num[0],...,num[i-1]）最大的一段数组和为All(i-1),同时也计算
     * （num[0],...,num[i-1]）中包含num[i-1]的最大一段数组和为End（i-1）,则可以得到如下关系
     * All[i-1] = max{num[i-1], End[i-1], All[i-2]}
     *
     * 这种方法的时间复杂度是O（n）,显然效率更高，但是由于在计算的过程中额外申请了两个数组空间，
     * 因此该算法的空间复杂度也为O（n）
     * @param
     * @return
     */
    public static int maxSubArray3(int[] num)
    {
        int len = num.length;
        int[] End = new int[len];
        int[] All = new int[len];
        End[0] = All[0] = num[0];

        for (int i = 1; i < len; ++i)
        {
            End[i] = max(End[i - 1] + num[i], num[i]);
            All[i] = max(End[i], All[i - 1]);
        }

        return All[len - 1];
    }

    /**
     * 此方法是对方法3的改进
     * 方法3中每次只用到End[i-1]和All[i-1],而不是整个数组中的值，因此可以定义两个变量来保存nd[i-1]和All[i-1]，
     * 并且反复利用，这样就可以在保证时间复杂度为O（n）的同时降低空间复杂度。
     *
     * @param num
     * @return
     */
    public static int maxSubArray4(int[] num)
    {
        int len = num.length;
        int nAll = num[0];
        int nEnd = num[0];

        for (int i = 1; i < len; ++i)
        {
            nEnd = max(nEnd + num[i], num[i]);
            nAll = max(nEnd, nAll);
        }

        return nAll;
    }

    /**
     * 方法5，可以记录最大和子数组的起始和终止位置
     * 基本思想：在方法3中，通过对公式 End[i] = max(End[i - 1] + num[i], num[i])的分析可以看出，
     * 当End[i - 1] < 0时，End[i] = num[i],其中End[i]表示包含num[i]的子数组和，如果某一个值使得
     * End[i - 1]<0,那么就从num[i]重新开始
     *
     * @param num
     * @return
     */
    private static int begin = 0; //记录最大子数组的起始位置
    private static int end = 0; //记录最大子数组的终止位置
    public static int maxSubArray5(int[] num)
    {
        int maxSum = Integer.MIN_VALUE; //子数组的最大值
        int nSum = 0;   //包含子数组最后一位的最大值
        int nStart = 0;

        for (int i = 0; i < num.length; ++i)
        {
            if (nSum < 0)
            {
                nSum = num[i];
                nStart = i;
            }
            else
            {
                nSum += num[i];
            }
            if (nSum > maxSum)
            {
                maxSum = nSum;
                begin = nStart;
                end = i;
            }
        }
        return maxSum;
    }



    private static int max(int m, int n)
    {
        return m > n ? m : n;
    }


    public static void main(String[] args)
    {
        int[] num = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println(maxSubArray(num));
        System.out.println(maxSubArray2(num));
        System.out.println(maxSubArray3(num));
        System.out.println(maxSubArray4(num));
        System.out.println("max=" + maxSubArray5(num));
        System.out.println("begin=" + begin +", end=" + end);

    }

}
