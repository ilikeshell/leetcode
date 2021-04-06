//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
// 👍 160 👎 0

public class Solution_17_21_LCCI
{
    public static void main(String[] args)
    {
       // int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {8,2,8,9,0,1,7,7,9};
        System.out.println(trap(height));
    }
    public static int trap(int[] height)
    {
        if(height == null || height.length < 3)
            return 0;

        int[] f = new int[height.length];
        f[0] = f[1] = 0;

        for (int i = 2; i < height.length; i++)
        {
            f[i] = f[i - 1];
            //如果当前位置可以做桶板
            if(height[i] > height[i - 1])
            {
                int index = i - 1;
                //向左回溯找另一个"桶板"
                for (int j = i - 2 ; j >=0 ; j--)
                {
                    //如果找到一个等于或者更长的"桶板"，立即停止
                    if(height[j] >= height[i])
                    {
                        index = j;
                        break;
                    }
                    //寻找一个仅次于height[i]的值
                    if(height[j] > height[index])
                        index = j;
                }

                // 没找到桶板
                if(index == i - 1)
                {
                    /** 不能加这条语句， 如{8,2,8,9,0,1,7,7,9}
                     *   f[3]会被置0，
                     *  实际上f[3] == f[2] == 6
                     */
                   // f[i] = 0;
                        continue;
                }
                else{
                    // 获取两个桶板之间的短板
                    int hi = Math.min(height[index], height[i]);
                    f[i] = f[index];
                    //计算"新桶"可装的水量
                    for (int j = index + 1; j < i; j++)
                    {
                        f[i] += hi - height[j];
                    }
                }
            }
        }
        return f[height.length - 1];
    }
}
