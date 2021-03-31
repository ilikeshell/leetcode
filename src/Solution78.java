import java.util.ArrayList;
import java.util.List;

class Solution78
{
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        results.add(new ArrayList<>());
        backtrack(nums, 0);
        return results;
    }

    public void backtrack(int[] nums, int startIndex)
    {
        if(startIndex == nums.length)
            return;
        for (int i = startIndex; i < nums.length; i++)
        {
            path.add(nums[i]);
            //results.add((ArrayList)path.clone());
            results.add(new ArrayList<>(path));
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}