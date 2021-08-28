package contest;

import java.util.HashMap;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/25
 */
public class Ct210425 {
    public int sumBase(int n, int k) {
        int res = 0;
        while (n > 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }

    public int longestBeautifulSubstring(String word) {
        int max = 0;
        int cnt = 0;
        int pre = -1;
        int record = -1;
        HashMap<Character, Integer> map = new HashMap<>(5);
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        for (char a : word.toCharArray()) {
            int cur = map.get(a);
            if (cur == 0 && cnt == 0) {
                cnt++;
                pre = cnt;
            } else {
                if (cur == pre || cur == pre + 1) {
                    cnt++;
                    pre = cur;
                    record = Math.max(record, cur);
                } else {
                    max = Math.max(max, cnt);
                    cnt = 0;
                    pre = -1;
                }
            }
        }
        max = Math.max(max, cnt);
        return record == 4 ? max : 0;
    }
}
