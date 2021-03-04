import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*     四数之和
 * */

public class Solution18
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++)
        {
            /** 第一个数去重 */
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            for (int j = i+1; j < nums.length - 2; j++)
            {
                /** 第二个数去重 */
                if(nums[j] == nums[j-1] && j - 1 > i)
                    continue;

                /** 左右两个指针用来寻找第三个和第四个数 */
                int left = j + 1;
                int right = nums.length - 1;

                while(left < right)
                {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target)
                    {
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[left]);
                        result.add(nums[right]);
                        ret.add(result);

                        /** 去重 */
                        while(nums[left] == nums[left + 1] && left + 1 < right)
                            left++;
                        while (nums[right] == nums[right - 1] && right - 1 > left)
                            right--;

                        /** 同时收缩左右指针 */
                        left++;
                        right--;
                    }else if(sum > target)
                        right--;
                    else
                        left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args)
    {
        Solution18 s = new Solution18();
        int[] nums = {0,0,0,0};
        System.out.println(s.fourSum(nums, 0));
    }
}
