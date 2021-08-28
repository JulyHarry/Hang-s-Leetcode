package DynamicProgramming;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/10
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }
        return dp[n][0];
    }

    public int maxProfitIII(int[] prices) {
        int dp_20 = 0;
        int dp_21 = -prices[0];
        int dp_10 = 0;
        int dp_11 = -prices[0];
        for (int price : prices) {
            dp_20 = Math.max(dp_20, dp_21 + price);
            dp_21 = Math.max(dp_21, dp_10 - price);
            dp_10 = Math.max(dp_10, dp_11 + price);
            dp_11 = Math.max(dp_11, -price);
        }
        return dp_20;
    }
}
