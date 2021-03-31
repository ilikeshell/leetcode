import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution90
{
    private List<List<Integer>> results = new ArrayList<>();
    private HashSet<String> set = new HashSet<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        results.add(new ArrayList<>());
        Arrays.sort(nums);
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
            if(!set.contains(path.toString()))
            {
                results.add(new ArrayList<>(path));
                set.add(path.toString());
            }
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
