package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/8/15
 */
public class Ct210815 {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                res++;
            }
        }
        return res;
    }

    public int[] rearrangeArray(int[] nums) {
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                    loop = true;
                    int temp = nums[i];
                    if (i + 2 < nums.length) {
                        nums[i] = nums[i + 2];
                        nums[i + 2] = temp;
                    } else {
                        nums[i] = nums[0];
                        nums[0] = temp;
                    }
                }
            }
        }
        return nums;
    }

    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        double res = 1;
        double mod = 1e9 + 7;
        for (long i = 2L, j = (long) Math.pow(2, p) - 1; i <= j; j--) {
            if (i == j) {
                res *= i;
                res %= mod;
                break;
            } else {
                long[] tmp = cal(i, j);
                if (tmp[0] == 0L) {
                    res *= j;
                } else {
                    res *= tmp[1];
                    i++;
                }
            }
            res %= mod;
        }
        return (int) res;
    }

    private long[] cal(long i, long j) {
        long min = Long.MAX_VALUE;
        String a = Long.toBinaryString(i);
        String b = Long.toBinaryString(j);
        for (int k = 0; k < b.length(); k++) {
            int abit = k >= a.length() ? 0 : a.charAt(a.length() - k - 1) - '0';
            int bbit = b.charAt(b.length() - k - 1) - '0';
            if (abit == bbit) {
                continue;
            }
            long cur = 1L << k;
            if (cur >= j) {
                break;
            }
            long sign = 1L;
            if (abit == 1) {
                sign = -1L;
            }
            long multi = (i + sign * cur) * (j - sign * cur);
            if (multi == 0L) {
                continue;
            }
            min = Math.min(multi, min);
        }
        return new long[]{i * j <= min && i != j - 1? 0L : 1L, min};
    }
}
