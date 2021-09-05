package contest;

import java.util.*;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/9/4
 */
public class Ct210904 {
    public static void main(String[] args) {
        Ct210904 c = new Ct210904();
        int[] nums = {2, 5};
        int middleIndex = c.findMiddleIndex(nums);
        System.out.println("middleIndex = " + middleIndex);
        int[][] land = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        int[][] f = c.findFarmland(land);
//        int[] p = {-1, 5, 5, 5, 0, 4, 2, 9, 0, 4};
//        LockingTree l = new Ct210904().new LockingTree(p);
//        l.lock(5, 12);
//        l.unlock(5, 12);
//        l.upgrade(3, 7);
//        l.upgrade(7, 27);
//        l.upgrade(9, 42);
//        l.unlock(6, 37);
//        l.lock(8, 24);
//        l.upgrade(8, 27);
//        l.lock(8, 13);
//        l.unlock(8, 24);
//        l.upgrade(2, 22);
//        l.lock(5, 38);
    }

    public int findMiddleIndex(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < sum.length; i++) {
            if (i + 1 <= nums.length && sum[i] == sum[nums.length] - sum[i + 1]) {
                return i;
            }
        }
        if (sum[nums.length] - sum[1] == 0) {
            return 0;
        }
        if (sum[nums.length - 1] == 0) {
            return nums.length - 1;
        }
        return -1;
    }

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = land[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + land[i][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + land[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + land[i][j] - sum[i - 1][j - 1];
            }
        }
        for (int[] s : sum) {
            System.out.println(Arrays.toString(s));
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = m - 1; p >= i; p--) {
                    for (int q = n - 1; q >= j; q--) {
                        if (sum[p][q] - sum[i][j] == (p - i + 1) * (q - j + 1)) {

                        }
                    }
                }
            }
        }
        return sum;
    }

    class LockingTree {
        int len;
        int[] parent;
        int[] record;
        HashMap<Integer, List<Integer>> map;

        public LockingTree(int[] parent) {
            len = parent.length;
            this.parent = parent;
            record = new int[len];
            Arrays.fill(record, -1);
            map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                if (!map.containsKey(parent[i])) {
                    map.put(parent[i], new ArrayList<>());
                }
                map.get(parent[i]).add(i);
            }
        }

        public boolean lock(int num, int user) {
            if (record[num] == -1) {
                record[num] = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if (record[num] == user) {
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            if (record[num] != -1) {
                return false;
            }
            int cur = num;
            while (cur != -1) {
                if (record[cur] != -1) {
                    return false;
                }
                cur = parent[cur];
            }
            boolean flag = false;
            cur = num;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.offerLast(num);
            while (!deque.isEmpty()) {
                int t = deque.pollFirst();
                if (record[t] != -1) {
                    flag = true;
                    record[num] = user;
                    break;
                }
                if (map.containsKey(t)) {
                    for (int c : map.get(t)) {
                        deque.offerLast(c);
                    }
                }
            }
            return flag;
        }
    }
}

//["LockingTree","lock","unlock","upgrade","upgrade","upgrade","unlock","lock","upgrade","lock","unlock","upgrade","lock","lock","upgrade","upgrade","lock","upgrade","upgrade","lock","upgrade"]
//[[[-1,5,5,5,0,4,2,9,0,4]],[5,12],[5,12],[3,7],[7,27],[9,42],[6,37],[8,24],[8,27],[8,13],[8,24],[2,22],[5,38],[5,14],[9,36],[8,16],[5,13],[7,32],[8,28],[5,41],[1,14]]