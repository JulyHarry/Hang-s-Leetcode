public class ClimbingStairs {
    public static int climbStairsA1(int n) {
        /**
         * Citation: https://leetcode.com/problems/climbing-stairs/solution/
         * Approach #1: Brute Force [Time Limit Exceeded]
         * Core: climbStairs(i, n) = (i + 1, n) + climbStairs(i + 2, n)
         * Time complexity: O(2^n). Size of recursion tree will be 2^n.
         * Space complexity : O(n). The depth of the recursion tree can go up to n.
         * */
        return climb_StairsA1(0, n);
    }

    public static int climb_StairsA1(int i, int n){
        if (i > n) return 0;
        if (i == n) return 1;
        return climb_StairsA1(i + 1, n) + climb_StairsA1(i + 2, n);
    }

    public static int climbStairsA2(int n){
        /**
         * Approach #2: Recursion with memorization [Accepted]
         * We store the result at each step in memo array and directly returning the result from the array.
         * Time complexity: O(n). Size of recursion tree can go up to n.
         * Space complexity : O(n). The depth of the recursion tree can go up to n.
         * */
        int[] memo = new int[n + 1];
        return climb_StairsA2(0, n, memo);
    }

    public static int climb_StairsA2(int i, int n, int[] memo){
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_StairsA2(i + 1, n, memo) + climb_StairsA2(i + 2, n, memo);
        return memo[i];
    }

    public static int climbStairsA3(int n){
        /**
         * Approach #3: Dynamic Programming [Accepted]
         * DP thoughts: the problem can be broken into subproblems, and it contains the optimal substructure property.
         * One can reach the ith step in one of the two ways:
         * 1. take a single step from (i-1)th step.
         * 2. take a step of two from (i-2)th step.
         * So, the total number of ways to reach ith step is equal to sum of ways of reaching (i-1)th step and ways of
         * reaching (i-2)th step.
         * dp[i] = dp[i-1] + dp[i-2] when dp denotes the number of ways to reach on ith step.
         * Time complexity: O(n). Single loop up to n.
         * Space complexity : O(n). dp array of size n is used.
         * */
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int climbStairsA4(int n){
        /**
         * Approach #4: Fibonacci Number [Accepted]
         * From the approach #3 we can know dp[i] is nothing but ith fibonacci number.
         * Time complexity: O(n). Single loop up to n is required to calculate nth fibonacci number.
         * Space complexity : O(1). Constant space is used.
         * */
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static int climbStairsA5(int n){
        /**
         * Approach #5: Binets Method [Accepted]
         * climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
         * Time complexity: O(log(n)).
         * Space complexity : O(1).
         * */
        return 0;
    }

    public static int climbStairsA6(int n){
        /**
         * Approach #6: Fibonacci Formula [Accepted]
         * Details refer from the citation.
         * Time complexity: O(log(n)). pow method takes log(n) time.
         * Space complexity : O(1). Constant space is used.
         * */
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}
