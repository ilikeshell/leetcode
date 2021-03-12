public class Solution209
{
    public static void main(String[] args)
    {
        Solution209 s = new Solution209();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(s.minSubArrayLen(target, nums));
    }

    /**
     * 滑动窗口法，把时间复杂度降低到O(n)
     * @param target
     * @param nums
     * @return
     */

    public int minSubArrayLen(int target, int[] nums)
    {
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;

        if(nums.length == 0)
            return 0;
        int sum = 0;
       /* while(left < nums.length && right < nums.length)
        {
            sum += nums[right++];

            while (sum >= target)
            {
                int subLen = right - left + 1;
                if(subLen < len)
                    len = subLen;
                sum -= nums[left++];
            }
        }*/
        for (right = 0; right < nums.length; right++)
        {
            sum += nums[right];

            while (sum >= target)
            {
                int subLen = right - left + 1;
                if(subLen < len)
                    len = subLen;
                sum -= nums[left++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }



    /**
     * 暴力解法
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums)
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
