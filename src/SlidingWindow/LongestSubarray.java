package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * @author HarryUp
 */
public class LongestSubarray {

    /**
     * 1438. 绝对差不超过限制的最长连续子数组
     * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
        int maxLen = 0;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            minDeque.offerLast(nums[right]);
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int longestSubarray2(int[] nums, int limit) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);
            while (max - min > limit) {
                left++;
                int[] res = findM(nums, left, right);
                max = res[0];
                min = res[1];
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    private int[] findM(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (; i <= j; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return new int[]{max, min};
    }
}