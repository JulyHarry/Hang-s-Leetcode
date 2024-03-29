/*
 * @Desc:  LC01947 - 最大兼容性评分和
 * @Url:   https://leetcode-cn.com/problems/maximum-compatibility-score-sum/
 * @Date:  2021-08-31 19:40:23
 * @Content:
 //有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。 
//
// 这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，其中 
//students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，其中 
//mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。 
//
// 每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。 
//
// 
// 例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。 
// 
//
// 请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。 
//
// 给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。 
//
// 
//
// 示例 1： 
//
// 输入：students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
//输出：8
//解释：按下述方式分配学生和导师：
//- 学生 0 分配给导师 2 ，兼容性评分为 3 。
//- 学生 1 分配给导师 0 ，兼容性评分为 2 。
//- 学生 2 分配给导师 1 ，兼容性评分为 3 。
//最大兼容性评分和为 3 + 2 + 3 = 8 。 
//
// 示例 2： 
//
// 输入：students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]
//输出：0
//解释：任意学生与导师配对的兼容性评分都是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == students.length == mentors.length 
// n == students[i].length == mentors[j].length 
// 1 <= m, n <= 8 
// students[i][k] 为 0 或 1 
// mentors[j][k] 为 0 或 1 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 12 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.Arrays;

class MaximumCompatibilityScoreSum{
    public static void main(String[] args) {
        Solution solution = new MaximumCompatibilityScoreSum().new Solution();
        int[][] students = {{1, 1, 0}, {1, 0, 1}, {0, 0, 1}};
        int[][] mentors = {{1, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        int i = solution.maxCompatibilitySum(students, mentors);
        System.out.println("i = " + i);
    }

/*
 * Solution is here.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited;
    int[][] score;
    int m;
    int res = 0;

    //dp
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        score = new int[m][m];
        int n = 1 << m;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                calculate(students[i], mentors[j], i, j);
            }
        }
        for (int mask = 0; mask < n; mask++) {
            int bitCount = Integer.bitCount(mask);
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << i)] + score[i][bitCount - 1]);
                }
            }
        }
        return dp[n - 1];
    }

    //backtrack
    public int maxCompatibilitySum2(int[][] students, int[][] mentors) {
        m = students.length;
        score = new int[m][m];
        visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                calculate(students[i], mentors[j], i, j);
            }
        }
        backtrack(0, 0);
        for(int[] s : score) {
            System.out.println(Arrays.toString(s));
        }
        return res;
    }

    private void backtrack(int s, int cur) {
        if (s == m) {
            res = Math.max(res, cur);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur += score[s][i];
                backtrack(s + 1, cur);
                cur -= score[s][i];
                visited[i] = false;
            }
        }
    }

    private void calculate (int[] student, int[] mentor, int i, int j) {
        int res = 0;
        for (int k = 0; k < student.length; k++) {
            if (student[k] == mentor[k]) {
                res++;
            }
        }
        score[i][j] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}