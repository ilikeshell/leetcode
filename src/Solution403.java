public class Solution403
{
    public static void main(String[] args)
    {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
    public static boolean canCross(int[] stones)
    {
        boolean[] dp = new boolean[stones.length];
        dp[0] = true;
        int k = 0;

        for (int i = 0; i < stones.length; i++)
        {
            if(dp[i])
            {
                
            }
        }
        return dp[stones.length - 1];
    }
}
