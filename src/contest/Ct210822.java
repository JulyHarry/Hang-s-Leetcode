package contest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/8/21
 */
public class Ct210822 {
    public int findGCD(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        return gcd(max, min);
    }

    private int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        for (String num : nums) {
            int a = Integer.valueOf(num, 2);
            System.out.println("a = " + a);
        }
//        for (int i = 0; i < (2 << len); i++) {
//            String a = Integer.toBinaryString(i);
//            int add = len - a.length();
//            if (add < 0) {
//                StringBuilder sb = new StringBuilder();
//                for (int j = add; j > 0; j--) {
//                    sb.append("0");
//                }
//                sb.append(a);
//                a = sb.toString();
//            }
//            if ()
//        }
        return "0";
    }
}
