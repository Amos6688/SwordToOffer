package com.offer;

/**
 * 剑指offer 面试题52
 * 题目描述：给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * 解题思路：B[i]的值可以看作的矩阵中每行的乘积，每行从左到右分别为A0~An-1,处于对角线的数字全为1，。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去
 */
public class ArrayConstruction_52
{
    public int[] multiply(int[] A)
    {
        int length = A.length;
        int[] B = new int[length];

        if (length > 0)
        {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; ++i)
                B[i] = B[i - 1] * A[i - 1];

            int temp = 1;
            //计算上三角连乘
            for (int i = length - 2;  i >=0; --i)
            {   temp *= A[i + 1];
                B[i] *= temp;
            }
        }

        return B;
    }
}
