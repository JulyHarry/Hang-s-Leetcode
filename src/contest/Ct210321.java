package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/3/20
 */
public class Ct210321 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                res += nums[i];
            } else {
                max = Math.max(max, res);
                res = nums[i];
            }
        }
        max = Math.max(max, res);
        return max;
    }

    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int low_bound = nums[i] ^ high;
            int high_bound = nums[i] ^ low;
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= high_bound || nums[j] >= low_bound) {
                    res++;
                }
            }
        }
        return res;
    }
}
