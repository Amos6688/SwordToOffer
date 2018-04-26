package com.offer;

/**
 * 剑指offer 面试题43
 * 题目描述：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出所有可能的值出现的概率。
 *
 * 下面用两种方法解答，第一种基于递归（会有许多重复计算，时间效率会比较低），第二种基于循环
 */
public class DicesProbability_43
{
    private final int MAX_VALUE = 6;

    /***************************************************************************************
     * 第一种解法利用递归
     * 解题思路：想要求n个骰子的点数和，可以先把骰子分为两堆：第一堆只有一个，另一堆有n-1个。单独的那个骰子有可能出现
     * 1~6 的点数。我们需要计算从1~6 的每一种点数和剩下的n - 1 个骰子来计算点数和。接下来把剩下的n - 1个骰子还是分
     * 为两堆，第一堆只有一个，第二堆有你-2 个。我们把上一轮那个单独骰子的点数和这一轮单独骰子的点数相加，再和剩下的
     * n - 2 个骰子来计算点数和。分析到这里，我们发现这是一种基于递归的思路，递归结束条件是只剩下最后一个骰子。
     * 我们定义一个长度为6n - n + 1 的数组，和为s的点出现的次数保存在 s - n 位置
     * @param number 骰子的个数
     ***************************************************************************************/
    public void printProbability(int number)
    {
        if (number < 1)
            return;

        int maxSum = number * MAX_VALUE;
        //定义一个长度为6n - n + 1 的数组，和为s的点出现的次数保存在 s - n 位置
        int[] probabilities = new int[maxSum - number + 1];

        probability(number, probabilities);
        //n个骰子的所有点数的排列数为6的n次方
        double total = Math.pow((double)MAX_VALUE, number);
        for (int i = number; i <= maxSum; ++i)
        {
            double ratio = (double)probabilities[i - number] / total;
            System.out.printf("%d: %.5f\n", i, ratio);
        }

    }

    /**
     * @param number 骰子个数
     * @param probabilities 该数组用来保存每个点数和出现次数
     */
    private void probability(int number, int[] probabilities)
    {
        for (int i = 1; i <= MAX_VALUE; ++i)
        {
            probability(number, number, i, probabilities);
        }
    }

    /**
     *
     * @param original  原始骰子个数
     * @param current 当前骰子个数
     * @param sum 当前和
     * @param probabilities 该数组用来保存每个点数和出现次数
     */
    private void probability(int original, int current, int sum, int[] probabilities)
    {
        if (current == 1)
        {
            ++probabilities[sum - original];
        }
        else
        {
            for (int i = 1; i <= MAX_VALUE; ++i)
            {
                probability(original, current - 1, i + sum, probabilities);
            }
        }
    }


    /**************************************************************************************
     * 方法二：基于循环求骰子点数，时间性能好
     * 解题思路：我们可以考虑用两个数组来存储骰子点数的每一个总数出现的次数。在一次循环中，第一个数组中的第n个数字表示是骰子和为n出现的次数。
     * 在下一次循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一次循环中骰子和为n-1， n-2， n-3, n-4, n-5 与n-6的次数的总和。
     * 所以我们把另一个数组的第n个数字设为前一个数组对应的第n-1， n-2， n-3, n-4, n-5 与n-6之和。我们通过改变变量flag来交换两个数组
     **************************************************************************************/
    public void printProbability2(int number)
    {
        if (number < 1)
            return;

        int[][] probabilities = new int[2][];
        probabilities[0] = new int[MAX_VALUE * number + 1];
        probabilities[1] = new int[MAX_VALUE * number + 1];

        int flag = 0;
        for (int i = 1; i <= MAX_VALUE; ++i)
            probabilities[flag][i] = 1;

        for (int k = 2; k <= number; ++k)
        {
            for (int i = 0; i < k; ++i)
                probabilities[1 - flag][i] = 0;

            for (int i = k; i <= MAX_VALUE * k; ++i)
            {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j < i && j < MAX_VALUE; ++j)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }

            flag = 1 - flag;
        }

        //n个骰子的所有点数的排列数为6的n次方
        double total = Math.pow((double)MAX_VALUE, number);
        for (int i = number; i <= MAX_VALUE * number; ++i)
        {
            double ratio = (double)probabilities[flag][i] / total;
            System.out.printf("%d: %.5f\n", i, ratio);
        }

    }


}
