import java.util.Arrays;

public class Solution322
{
    public static void main(String[] args)
    {
        //int[] coins = {1,2,5};
        int[] coins = {1};
        System.out.println(new Solution322().coinChange(coins, 2));
    }
    public int coinChange(int[] coins, int amount)
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