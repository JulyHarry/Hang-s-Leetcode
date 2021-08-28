/*
 * @Desc:  LC00051 - N 皇后
 * @Url:   https://leetcode-cn.com/problems/n-queens/
 * @Date:  2021-08-27 22:19:03
 * @Content:
 //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 987 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        List<List<String>> lists = solution.solveNQueens(5);
        System.out.println("lists = " + lists);
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
        char[][] grids;
        List<List<String>> ans;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            row = new boolean[n];
            col = new boolean[n];
            diag = new boolean[2 * n - 1];
            odiag = new boolean[2 * n - 1];
            grids = new char[n][n];
            ans = new ArrayList<>();
            for (char[] grid : grids) {
                Arrays.fill(grid, '.');
            }
            dfs(0);
            return ans;
        }

        private void dfs(int x) {
            if (x == n) {
                List<String> cur = new ArrayList<>();
                for (char[] grid : grids) {
                    cur.add(new String(grid));
                }
                ans.add(cur);
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
                    grids[i][j] = 'Q';
                    dfs(i + 1);
                    row[i] = false;
                    col[j] = false;
                    diag[i + j] = false;
                    odiag[i - j + n - 1] = false;
                    grids[i][j] = '.';
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}