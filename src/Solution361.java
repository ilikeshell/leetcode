public class Solution361
{
    /** 计算错误 */
    public int maxKilledEnemies1(char[][] grid)
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] upAndLeft = new int[m][n];
        int[][] downAndRight = new int[m][n];


        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                //如果是墙
                if(grid[i][j] == 'W')
                {
                    upAndLeft[i][j] = 0;
                    continue;
                }

                upAndLeft[i][j] = grid[i][j] == 'E' ? 1 : 0;

                if(i > 0)
                    upAndLeft[i][j] += upAndLeft[i - 1][j];

                if(j > 0)
                    upAndLeft[i][j] += upAndLeft[i][j - 1];
            }

        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
            {
                //如果是墙
                if(grid[i][j] == 'W')
                {
                    downAndRight[i][j] = 0;
                    continue;
                }

                downAndRight[i][j] = grid[i][j] == 'E' ? 1 : 0;

                if(i < m - 1)
                    downAndRight[i][j] += downAndRight[i + 1][j];

                if(j < n - 1)
                    downAndRight[i][j] += downAndRight[i][j + 1];
            }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                if(grid[i][j] == '0')
                    res = Math.max(res, upAndLeft[i][j] + downAndRight[i][j]);
            };

        return res;
    }

    /** 计算正确 */
    public int maxKilledEnemies(char[][] grid)
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        int res = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                //如果是墙
                if(grid[i][j] == 'W')
                {
                    up[i][j] = 0;
                    continue;
                }

                up[i][j] = grid[i][j] == 'E' ? 1 : 0;

                if(i > 0)
                    up[i][j] += up[i - 1][j];
            }

        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j <= n - 1; j++)
            {
                //如果是墙
                if(grid[i][j] == 'W')
                {
                    down[i][j] = 0;
                    continue;
                }

                down[i][j] = grid[i][j] == 'E' ? 1 : 0;

                if(i < m - 1)
                    down[i][j] += down[i + 1][j];

            }

        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
            {
                //如果是墙
                if(grid[i][j] == 'W')
                {
                    right[i][j] = 0;
                    continue;
                }

                right[i][j] = grid[i][j] == 'E' ? 1 : 0;

                if(j > 0)
                    right[i][j] += right[i][j - 1];
            }

        for (int j = n - 1; j >= 0; j--)
            for (int i = 0; i < m; i++)
            {
                //如果是墙
                if(grid[i][j] == 'W')
                {
                    left[i][j] = 0;
                    continue;
                }

                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if(j < n - 1)
                    left[i][j] += left[i][j + 1];
            };

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if(grid[i][j] == '0')
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);

        return res;
    }
}
