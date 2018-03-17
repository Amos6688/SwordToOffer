package com.offer;

/**
 * 剑指offer 面试题28 相关题目
 * 在8*8的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一条对角线上。
 * 问一共有多少种摆法？
 * 解题思路：由于8个皇后不能处在同一行，那么肯定是每个皇后占据一行，于是可以定义一个数组ColumnIndex[8],
 * 数组中第i个数字表示位于第i行皇后的列号。给数组赋初始值0~7，然后做全排列。最后只需判断每一个排列对应的
 * 8个皇后是否在同意对角线上
 */
public class QueenChess
{
    private int count = 0;
    public void QueeChessSolution(int[] columnIndex)
    {
        permutation(columnIndex, 0);
        System.out.println(count);
    }

    private void permutation(int[] columnIndex, int begin)
    {
        if (begin == columnIndex.length - 1)
        {
            if (!isSameDiagonal(columnIndex))
                ++ count;
        }
        else
        {
            for (int i = begin; i < columnIndex.length; i++)
            {
                int temp = columnIndex[i];
                columnIndex[i] = columnIndex[begin];
                columnIndex[begin] = temp;

                permutation(columnIndex, begin + 1);

                temp = columnIndex[i];
                columnIndex[i] = columnIndex[begin];
                columnIndex[begin] = temp;
            }
        }
    }

    //判断是否有至少两个元素在同对角线上
    private boolean isSameDiagonal(int[] array)
    {
        boolean isSameDiagonal = false;
        for (int i = 0; i < array.length; ++i)
            for (int j = i + 1; j < array.length; ++j)
            {
                if (i - j == array[i] - array[j] || j - i == array[i] - array[j])
                {
                    isSameDiagonal = true;
                }
            }
        return  isSameDiagonal;
    }


    public static void main(String[] args)
    {
        QueenChess queenChess = new QueenChess();
        int[] columnIndex = {0, 1, 2, 3, 4, 5, 6, 7};
        queenChess.QueeChessSolution(columnIndex);
    }

}
