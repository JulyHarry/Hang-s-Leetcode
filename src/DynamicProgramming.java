import java.util.Arrays;

public class DynamicProgramming {
    public int CoinChange_Recursion(int[] coins, int amount) {
        if (amount < 1) return 0;
        return CoinChange_Recursion_dp(coins, amount, new int[amount]);
    }

    private int CoinChange_Recursion_dp(int[] coins, int amount, int[] count) {
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//        for (int i = 0; i < coins.length; i++) {
//
//        }
//        return CoinChange_Recursion_dp(amount);
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = CoinChange_Recursion_dp(coins, amount - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }

    public int CoinChange_Iteration(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int a = dp.CoinChange_Iteration(coins, amount);
        int b = dp.CoinChange_Recursion(coins, amount);
        System.out.println(a);
        System.out.println(b);
    }
}
