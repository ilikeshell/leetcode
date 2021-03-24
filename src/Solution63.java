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

    /** 另一种写法，速度更快，可读性更好 */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        //获取网格的长宽
        int n = obstacleGrid.length,m = obstacleGrid[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        //对于左边界，第一个障碍物或边界前的所有边界点皆可到达
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++){
                if (i==0 && j==0) {
                    continue;
                }
                //若遇到障碍物，则跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                //对于上边界，第一个障碍物或边界左边的所有边界点皆可到达
                if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                //对于左边界，第一个障碍物或边界前的所有边界点皆可到达
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                //到达当前点的路径数等于能到达此点上面的点和左边点的路径数之和
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}