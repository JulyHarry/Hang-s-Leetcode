package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/17
 */
public class Ct210418 {
    public int maxIceCream(int[] costs, int coins) {
        int[] dp = new int[coins + 1];
        for (int i = 0; i <= coins; i++) {
            for (int j = 0; j < costs.length; j++) {
                if (i - costs[j] < 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i - costs[j]] + 1, dp[i]);
            }
        }
        return dp[coins];
    }

    public int getXORSum(int[] arr1, int[] arr2) {
        int res = 0;
        int a = 0;
        for (int m : arr1) {
            for (int n : arr2) {
                a = m & n;
                res ^= a;
            }
        }
        return res;
    }
}
