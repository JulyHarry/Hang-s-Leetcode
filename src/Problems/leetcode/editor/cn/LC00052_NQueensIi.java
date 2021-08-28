/*
 * @Desc:  LC00052 - N皇后 II
 * @Url:   https://leetcode-cn.com/problems/n-queens-ii/
 * @Date:  2021-08-28 01:13:03
 * @Content:
 //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯 👍 286 👎 0

 */

package Problems.leetcode.editor.cn;

class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        int a = solution.totalNQueens(4);
    }

    /*
     * Solution is here.
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        boolean[] row;
        boolean[] col;
        boolean[] diag;
        boolean[] odiag;
        int ans;

        public int totalNQueens(int n) {
            this.n = n;
            row = new boolean[n];
            col = new boolean[n];
            diag = new boolean[2 * n - 1];
            odiag = new boolean[2 * n - 1];
            ans = 0;
            dfs(0);
            return ans;
        }

        private void dfs(int x) {
            if (x == n) {
                ans++;
                return;
            }
            for (int i = x; i < n; i++) {
                for (int k = 0; k < i; k++) {
                    if (!row[k]) {
                        return;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j] || diag[i + j] || odiag[i - j + n - 1]) {
                        if (j == n - 1) {
                            return;
                        }
                        continue;
                    }
                    row[i] = true;
                    col[j] = true;
                    diag[i + j] = true;
                    odiag[i - j + n - 1] = true;
                    dfs(i + 1);
                    row[i] = false;
                    col[j] = false;
                    diag[i + j] = false;
                    odiag[i - j + n - 1] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}