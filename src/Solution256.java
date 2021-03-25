//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷
//完所有房子最少的花费成本。
//
// 注意：
//
// 所有花费均为正整数。
//
// 示例：
//
// 输入: [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
//
// Related Topics 动态规划
// 👍 101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * "序列 + 状态"的动态规划，注意状态转移方程
 */
class Solution256
{
    public int minCost(int[][] costs)
    {
        int m = costs.length;
        int n = costs[0].length;

        if(m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m][n];
        /** 初始化，本题不用考虑边界 */
        for (int i = 0; i < n; i++)
            dp[0][i] = costs[0][i];

        for (int i = 1; i < m; i++)
        {
            dp[i][0] = Math.min(dp[i-1][1] + costs[i][0], dp[i-1][2] + costs[i][0]);
            dp[i][1] = Math.min(dp[i-1][0] + costs[i][1], dp[i-1][2] + costs[i][1]);
            dp[i][2] = Math.min(dp[i-1][1] + costs[i][2], dp[i-1][0] + costs[i][2]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            min = Math.min(dp[m - 1][i], min);

        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
