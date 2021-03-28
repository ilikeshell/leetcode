import java.util.Arrays;

public class Solution673
{
    private static int count;

    public static void main(String[] args)
    {
        //int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int[] nums = {2,2,2,2,2};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[][] f = new int[2][nums.length];
        f[0][0] = f[1][0] = 1;

        /** 如果设置为0， 而数组长度为1，for循环可能不会执行 */
        int maxLen = 1; //不为空的话，长度至少为1

        for (int i = 1; i < nums.length; i++)
        {
            f[0][i] = 1;
            f[1][i] = 1;
            int preMax = Integer.MIN_VALUE;

            for (int j = i - 1; j >= 0; j--)
            {
                if (nums[i] > nums[j] && f[0][j] >= preMax)
                {
                    if(f[0][j] > preMax)
                    {
                        preMax = f[0][j];
                        f[0][i] = preMax + 1;
                        f[1][i] = f[1][j];
                    }
                    else {
                        f[1][i] += f[1][j];
                    }
                }
            }
            maxLen = Math.max(maxLen, f[0][i]);
        }
        //System.out.println(Arrays.toString(f[0]));
        //System.out.println(Arrays.toString(f[1]));

        int count = 0;
        for (int i = 0; i < f[0].length; i++)
        {
            if(f[0][i] == maxLen)
                count += f[1][i];
        }
        return count;
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
