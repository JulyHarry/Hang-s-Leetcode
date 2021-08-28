import java.util.*;

public class Number {

    /*
    https://leetcode.com/problems/single-number/
     */
    public static int SingleNumber1(int[] nums) {
        // Bit Manipulation
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

    public static int SingleNumber2(int[] nums) {
        // HashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) == null || map.get(num) == 0) {
                map.put(num, 1);
            } else {
                map.remove(num);
            }
        }
        return map.keySet().iterator().next();
    }

    public static int SingleNumber3(int[] nums) {
        // List
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                list.remove((Integer) num);  // *List remove*
            } else {
                list.add(num);
            }
        }
        return list.iterator().next();
    }

    public static boolean HappyNumber(int n) {
        if (n == 1) {
            return true;
        } else {
            if (n > Integer.MAX_VALUE) return false;
            int sum = 0;
            while (n / 10 > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            sum += n * n;
            return HappyNumber(sum);
        }
    }

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     * https://leetcode-cn.com/problems/count-primes/
     * O(nloglogn)
     * @param n
     * @return
     */
    public int countPrimesFilter(int n) {
        int cnt = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        arr[j] = 0;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     * https://leetcode-cn.com/problems/count-primes/
     * O(n√n)
     * Time limit exceeded
     * @param n
     * @return
     */
    public int countPrimesLoopOpt(int n) {
        int cnt = 0;
        for (int i = 2; i < n; ++i) {
            boolean flag = true;
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     * https://leetcode-cn.com/problems/count-primes/
     * O(n^2)
     * Time limit exceeded
     * @param n
     * @return
     */
    public int countPrimesLoop(int n) {
        if (n < 2) return 0;
        int cnt = 1;
        for (int i = 3; i < n; i++) {
            if ((i & 1) == 0) continue;
            boolean flag = true;
            for (int j = 3; j / 2 < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }

}
