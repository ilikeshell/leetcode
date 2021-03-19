public class Solution62
{
    public int uniquePaths(int m, int n)
    {
        /** 开数组 */
        int[][] dp = new int[m][n];
        /** 行 */
        for (int i = 0; i < m; i++)
            /** 列 */
            for (int j = 0; j < n; j++)
            {
                /** 先处理边界情况，否则会报错 */
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    /**           上方            左边  */
                    dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        return dp[m-1][n-1];
    }
}
