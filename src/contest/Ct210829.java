package contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/8/29
 */
public class Ct210829 {
    public static void main(String[] args) {
        Ct210829 c = new Ct210829();
//        String[] nums = {"1", "23", "32"};
//        int k = 3;
//        String s = c.kthLargestNumber(nums, k);
//        System.out.println("s = " + s);
        int[] nums = {2, 3, 3, 4, 4, 4, 5, 6, 7, 10};
        int k = 12;
        int i = c.minSessions(nums, k);
        System.out.println("i = " + i);
    }

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue pq = new PriorityQueue<Long>(Collections.reverseOrder());
        for (String num : nums) {
            pq.add(Long.parseLong(num));
        }
        String res = "";
        while (k > 0) {
            res = pq.poll().toString();
            k--;
        }
        return res;
    }

    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        boolean[] visited = new boolean[tasks.length];
        int j = tasks.length - 1;
        int all = 0;
        int res = 0;
        while (j >= 0) {
            int cur = sessionTime;
            while (j >= 0 && tasks[j] <= cur) {
                if (!visited[j]) {
                    cur -= tasks[j];
                    visited[j] = true;
                    all++;
                }
                j--;
            }
            int i = j - 1;
            while (cur >= tasks[0] && i >= 0) {
                if (!visited[i] && tasks[i] <= cur) {
                    cur -= tasks[i];
                    visited[i] = true;
                    all++;
                }
                i--;
            }
            res++;
            if (all == tasks.length) {
                return res;
            }
        }
        return res;
    }

    public int minSessions2(int[] tasks, int sessionTime) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        Arrays.sort(tasks);
        for (int i = tasks.length - 1; i >= 0; i--) {
            map.remove(tasks[i]);
            int cur = sessionTime;
            while (cur > 0) {
                map.ceilingKey(cur - tasks[i]);
            }
        }
        return 0;
    }
}
