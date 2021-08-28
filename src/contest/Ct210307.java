package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/3/7
 */
public class Ct210307 {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        int cur = s.charAt(0) - '0';
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (cur == 1 && flag) {
                cnt++;
                flag = false;
            }
            if (i + 1 < s.length()) {
                cur = s.charAt(i + 1) - '0';
            }
            if (cur == 0) {
                flag = true;
            }
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.print(cnt);
        return cnt <= 1;
    }

    public boolean checkOnesSegment1(String s) {
        for (String a : s.split("0+")) {
            System.out.println(a);
        }
        return s.split("0+").length <= 1;
    }

    public boolean checkOnesSegment2(String s) {
        boolean f0 = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                f0 = true;
            } else if (f0) {
                return false;
            }
        }
        return true;
    }
}
