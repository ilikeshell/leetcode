import java.util.Arrays;

public class Solution35
{
    public int searchInsert(int[] nums, int target)
    {
        int ret = Arrays.binarySearch(nums, target);

        if(ret < 0)
            ret = Math.abs(ret) - 1;

        return ret;
    }

    private int binarySearch(int[] nums, int target)
    {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target)
                return mid;
            else if(target > nums[mid])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -lo - 1;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,3,5,6};
       // System.out.println(new Solution35().searchInsert(nums, 0));
        System.out.println(new Solution35().binarySearch(nums, 7));
    }
}
