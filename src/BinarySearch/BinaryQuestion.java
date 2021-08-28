package BinarySearch;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/9
 */
public class BinaryQuestion {
    /**
     * 29. 两数相除
     * https://leetcode-cn.com/problems/divide-two-integers/
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int l = 0;
        int r = a;
        while (l < r) {
            int m = l + (r - l) / 2;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += b;
            }
            if (sum > a) {
                r = m;
            } else if (sum < a) {
                l = m + 1;
            } else {
                return m;
            }
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return l - 1;
        } else {
            return -l + 1;
        }
    }
}
