package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author HarryUp
 * @date 2021/3/7
 */
public class PalindromePartitioning {
    ArrayList<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int i) {
        if (s.length() == i) {
            res.add(new ArrayList<>(ans));
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                ans.add(s.substring(i, j + 1));
                backtrack(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<String>> partition2(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        backtrack(s, 0);
        return res;
    }

    public boolean checkOnesSegment3(String s) {
        int block = 0;
        int start = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                start = 1;
            } else {
                block += start;
                start = 0;
            }
        }
        block += start;
        return block <= 1;
    }


    public int minElements(int[] nums, int limit, int goal) {
        long sum = Arrays.stream(nums).mapToLong(Long::valueOf).sum();
//        long sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
        long delta = Math.abs(sum - goal);
        long ans = (delta + limit - 1) / limit;
        return (int)ans;
    }
}
