import java.util.Stack;

/**
 * 2020/8/24 20:00
 *
 * @author iJuly
 * @version 1.0
 */

public class StringClass {
    /**
     * @param s String
     * @return repeatedSubstringPattern
     */
    public boolean repeatedSubstringPattern1(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                boolean isMatch = true;
                for (int j = i; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param s String
     * @return repeatedSubstringPattern
     */
    public boolean repeatedSubstringPattern2(String s) {
        return (s+s).indexOf(s, 1) != s.length();
    }


    /**
     * Given a string, you need to reverse the order of characters in each word within
     * a sentence while still preserving whitespace and initial word order.
     *
     * <p> <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a String III</a>
     *
     * @param s String
     * @return reverseWord
     */
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] c = s.toCharArray();
        char checkSpace = 'a';
        for (int i = 0; i < c.length; i++) {
            if (i > 0) checkSpace = c[i-1];
            if (c[i] != ' ') {
                stack.push(c[i]);
            } else {
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                if (i == 0 || i == c.length-1 || (checkSpace==' ' && c[i]==' ')) continue;
                res.append(" ");
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString().trim();
    }

}
