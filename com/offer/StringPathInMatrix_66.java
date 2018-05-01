package com.offer;

/**
 * 剑指offer 面试题66
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class StringPathInMatrix_66
{
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //输入参数校验
        if (matrix == null || matrix.length != rows * cols || rows < 1 || cols < 1 || str == null)
            return false;
        //初始化变量
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; ++i)
            visited[i] = false;

        //记录已经处理的str中字符的个数
        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int row = 0; row < rows; ++row)
        {
            for (int col = 0; col < cols; ++col)
            {
                if (hasPathCore(matrix, rows, cols, visited, row, col, str , pathLength))
                {
                    return true;
                }
            }
        }
        return false;
    }


    //判断是否存在路径的核心算法
    /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     */
    private boolean hasPathCore(char[] matrix, int rows, int cols, boolean[] visited,
                                int row, int col, char[] str, int[] pathLength)
    {
        if (pathLength[0] == str.length)
            return true;

        boolean hasPath = false;
        //判断位置是否合法
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col])
        {
            ++pathLength[0];
            visited[row * cols + col] = true;

            //按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, visited, row, col - 1, str , pathLength)
                    || hasPathCore(matrix, rows, cols, visited, row - 1, col, str , pathLength)
                    || hasPathCore(matrix, rows, cols, visited, row , col + 1, str , pathLength)
                    || hasPathCore(matrix, rows, cols, visited, row + 1, col, str , pathLength);

            //如果当前位置的上下左右都不是下一个字符，则回退一个字符。
            if (!hasPath)
            {
                --pathLength[0];
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }

}
