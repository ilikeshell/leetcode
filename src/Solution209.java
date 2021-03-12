public class Solution209
{
    public static void main(String[] args)
    {
        Solution209 s = new Solution209();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(s.minSubArrayLen(target, nums));
    }
    public int minSubArrayLen(int target, int[] nums)
    {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if(sum >= target && j - i + 1 < len)
                {
                    len = j - i + 1;
                    break;
                }
                else
                    continue;

            }
        }

        if(len == Integer.MAX_VALUE)
            return 0;
        else return len;
    }
}
