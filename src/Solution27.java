import java.util.Arrays;

public class Solution27
{
    public int removeElement(int[] nums, int val)
    {
        int j = nums.length;
        int i = 0;
        while(i < j)
        {
            if(nums[i] == val)
                nums[i] = nums[--j]; //reduce array size by one
            else
                i++;
        }
        return i;
    }
    public int removeElement2(int[] nums, int val)
    {
        int i = 0;
        for (int j = 0; j < nums.length; j++)
        {
            if(nums[j] != val)
                nums[i++] = nums[j];
        }
        return i;
    }

    public int removeElement1(int[] nums, int val)
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] == val)
            {
                nums[i] = -1;
                count++;
            }
        }
        int len = nums.length - count;

        if(len > 0)
        {
            int i = 0, j = nums.length - 1;
            while (true)
            {
                while ( i < len && nums[i] != -1)
                    i++;
                while ( j >= 0 && nums[j] == -1)
                    j--;

                if(i < j && i < len && j >= 0)
                {
                    nums[i++] = nums[j--];
                }
                else
                    break;
            }
        }

        return len;
    }

    public static void main(String[] args)
    {
       int[] nums = {0,1,2,2,3,0,4,2};
       // int[] nums = {2};
        Solution27 s = new Solution27();
        System.out.println(s.removeElement(nums,1));
        System.out.println(Arrays.toString(nums));
    }
}
