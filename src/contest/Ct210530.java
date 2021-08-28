package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/30
 */
public class Ct210530 {
    /**
     * https://leetcode-cn.com/contest/weekly-contest-243/problems/maximum-value-after-insertion/
     *
     * @param n
     * @param x
     * @return
     */
    public String maxValue(String n, int x) {
        StringBuilder res = new StringBuilder(n);
        boolean neg = n.charAt(0) != '-';
        if (neg) {
            for (int i = 0; i < res.length(); i++) {
                if (i == res.length() - 1) {
                    res.insert(i, x);
                    break;
                }
                if (x > n.charAt(i) - '0') {
                    res.insert(i, x);
                    break;
                }
            }
        } else {
            for (int i = 1; i < res.length(); i++) {
                if (i == res.length() - 1) {
                    res.insert(i, x);
                    break;
                }
                if (x <= n.charAt(i) - '0') {
                    res.insert(i, x);
                    break;
                }
            }
        }
        return res.toString();
    }


    public boolean findRotation(int[][] mat, int[][] target) {
        return r1(mat, target) || r2(mat, target) || r3(mat, target) || r4(mat, target);
    }

    public boolean r1(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[j][n - i - 1] != mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean r2(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[n - j - 1][n - i - 1] != mat[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean r3(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[j][n - i - 1] != mat[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean r4(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] != mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
