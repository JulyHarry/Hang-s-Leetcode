package Calculation;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/2/1
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        int len = num1.length();
        boolean flag = false;
        for (int i = len - 1; i >= 0; i--) {
            if (flag) {
                num2 = new StringBuilder(num2).append("0").toString();
            }
            flag = true;
            String cur = time(num2, num1.charAt(i) - '0');
            res = sum(cur, res);
        }
        return res;
    }

    private String time(String num, int m) {
        if (m == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            int mul = 0;
            mul += (num.charAt(i) - '0') * m;
            mul += carry;
            carry = mul / 10;
            sb.append(mul % 10);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private String sum (String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i  = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            int add = 0;
            if (i >= 0) {
                add += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                add += num2.charAt(j) - '0';
            }
            add += carry;
            carry = add / 10;
            sb.append(add % 10);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}