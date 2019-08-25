public class LongestPalindrome {
    private static int lo, maxLen; // default is 0

    public static String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        for (int i = 0; i < len - 1; i++){
            extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible.
            extendPalindrome(s, i, i + 1); // assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k){
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static String longestPalindromeM2(String s){
        if(s==null || s.length() <= 2) return s;
        // 没看呢
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] w = s.toCharArray();
        int maxLen = 0;
        String maxSub = null;

        dp[s.length()-1][s.length()-1] = true;
        for(int i = s.length()-2;i>=0;--i){ //试每一个起点
            int maxJ = i;
            for (int j = i+1; j < s.length(); j++) { //每一个终点
                if(w[j] == w[i] && (j<i+3 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    maxJ = j;
                }else{
                    dp[i][j] = false; //不是立即返回.
                }
            }

            if(maxJ - i+1 > maxLen){
                maxLen = maxJ - i+1;
                maxSub = s.substring(i,maxJ+1);
            }
        }
        return maxSub;
    }
}
