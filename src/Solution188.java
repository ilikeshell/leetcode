class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0)
            return 0;

        int i, j;

        if(k > n / 2)
        {
            //best time to buy and sell stock II
            //buy and sell any time
            int sum = 0;
            for(i = 0; i < n - 1; ++i)
            {
                if(prices[i + 1] > prices[i])
                    sum += prices[i + 1] - prices[i];
            }
            return sum;
        }

        int[][] f = new int[n + 1][2 * k + 2];


        /** 初始化 */
        f[0][1] = 0;  //第0天处于第一阶段，获利为0
        //第0天不可能处于第二到第五阶段，设为负无穷
        for (i = 2; i <= 2 * k + 1; ++i)
            f[0][i] = Integer.MIN_VALUE;

        for (i = 1; i <= n; i++)
        {
            //Phase 1,3,5...2k+1
            for(j = 1; j <= 2 * k + 1; j += 2)
            {
                f[i][j] = f[i - 1][j];
                if(j > 1 && i >= 2 && f[i - 1][j - 1] != Integer.MIN_VALUE)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
            }

            //Phase 2,4,...2k
            for(j = 2; j <= 2 * k; j += 2)
            {
                f[i][j] = f[i - 1][j - 1];
                if(i >= 2 && f[i - 1][j] != Integer.MIN_VALUE)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
            }
        }

        int res = Integer.MIN_VALUE;
        for(i = 1; i <= 2 * k + 1; i += 2)
            res = Math.max(res, f[n][i]);

        return res;
    }
}