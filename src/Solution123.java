//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
// 示例 1:
//
//
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
//
// 示例 2：
//
//
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//
//
// 示例 3：
//
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
//
// 示例 4：
//
//
//输入：prices = [1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105
//
// Related Topics 数组 动态规划
// 👍 755 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/** 123. 买卖股票的最佳时机 III */
class Solution123
{
    public int maxProfit(int[] prices)
    {
        int n = prices.length;
        if(n == 0)
            return 0;

        int[][] f = new int[n + 1][5 + 1];
        int i, j;

        /** 初始化 */
        f[0][1] = 0;  //第0天处于第一阶段，获利为0
        //第0天不可能处于第二到第五阶段，设为负无穷
        for (i = 2; i <= 5; ++i)
            f[0][i] = Integer.MIN_VALUE;

        for (i = 1; i <= n; i++)
        {
            //Phase 1,3,5
            for(j = 1; j <= 5; j += 2)
            {
                f[i][j] = f[i - 1][j];
                if(j > 1 && i >= 2 && f[i - 1][j - 1] != Integer.MIN_VALUE)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
            }

            //Phase 2,4
            for(j = 2; j <= 4; j += 2)
            {
                f[i][j] = f[i - 1][j - 1];
                if(i >= 2 && f[i - 1][j] != Integer.MIN_VALUE)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
            }
        }

        return Math.max(f[n][1], Math.max(f[n][3], f[n][5]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
