import java.util.Arrays;

public class Solution673
{
    private static int count;

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] f = new int[nums.length];
        f[0] = 1;

        /** 如果设置为0， 而数组长度为1，for循环可能不会执行 */
        int ret = 1; //不为空的话，长度至少为1

        for (int i = 1; i < nums.length; i++)
        {
            f[i] = 1;

            for (int j = i - 1; j >= 0; j--)
            {
                if (nums[i] > nums[j])
                {
                    f[i] = f[j] + 1;
                    break;
                }
            }

            ret = Math.max(ret, f[i]);
        }
        //System.out.println(Arrays.toString(f));
        //return ret;


    }

    private static void bt(int[] nums, int[] f, int prevIndex, int n, int max)
    {
        if (n > max)
        {
            count++;
            return;
        }

        int currIndex = prevIndex + 1;
        while (currIndex < f.length && f[currIndex] != n)
            currIndex++;


        while (currIndex < f.length && f[currIndex] == n)
        {
            if (prevIndex >= 0 && nums[prevIndex] >= nums[currIndex])
            {
                currIndex++;
                continue;
            }
            bt(nums, f, currIndex, n + 1, max);
            currIndex++;
        }

    }
}
