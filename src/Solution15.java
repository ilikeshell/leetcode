import java.util.*;

public class Solution15
{
    public static void main(String[] args)
    {
        //int[] nums = {0,0,0,0,0};
        //int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums = {-2,0,1,1,2};
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        for(List<Integer> e : new Solution15().threeSum(nums))
            System.out.print(e.toString() + " ");
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++)
        {
            /** 第一个数去重 */
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            /** 左右两个指针用来寻找第二个和第三个数 */
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right)
            {
                /** 第一个数和第二个数的组合去重 */
                /*if (ret.size() > 0)
                {
                    List<Integer> lastArray = ret.get(ret.size() - 1);
                    if (ret.size() > 0 && lastArray.get(0) == nums[i] && lastArray.get(1) == nums[left])
                        continue;
                }
                    */

                /** 左右去重   例如:[-2, 0, 0, 0, 1, 1]  i->-2, left->0, right->1
                 *        这种方式去重的话，会漏掉[-2,1,1]这个组合，因为最后一个1被去重去
                 * 掉了。所以这种方式是错误的，因为被去重的数字还有可能参与这个三元组的。
                 * */
                /*while(nums[left] == nums[left + 1] && left + 1 < right)
                    left++;
                while (nums[right] == nums[right - 1] && right - 1 > left)
                    right--;

                if(left >= right)
                    break;*/

                int sum = nums[i] + nums[left] + nums[right];

                /** 和等于0， 添加三个数到结果，同时收缩左右两指针 */
                if(sum == 0)
                {
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    ret.add(result);

                    /** 正确的去重方式，left和right指向的元素已经明确加入了结果集，所以left
                     * 指针右边相同的元素要被去除，同理，right指针右边的重复元素要被去除
                     * */
                    while(nums[left] == nums[left + 1] && left + 1 < right)
                        left++;
                    while (nums[right] == nums[right - 1] && right - 1 > left)
                        right--;

                    /** 同时收缩左右指针 */
                    left++;
                    right--;
                } /** 和大于0， 收缩右指针 */
                else if(sum > 0)
                {
                    right--;
                } /** 和小于0， 收缩左指针 */
                else
                    left++;
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
