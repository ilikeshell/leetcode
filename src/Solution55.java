public class Solution55
{
    public boolean canJump(int[] nums)
    {
        Boolean[] dp = new Boolean[nums.length];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++)
        {

        }

        return dp[nums.length - 1];
    }
}
