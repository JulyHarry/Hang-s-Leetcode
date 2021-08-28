package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/3/20
 */
public class Ct210320 {
    /**
     * https://leetcode-cn.com/contest/biweekly-contest-48/problems/second-largest-digit-in-a-string/
     *
     * @param s
     * @return
     */
    public int secondHighest(String s) {
        int[] res = {-1, -1};
        for (char a : s.toCharArray()) {
            if (Character.isDigit(a)) {
                int cur = a - '0';
                if (cur > res[0]) {
                    res[1] = res[0];
                    res[0] = cur;
                } else if (cur != res[0] && cur > res[1]) {
                    res[1] = cur;
                }
            }
        }
        return res[1];
    }

    /**
     * https://leetcode-cn.com/contest/biweekly-contest-48/problems/maximum-number-of-consecutive-values-you-can-make/
     *
     * @param coins
     * @return
     */
    public int getMaximumConsecutive(int[] coins) {
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[coins.length];
        if (coins[0] != 1) {
            return 1;
        }
        dp[0] = 2;
        for (int i = 1; i < coins.length; i++) {
            if (coins[i] > dp[i - 1]) {
                return dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + coins[i];
            }
        }
        return dp[coins.length - 1];
    }


    /**
     * https://leetcode-cn.com/contest/biweekly-contest-48/problems/maximize-score-after-n-operations/
     *
     * @param nums
     * @return
     */
    int[] p;
    boolean[] v;
    int res;
    int cnt = 0;
    Set<Integer> set = new HashSet<>();

    public int maxScore(int[] nums) {
        int len = nums.length;
        int n = len / 2;
        p = new int[n];
        v = new boolean[len];
        back(nums, 0);
        System.out.println(set);
        System.out.println(cnt);
        return res;
    }

    private void back(int[] nums, int i) {
        if (i == nums.length / 2) {
            cnt++;
            Arrays.sort(p);
            int cur = 0;
            for (int k = 1; k <= p.length; k++) {
                cur += k * p[k-1];
            }
            System.out.println(Arrays.toString(p));
            res = Math.max(res, cur);
            return;
        }
        for (int m = 0; m < nums.length; m++) {
            if (v[m]) {
                continue;
            }
            v[m] = true;
            for (int n = m + 1; n < nums.length; n++) {
                if (v[n]) {
                    continue;
                }
                v[n] = true;
                p[i] = gcd(nums[m], nums[n]);
                back(nums, i + 1);
                v[n] = false;
            }
            v[m] = false;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
