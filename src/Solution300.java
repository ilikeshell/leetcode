public class Solution300
{
    public int lengthOfLIS(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int[] f = new int[nums.length];
        f[0] = 1;
        int ret = 1;

        for (int i = 1; i < nums.length; i++)
        {
            f[i] = 1;
            /** 记录前i-1个元素中，值小于nums[i]的子序列长度 */
            int maxLen = Integer.MIN_VALUE;

            /** 在前i-1个元素中，找到一个nums[j]小于nums[i]，并且f[j]最大 */
            for(int j = i - 1; j >= 0; j--)
            {

                if(nums[i] > nums[j] && f[j] > maxLen)
                {
                    maxLen = f[j];
                    //找到则更新
                    f[i] = maxLen + 1;
                }
            }
            ret = Math.max(ret, f[i]);
        }
        return ret;
    }
}
