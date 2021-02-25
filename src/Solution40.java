import java.io.IOException;
import java.util.*;

public class Solution40
{
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        backStracking(candidates, target, 0, 0);
        return results;
    }

    private boolean isContained(List<Integer> path)
    {

        for (int i = 0; i < results.size(); i++)
        {
            if(results.get(i).equals(path))
                return true;
        }
        return false;
    }

    private void convert()
    {
        String[] str = new String[results.size()];

        for (int i = 0; i < results.size(); i++)
        {
            str[i] = results.get(i).toString();
        }
        Arrays.sort(str);
    }

    private void backStracking(int[] candidates,int target, int sum, int startIndex)
    {
        if(sum > target)
            return;
        if(sum == target)
        {
            Collections.sort(path);
            if(!isContained(path))
                results.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++)
        {
            path.add(candidates[i]);
            sum += candidates[i];
            backStracking(candidates, target, sum, i+1);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }

    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException
    {

        int[] candidates = {10,1,2,7,6,1,5};

        int target = 8;

        List<List<Integer>> ret = new Solution40().combinationSum(candidates, target);

        String out = int2dListToString(ret);

        System.out.print(out);

    }
}
