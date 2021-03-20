import java.util.Arrays;

public class Solution55
{
    public boolean canJump1(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return false;
        Boolean[] dp = new Boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < dp.length; i++)
        {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++)
            {
                dp[i + j] = true;
            }
        }

        return dp[nums.length - 1];
    }

    public boolean canJump(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return false;

        Boolean[] dp = new Boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++)
        {
            dp[i] = false;
            for(int j = 0; j < i; j++)
            {
                if(dp[j] && j + nums[j] >= i)
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
