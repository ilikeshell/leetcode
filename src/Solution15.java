import java.util.*;

public class Solution15
{
    public static void main(String[] args)
    {
        //int[] nums = {0,0,0,0};
        int[] nums = {-1,0,1,2,-1,-4};
        for(List<Integer> e : new Solution15().threeSum(nums))
            System.out.print(e.toString() + " ");
    }
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if(i - 1 >= 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1, k = nums.length - 1; j < k; j++)
            {
                if(nums[j] + nums[i] > 0)
                    break;

                if(j + 1 < k && nums[j] == nums[j+1])
                    continue;

                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0)
                {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    ret.add(result);
                    k--;
                }
                else if(sum > 0)
                {
                    k--;
                    j--;
                }
            }
        }
        return ret;
    }

    /** 复杂度太高，将会超时 */
    public List<List<Integer>> threeSum1(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Map<String, Integer> testUnique = new HashMap<>();

        for (int k = 0; k < nums.length; k++)
        {
            if (nums[k] > 0)
                continue;
            for (int i = k + 1; i < nums.length; i++)
            {
                if(nums[k] + nums[i] > 0)
                    continue;

                for (int j = i + 1; j < nums.length; j++)
                {
                    if (nums[k] + nums[i] + nums[j] == 0)
                    {
                        Integer[] result = new Integer[3];
                        result[0] = nums[k];
                        result[1] = nums[i];
                        result[2] = nums[j];

                        Arrays.sort(result);
                        String key = Arrays.toString(result);
                        testUnique.put(key,
                                testUnique.getOrDefault(key, 0) + 1);

                        if (testUnique.get(key) == 1)
                        {
                            ret.add(Arrays.asList(result));
                        }
                    }
                }
            }
        }
        return ret;
    }

    /** 使用双指针法，并利用HashMap去除重复结果，时间复杂度降低一个量级， */
    public List<List<Integer>> threeSum3(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        Map<String, Integer> testUnique = new HashMap<>();

        for (int k = 0; k < nums.length; k++)
        {
            int i = k + 1, j = nums.length - 1;

            while (i < j)
            {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0)
                {
                    Integer[] result = new Integer[3];
                    result[0] = nums[k];
                    result[1] = nums[i];
                    result[2] = nums[j];

                    //Arrays.sort(result);
                    String key = Arrays.toString(result);
                    testUnique.put(key,
                            testUnique.getOrDefault(key, 0) + 1);

                    if (testUnique.get(key) == 1)
                    {
                        ret.add(Arrays.asList(result));
                    }
                    i++;
                    j--;
                }else if(sum > 0)
                    j--;
                else
                    i++;
            }
        }
        return ret;
    }

    public static void main1(String[] args)
    {
       int[] nums = {-1,0,1,2,-1,-4};
       List<List<Integer>> result = new Solution15().threeSum(nums);

        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i).toString());
        }

        Map<String, Integer> testUnique = new HashMap<>();

        Integer[] array = {-1,1,0};
        Arrays.sort(array);
        String key = Arrays.toString(array);
        testUnique.put(key,
                testUnique.getOrDefault(key, 0) + 1);

        testUnique.put(key,
                testUnique.getOrDefault(key, 0) + 1);

        System.out.println(testUnique.get(key));
    }
}
