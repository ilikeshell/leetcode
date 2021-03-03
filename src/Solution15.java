import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1, k = nums.length - 1; j < k; j++)
            {
                if(nums[j] + nums[i] > 0)
                    break;
                if(nums[j] == nums[j+1])
                    continue;

                if(nums[i] + nums[j] + nums[k] == 0)
                {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    ret.add(result);
                    k--;
                }
            }
        }
        return ret;
    }
}
