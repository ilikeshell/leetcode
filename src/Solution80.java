class Solution80
{
    public static void main(String[] args)
    {
       // int[] nums = {1,1,1,2,2,3};
        //int[] nums = {0,0,1,1,1,1,2,3,3};
        int[] nums = {0};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int currIndex = -1;
        int moveIndex = 0;

        //当前位置之后有3个元素才处理
        while(currIndex + 3 < len)
        {
            //当前位置之后的第一个元素和第二个元素不相等
            if(nums[currIndex + 1] != nums[currIndex + 2])
                currIndex++;
            //当前位置之后的第一个元素和第二个元素相等，且与第三个元素也相等
            else if(nums[currIndex + 1] == nums[currIndex + 3])
            {
                for (int i = currIndex + 3; i < len; i++)
                {
                    nums[i - 1] = nums[i];
                }
                len--;
            }else //当前位置之后的第一个元素和第二个元素相等，且与第三个元素不相等
            {
                currIndex = currIndex + 2;
            }
        }

        return len;
    }
}