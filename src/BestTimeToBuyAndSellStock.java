public class BestTimeToBuyAndSellStock {
    public int maxProfitWithOneTime (int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }

    public int maxProfitWithAnyTime (int[] prices) {
        return 0;
    }
}