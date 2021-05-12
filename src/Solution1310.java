//有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
//
// 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为
//本次查询的结果。
//
// 并返回一个包含给定查询 queries 所有结果的数组。
//
//
//
// 示例 1：
//
// 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
//输出：[2,7,14,8]
//解释：
//数组中元素的二进制表示形式是：
//1 = 0001
//3 = 0011
//4 = 0100
//8 = 1000
//查询的 XOR 值为：
//[0,1] = 1 xor 3 = 2
//[1,2] = 3 xor 4 = 7
//[0,3] = 1 xor 3 xor 4 xor 8 = 14
//[3,3] = 8
//
//
// 示例 2：
//
// 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
//输出：[8,0,4,4]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 3 * 10^4
// 1 <= arr[i] <= 10^9
// 1 <= queries.length <= 3 * 10^4
// queries[i].length == 2
// 0 <= queries[i][0] <= queries[i][1] < arr.length
//
// Related Topics 位运算
// 👍 94 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        /** 先建立一个数组xor[]，xor[i]存储从arr[0]异或到当前元素arr[i]的值， */
        int[] xor = new int[len];
        xor[0] = arr[0];
        for (int i = 1; i < len; i++) xor[i] = xor[i - 1] ^ arr[i];

        int[] res = new int[queries.length];
        int Li, Ri;
        for (int i = 0; i < queries.length; i++)
        {
            Li = queries[i][0];
            Ri = queries[i][1];

            /** 如果a^b^c^d^e=f,那么d^e=(a^b^c)^f */
            if(Li == 0)  //Li == 0 需要特殊处理
            {
                res[i] = xor[Ri];
            }else
            {
                /** 于是arr[j]^arr[j+1]^...^arr[k-1]^arr[k]=xor[Ri]^xor[Li - 1] */
                res[i] = xor[Ri] ^ xor[Li - 1];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
