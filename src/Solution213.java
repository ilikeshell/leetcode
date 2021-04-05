class Solution213 {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int[] nums1 = new int[nums.length - 1];
        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
        int res = cal(nums1);
        System.arraycopy(nums, 1, nums1, 0, nums.length - 1);
        res = Math.max(cal(nums1), res);

        return res;
    }

    public int cal(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int[] f= new int[nums.length + 1];
        f[0] = 0;
        f[1] = nums[0];

        for (int i = 2; i < f.length; i++)
        {
            f[i] = Math.max(f[i - 2] + nums[i - 1], f[i - 1]);
        }

        return f[nums.length];
    }
}