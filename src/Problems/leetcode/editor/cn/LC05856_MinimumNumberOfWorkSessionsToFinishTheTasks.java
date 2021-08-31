/*
 * @Desc:  LC05856 - 完成任务的最少工作时间段
 * @Url:   https://leetcode-cn.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 * @Date:  2021-08-30 14:33:35
 * @Content:
 //你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 
//中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。 
//
// 你需要按照如下条件完成给定任务： 
//
// 
// 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。 
// 完成一个任务后，你可以 立马 开始一个新的任务。 
// 你可以按 任意顺序 完成任务。 
// 
//
// 给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。 
//
// 测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。 
//
// 
//
// 示例 1： 
//
// 输入：tasks = [1,2,3], sessionTime = 3
//输出：2
//解释：你可以在两个工作时间段内完成所有任务。
//- 第一个工作时间段：完成第一和第二个任务，花费 1 + 2 = 3 小时。
//- 第二个工作时间段：完成第三个任务，花费 3 小时。
// 
//
// 示例 2： 
//
// 输入：tasks = [3,1,3,1,1], sessionTime = 8
//输出：2
//解释：你可以在两个工作时间段内完成所有任务。
//- 第一个工作时间段：完成除了最后一个任务以外的所有任务，花费 3 + 1 + 3 + 1 = 8 小时。
//- 第二个工作时间段，完成最后一个任务，花费 1 小时。
// 
//
// 示例 3： 
//
// 输入：tasks = [1,2,3,4,5], sessionTime = 15
//输出：1
//解释：你可以在一个工作时间段以内完成所有任务。
// 
//
// 
//
// 提示： 
//
// 
// n == tasks.length 
// 1 <= n <= 14 
// 1 <= tasks[i] <= 10 
// max(tasks[i]) <= sessionTime <= 15 
// 
// 👍 26 👎 0

 */

package Problems.leetcode.editor.cn;

import java.util.Arrays;

class MinimumNumberOfWorkSessionsToFinishTheTasks {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfWorkSessionsToFinishTheTasks().new Solution();
        int[] tasks = {3, 1, 3, 1, 1};
        int session = 8;
        int i = solution.minSessions(tasks, session);
        System.out.println(i);
    }

    /*
     * Solution is here.
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSessions(int[] tasks, int sessionTime) {
            int n = tasks.length;
            boolean[] valid = new boolean[1 << n];
            int[] dp = new int[1 << n];
            Arrays.fill(dp, 20);
            dp[0] = 0;
            for (int mask = 1; mask < 1 << n; mask++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        cur += tasks[i];
                    }
                }
                if (cur <= sessionTime) {
                    valid[mask] = true;
                }
            }
            for (int mask = 1; mask < 1 << n; mask++) {
                for (int subset = mask; subset > 0; subset = (subset - 1) & mask) {
                    if (valid[subset]) {
                        dp[mask] = Math.min(dp[mask], dp[mask ^ subset] + 1);
                    }
                }
            }
            return dp[(1 << n) - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public int minSessions2(int[] tasks, int sessionTime) {
        // wrong answer. Greedy
        Arrays.sort(tasks);
        boolean[] visited = new boolean[tasks.length];
        int j = tasks.length - 1;
        int all = 0;
        int res = 0;
        while (j >= 0) {
            int cur = sessionTime;
            while (j >= 0 && tasks[j] <= cur) {
                if (!visited[j]) {
                    cur -= tasks[j];
                    visited[j] = true;
                    all++;
                }
                j--;
            }
            int i = j - 1;
            while (cur >= tasks[0] && i >= 0) {
                if (!visited[i] && tasks[i] <= cur) {
                    cur -= tasks[i];
                    visited[i] = true;
                    all++;
                }
                i--;
            }
            res++;
            if (all == tasks.length) {
                return res;
            }
        }
        return res;
    }

}