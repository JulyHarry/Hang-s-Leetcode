package DynamicProgramming;

/**
 * Description: 576. 出界的路径数
 * https://leetcode-cn.com/problems/out-of-boundary-paths/
 *
 * @author HarryUp
 * @date 2021/8/15
 */
public class OutofBoundaryPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int mod = 1000000007;
        int[][] dp = new int[m][n];
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        dp[startRow][startColumn] = 1;
        int res = 0;
        for (int i = 0; i < maxMove; i++) {
            int[][] dpNew = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0];
                            int k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dpNew[j1][k1] = (dpNew[j1][k1] + count) % mod;
                            } else {
                                res = (res + count) % mod;
                            }
                        }
                    }
                }
            }
            dp = dpNew;
        }
        return res;
    }
}
