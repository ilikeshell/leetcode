public class Solution303
{

}

class NumArray
{
    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums)
    {
        this.nums = nums;
        this.sums = new int[nums.length+1];

        if(nums.length > 0)
        {
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
            {
                sums[i] = nums[i] + sums[i-1];
            }
        }
    }

    public int sumRange(int i, int j)
    {
        return sums[j] - sums[i] + nums[i];
    }
}

class NumArray1
{
    private int[] sums;

    public NumArray1(int[] nums)
    {
        this.sums = new int[nums.length+1];

        if(nums.length > 0)
        {
            sums[0] = 0;
            sums[1] = nums[0];
            for (int i = 1; i < nums.length; i++)
            {
                sums[i+1] = nums[i] + sums[i];
            }
        }
    }

    public int sumRange(int i, int j)
    {
        return sums[j+1] - sums[i];
    }
}

