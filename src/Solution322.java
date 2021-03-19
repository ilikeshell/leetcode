import java.util.Arrays;

public class Solution322
{
    public static void main(String[] args)
    {
        //int[] coins = {1,2,5};
        int[] coins = {1};
        System.out.println(new Solution322().coinChange1(coins, 2));
    }
    /**
     * 动态规划版本
     */
    public static int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++)
        {
            int ret = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++)
            {
                /** 最后一枚硬币不能大于i的面额， i - coins[j]的面额能够拼出来*/
                if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    /** 这种方式错误 */
                    //ret = Math.min(dp[i - coins[j]], ret) + 1;
                    /** if(i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE
                     *                          && dp[i - coins[j]] + 1 < ret)
                     *      ret = dp[i - coins[j]] + 1；
                     *      可以替换为上述写法
                     */
                    ret = Math.min(dp[i - coins[j]] + 1, ret) ;
            }
            dp[i] = ret;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 递归版本版本
     */

    public int coinChange1(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        int ret = getChanges(coins, amount, dp);

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private int getChanges(int[] coins, int amount, int[] dp)
    {
        if(dp[amount] != Integer.MIN_VALUE)
            return dp[amount];
        else
        {
            int ret = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++)
            {
                if(amount >= coins[i])
                    ret = Math.min(getChanges(coins,amount - coins[i], dp), ret);
            }
            dp[amount] = ret == Integer.MAX_VALUE ? ret : ret + 1;
            return dp[amount];
        }
    }
}