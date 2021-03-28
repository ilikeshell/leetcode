public class Solution674
{
    public int findLengthOfLCIS(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int[] f = new int[nums.length];
        f[0] = 1;

        /** 如果设置为0， 而数组长度为1，for循环可能不会执行 */
        int ret = 1; //不为空的话，长度至少为1

        for (int i = 1; i < nums.length; i++)
        {
            f[i] = 1;

            if(nums[i] > nums[i - 1])
                f[i] = f[i - 1] + 1;

            ret = Math.max(ret, f[i]);
        }
        return ret;
    }
}
