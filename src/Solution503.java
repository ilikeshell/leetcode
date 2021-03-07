import java.util.Arrays;
import java.util.Stack;

public class Solution503
{
    private Stack<Integer> s = new Stack<>();

    public int[] nextGreaterElements(int[] nums)
    {
        int len = nums.length;
        int[] ret = new int[len];

        Arrays.fill(ret, -1);

        for (int i = 0; i < 2 * len; i++)
        {
            if((s.size() == 0) || (nums[s.peek()] >= nums[i % len] && ret[i % len] == -1))
            {
                s.push(i % len);
            }
            else
            {
                while(!s.isEmpty() && nums[s.peek()] < nums[i % len])
                {
                    ret[s.pop()] = nums[i % len];
                }
                if(ret[i % len] == -1) s.push(i % len);
               // i--;
            }
        }

        /*while(!s.isEmpty())
            ret[s.pop()] = -1;*/

        return ret;
    }

    public int[] nextGreaterElements1(int[] nums)
    {

        int len = nums.length;
        int[] nums2 = new int[2 * len];
        System.arraycopy(nums,0,nums2,0, len);
        System.arraycopy(nums,0,nums2,len, len);
        System.out.println(Arrays.toString(nums2));

        int[] ret = new int[len];

        for (int i = 0; i < 2 * len; i++)
        {
            if(i + 1 < 2 * len && nums2[i] < nums2[i + 1])
            {
                ret[i%len] = nums2[i + 1];
                while (!s.isEmpty() && nums2[s.peek()] < nums2[i + 1])
                    ret[s.pop()] = nums2[i + 1];
            }
            else if(!s.contains(i))
                s.push(i);
        }



        while(!s.isEmpty())
        {
            ret[s.pop()] = -1;
        }

        return ret;
    }

    public static void main(String[] args)
    {
        //int[] nums = {1,2,1};
        int[] nums = {3,1,4,2,9,7,6,8,0};
        System.out.println(Arrays.toString(new Solution503().nextGreaterElements(nums)));
    }
}
