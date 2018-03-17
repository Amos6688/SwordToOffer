package com.offer;

/**
 * 剑指offer 面试题3
 */
public class FindInPartiallySortedMatrix
{
    public boolean find(int[][] matrix, int number)
    {
        int row = 0;
        int colum = matrix[0].length - 1;

        //从矩阵右上角开始遍历
        while (row < matrix.length && colum >= 0)
        {
            if (matrix[row][colum] == number)
                return true;
            else if (matrix[row][colum] > number)
                colum--;
            else
                row++;
        }
        return false;
    }

}
