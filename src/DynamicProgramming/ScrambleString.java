package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/16
 */
public class ScrambleString {
    int[][][] memo;
    String s1, s2;

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        memo = new int[len][len][len + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, len);
    }

    private boolean dfs(int i, int j, int len) {
        if (memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            memo[i][j][len] = 1;
            return true;
        }
        if (!checkIfSimilar(i, j, len)) {
            memo[i][j][len] = -1;
            return false;
        }
        for (int k = 0; k < len; k++) {
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                memo[i][j][k] = 1;
                return true;
            }
            if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                memo[i][j][k] = 1;
                return true;
            }
        }
        memo[i][j][len] = -1;
        return false;
    }

    private boolean checkIfSimilar(int i, int j, int len) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s1.substring(i, i + len).toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.substring(j, j + len).toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (int n : freq.values()) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
