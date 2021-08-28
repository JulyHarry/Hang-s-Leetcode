package SlidingWindow;

/**
 * Description:
 * 最大连续1的个数
 *
 * @author HarryUp
 * @date 2021/2/3
 */
public class MaxConsecutiveOnes {

    /**
     * 485. 最大连续1的个数
     * https://leetcode-cn.com/problems/max-consecutive-ones/
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        return max;
    }

    /**
     * 1004. 最大连续1的个数 III
     * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
     */
    public int findMaxConsecutiveOnesIII(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int h = k;
        int res = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                j++;
            } else {
                if (h > 0) {
                    j++;
                    h--;
                } else {
                    h = k;
                    res = Math.max(i - j, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,2,3});
    }
}
