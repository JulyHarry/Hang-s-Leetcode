public class StringCalculator {

    /*
    43. multiply strings
    https://leetcode.com/problems/multiply-strings/
     */

    public static String StringMultiply(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int len1 = num1.length();
        int len2 = num2.length();
        int len = Math.min(len1, len2);
        int carry = 0; // 进位
        String sub = len == len1 ? num1 : num2; // 乘数， 位数较长的数字
        String ob = len == len1 ? num2 : num1; // 被乘数， 位数较短的数字
        for (int i = 0; i < len; i++) {
            continue;
        }
        return null;
    }
}
