class Solution63
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        /** 验证输入的合法性，行和列不能为0 */
        int m = obstacleGrid.length;
        if(m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if(n == 0)
            return 0;

        /** 如果入口有障碍，直接返回 */
        if(obstacleGrid[0][0] == 1)
            return 0;

        /** 定义状态数组 */
        int[][] f = new int[m][n];
        /** 设置初值，但在此处设置会被后面覆盖 */
        //f[0][0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                /** 如果此处有障碍直接置零，然后计算下一个 */
                if(obstacleGrid[i][j] == 1)
                {
                    f[i][j] = 0;
                    continue;
                }

                /** 初值 */
                if(i == 0 && j == 0)
                {
                    f[i][j] = 1;
                    continue;
                }

                /** 注意此处的技巧，把第0行和第0列与其他位置统一处理了
                 *
                 *  f[i][j] == f[i - 1][j] + f[i][j - 1];
                 *
                 * */
                f[i][j] = 0;
                if(i > 0)
                    f[i][j] += f[i - 1][j];
                if(j > 0)
                    f[i][j] += f[i][j - 1];
            }

        return f[m-1][n-1];
    }
}