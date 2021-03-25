import java.util.Stack;

public class Solution456
{
    /**
     *
     * @param nums
     * @
     * 解题思路
     * 132132 模式的三位数字，我们用 abc 表示，我们要的结果就是：a < c < b, a<c<b !
     *
     * 解题思路很简单，就是保证：中间的数能有多大，就让它多大！
     *
     * 然后解题流程如下所示：
     *
     * 因为我们只找符合 132132 模式的一组数字，所以我们创建一个栈(长度最大为 33)，用来存放结果。
     * 首先，我们可以默认 numsnums 第一位为 aa，然后在其右侧，找寻比 aa 大的值作为 bb
     * 其次，若中途遇到比 bb 还大的值，我们将替换最大值为当前值。
     * 最后，我们在 bb 右侧找寻中间值。
     * 若遍历一轮，未找到匹配 132132 模式的结果，我们将最小值右移一位，清空栈内容，再次查找即可。
     * 时间复杂度O(n2)
     */
    public boolean find132pattern(int[] nums)
    {
        if(nums.length == 0)
            return false;

        int value1, value2;

        for (int i = 0; i < nums.length - 2; i++)
        {
            //设置value1
            value1 = nums[i];
            int k = i + 1;

            //找一个大于value1的值赋值给value2
            while(k < nums.length && nums[k] <= value1)
                k++;

            //找不到合适的value2
            if(k == nums.length)
                continue;

            value2 = nums[k];

            //查找合适的value3
            for (int j = k + 1; j < nums.length; j++)
            {
                //发现更大的数，更新value2
                if(nums[j] > value2)
                {
                    value2 = nums[j];
                    continue;
                }
                //找到合适的数，返回
                else if(nums[j] < value2 && nums[j] > value1)
                    return true;
            }
        }
        //全部找完未找到
        return false;
    }

    /**
     *  体会单调栈的作用
     *   时间复杂度为O(n)
     *   单调栈 ➕ 逆序 时间复杂度 O（n） 单调栈似乎适合解决这种有个山峰极值的情况
     *   用例：
     *   [1,2,3,4]
     *   [3,1,4,2]
     *   [-1,3,2,0]
     */
    public boolean find132pattern1(int[] nums)
    {
        /** 输入合法性检查 */
        if(nums.length == 0)
            return false;

        /** 栈，用于保存一个单调递减的序列（从底部开始） */
        Stack<Integer> s = new Stack<Integer>();

        /** twoElement保存的值仅小于栈顶的值，但是位置大于栈顶值 */
        int twoElement = Integer.MIN_VALUE;

        /** 从后往前扫描每个数字 */
        for (int i = nums.length - 1; i >= 0; i--)
        {
            /** 找到一个结果，程序结束 */
            if(nums[i] < twoElement) return true;

            /** 如果栈不为空，弹出栈中所有小于nums[i]的元素 */
            while(!s.isEmpty() && nums[i] > s.peek())
                /** twoElement中保存原来栈中最后一个比nums[i]小的元素*/
                twoElement = s.pop();

            /** 栈中已经没有比nums[i]最小的元素，nums[i]就是栈中最小的元素
             * 单调栈
             */
            s.push(nums[i]);
        }
        /** 扫描结束，没有找到 */
        return false;
    }
}
