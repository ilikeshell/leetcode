//假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此
//类推。请你计算出粉刷完所有房子最少的花费成本。
//
// 注意：
//
// 所有花费均为正整数。
//
// 示例：
//
// 输入: [[1,5,3],[2,9,4]]
//输出: 5
//解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5;
//     或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5.
//
//
// 进阶：
//您能否在 O(nk) 的时间复杂度下解决此问题？
// Related Topics 动态规划
// 👍 64 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution265 {
    public static void main(String[] args)
    {
        int[][] costs = {{8}};
        System.out.println(minCostII(costs));
    }
    public static int minCostII(int[][] costs)
    {
        if(costs == null || costs.length == 0 )
            return 0;

        int m = costs.length;
        int k = costs[0].length;
        int[][] f = new int[m][k];

        /** 初始化第一栋房子染成K中房子的价格表 */
        for (int j = 0; j < k; j++)
            f[0][j] = costs[0][j];

        for (int i = 1; i < m; i++)
        {
            //保存染前一栋房子的最小值和次小值及对应索引
            int min1, min2;
            min1 = min2 = Integer.MAX_VALUE;
            int index1, index2;
            index1 = index2 = 0;

            //找到染前一排房子的最小值和次小值
            for (int j = 0; j < k; j++)
            {
                if(f[i-1][j] <= min1)
                {
                    min2 = min1;
                    index2 = index1;
                    min1 = f[i - 1][j];
                    index1 = j;
                }
                else if(f[i-1][j] < min2)
                {
                    min2 = f[i - 1][j];
                    index2 = j;
                }
            }

            for (int j = 0; j < k; j++)
            {
                //染当前房子的价格
                f[i][j] = costs[i][j];
                //如果不与前一栋价格最低的颜色冲突
                if(j != index1)
                    f[i][j] += min1;
                else
                    f[i][j] += min2; //冲突选次小值
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++)
            res = Math.min(f[m - 1][j], res);

        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
