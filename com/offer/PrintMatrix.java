package com.offer;

import java.util.ArrayList;

/**
 * 剑指offer 面试题20
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class PrintMatrix
{
    public ArrayList<Integer> printMatrix(int [][] matrix)
    {
        int rows = matrix.length;
        int colums = matrix[0].length;
        if (matrix == null || colums <= 0 || rows <= 0)
            return null;

        ArrayList<Integer> result = new ArrayList<Integer>();
        int start = 0;
        while(colums > start * 2 && rows > start * 2)
        {
            printMatrixInCircle(matrix, colums, rows, start, result);
            ++start;
        }
        return result;
    }

    public ArrayList<Integer> printMatrixInCircle(int [][] matrix, int colums,
                                                  int rows, int start, ArrayList<Integer> result)
    {
        int endX = colums - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行，必须有的
        for(int i = start; i <= endX; ++i)
        {
            int number = matrix[start][i];
            result.add(number);
        }

        //从上到下打印一列，如果只有一行，则不需要，故需要判断
        if(start < endY)
        {
            for(int i = start + 1; i <= endY; ++i)
            {
                int number = matrix[i][endX];
                result.add(number);
            }
        }

        //从右到左打印一行，如果只有一行或者只有一列 ，则不需要，故需要判断
        if(start < endX && start < endY)
        {
            for(int i = endX - 1; i >= start; --i)
            {
                int number = matrix[endY][i];
                result.add(number);
            }
        }

        //从下到上打印一列，如果只有两行或者只有一列，则不需要
        if(start < endX && start < endY - 1)
        {
            for(int i = endY - 1; i >= start + 1; --i)
            {
                int number = matrix[i][start];
                result.add(number);
            }
        }

        return result;
    }
}
