import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution46 {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> aPermutation = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return results;
    }

    private void permute(int[] nums, int startIndex)
    {
        if(startIndex == nums.length - 1)
        {
            results.add(arrayToList(nums));
        }

        for (int i = startIndex; i < nums.length; i++)
        {
            swap(nums, startIndex, i);
            int[] temp = nums.clone();
            Arrays.sort(nums, startIndex + 1, nums.length);
            permute(nums, startIndex+1);
            nums = temp;
            swap(nums, startIndex, i);
        }
    }

    private ArrayList<Integer> arrayToList(int[] nums)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            result.add(nums[i]);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}