//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class BestTimetoBuyandSellStock {
//
//    public static int maxProfit(int[] prices) {
//        int sofar = 0;
//        int cur = 0;
//        for (int i = 0; i < prices.length-1; i++){
//            cur = Math.max(0, cur += prices[i+1] - prices[i]);
//            sofar = Math.max(sofar, cur);
//        }
//        return sofar;
//    }
//
//    public static int maxProfitIII(int[] prices) {
//        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            buy1 = Math.max(buy1, -prices[i]);
//            sell1 = Math.max(sell1, buy1 + prices[i]);
//            buy2 = Math.max(buy2, sell1 - prices[i]);
//            sell2 = Math.max(sell2, buy2 + prices[i]);
//        }
//        return sell2;
//    }
//
//    public static int maxProfitIV(int k, int[] prices) {
//        int len = prices.length;
//        if (k >= len / 2) return quickSolve(prices);
//
//        int[][] t = new int[k + 1][len];
//        for (int i = 1; i <= k; i++) {
//            int tmpMax =  -prices[0];
//            for (int j = 1; j < len; j++) {
//                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
//                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
//            }
//        }
//        return t[k][len - 1];
//    }
//
//    private static int quickSolve(int[] prices) {
//        int len = prices.length, profit = 0;
//        for (int i = 1; i < len; i++)
//            // as long as there is a price gap, we gain a profit.
//            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
//        return profit;
//    }
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()){
//            int a = in.nextInt();
//            int[] nums = new int[a];
//            for (int i=0; i<a; i++){
//                nums[i] = in.nextInt();
//            }
//            System.out.println(maxProfitIII(nums));
//        }
//
////        System.out.println(list);
////        int[] s = new int[list.size()];
////        for(int i=0; i<list.size(); i++){
////            s[i] = list.get(i);
////        }
////        System.out.println(s);
//    }
//}
