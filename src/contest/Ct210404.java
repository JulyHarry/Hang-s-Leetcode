package contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/3
 */
public class Ct210404 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            if (!map.containsKey(id)) {
                map.put(id, new HashSet<>());
            }
            map.get(id).add(time);
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            int time = entry.getValue().size();
            if(time != 0) {
                res[time - 1]++;
            }
        }
        return res;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 10e9 + 7;
        int sum = 0;
        int max_index = 0;
        int max = 0;
        int[] abs = new int[nums1.length];
        for (int i = 0; i < abs.length; i++) {
            abs[i] = Math.abs(nums1[i] - nums2[i]);
            max_index = abs[i] > abs[max_index] ? i : max_index;
            max = Math.max(abs[i], max);
            sum = (sum + abs[i]) % mod;
        }
        if (sum == 0) {
            return sum;
        }
        int l = 0;
        int r = nums1.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums1[m] < nums2[max_index]) {
                l = m + 1;
            } else if (nums1[m] > nums2[max_index]) {
                r = m - 1;
            } else {
                l = m;
                break;
            }
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        if (l >= 1) {
            a = Math.abs((nums1[l - 1] - nums2[max_index]) % mod);
        }
        b = Math.abs((nums1[l] - nums2[max_index]) % mod);
        if (l < nums1.length - 1) {
            c = Math.abs((nums1[l + 1] - nums2[max_index]) % mod);
        }
        int min_abs = Math.min(Math.min(a, b), c);
        return (sum - max + min_abs) % mod;
    }
}
