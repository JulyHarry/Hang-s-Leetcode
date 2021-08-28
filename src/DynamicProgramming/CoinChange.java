package DynamicProgramming;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/11
 */
public class CoinChange {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        return dp(coins, amount) == 1073741824 ? -1 : dp(coins, amount);
    }

    private int dp(int[] coins, int i) {
        if (i < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE / 2;
        for (int coin : coins) {
            min = Math.min(min, dp(coins, i - coin));
            dp[i] = min + 1;
        }
        return dp[i];
    }
}
