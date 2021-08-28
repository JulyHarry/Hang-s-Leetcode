package contest;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/5
 */
public class Ct210405 {
    public int purchasePlans(int[] nums, int target) {
        int mod = (int) 1e9 + 7;
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] sum = new int[map.size()];
        HashMap<Integer, Integer> index = new HashMap<>(map.size());
        int idx = 0;
        for (int key : map.keySet()) {
            index.put(key, idx);
            sum[idx] = map.get(key) + (idx > 0 ? sum[idx - 1] : 0);
            idx++;
        }
        long res = 0;
        for (int key : map.keySet()) {
            if (map.floorKey(target - key) != null) {
                int floor = map.floorKey(target - key);
                long a = map.get(key);
                int floor_index = index.get(floor);
                long b = sum[floor_index] - (key <= floor ? a : 0);
                res += a * (a - 1) % mod;
                res += a * b % mod;
            }
        }
        return (int) res / 2;
    }
}
