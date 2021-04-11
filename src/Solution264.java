//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//
//
// 示例 1：
//
//
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1690
//
// Related Topics 堆 数学 动态规划
// 👍 563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution264 {
    public int nthUglyNumber(int n) {
        if(n <= 0)
            return 0;

        int[] f = new int[n];

        f[0] = 1;
        int index2, index3, index5;
        index2 = index3 = index5 = 0;

        for (int i = 1; i < n; i++)
        {
            f[i] = Math.min(Math.min(2 * f[index2], 3 * f[index3]), 5 * f[index5]);
            if(f[i] == 2 * f[index2]) index2++;
            if(f[i] == 3 * f[index3]) index3++;
            if(f[i] == 5 * f[index5]) index5++;
        }

        return f[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
