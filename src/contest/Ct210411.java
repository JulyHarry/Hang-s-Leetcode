package contest;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/11
 */
public class Ct210411 {
    public int findTheWinner(int n, int k) {
        boolean[] visit = new boolean[n * k];
        Set<Integer> set = new HashSet<>();
        int i = 1;
        while (set.size() != n - 1) {
            int step = k;
            int end = i + step;
            while (set.contains(i + step)) {
                step++;
            }
            if(set.add(i + step - 1)) {
                int cur = (i + k) % n;
                while (set.contains(cur)) {
                    cur++;
                }
                i = cur;
            } else {
                i = (i + 1) % n;
            }
        }
        return i;
    }
}
