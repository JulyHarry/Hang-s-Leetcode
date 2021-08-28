package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/8/21
 */
public class Ct210821 {
    public int minTimeToType(String word) {
        int res = 0;
        int cur = 'a';
        for (char c : word.toCharArray()) {
            int diff = Math.abs(c - cur);
            res += Math.min(diff, 26 - diff);
            cur = c;
        }
        return res + word.length();
    }
}
