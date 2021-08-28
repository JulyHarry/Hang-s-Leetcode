package Greedy;

import java.util.*;

/**
 * Description:
 *
 * @author HarryUp
 */
public class Interval {
    /**
     * 1272. 删除区间
     * https://leetcode-cn.com/problems/remove-interval/
     *
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int down = toBeRemoved[0];
        int up = toBeRemoved[1];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (left < down) {
                if (right <= down) {
                    res.add(Arrays.asList(left, right));
                } else if (right <= up) {
                    res.add(Arrays.asList(left, down));
                } else {
                    res.add(Arrays.asList(left, down));
                    res.add(Arrays.asList(up, right));
                }
            } else if (left < up && right > up) {
                res.add(Arrays.asList(up, right));
            } else if (right > up) {
                res.add(Arrays.asList(left, right));
            }
        }
        return res;
    }

    /**
     * 1272. 删除区间
     * https://leetcode-cn.com/problems/remove-interval/
     *
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public List<List<Integer>> removeIntervalII(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int down = toBeRemoved[0];
        int up = toBeRemoved[1];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (right <= down || left >= up) {
                res.add(Arrays.asList(left, right));
            } else if (left < down && right > up) {
                res.add(Arrays.asList(left, down));
                res.add(Arrays.asList(up, right));
            } else if (left < down && right > down) {
                res.add(Arrays.asList(left, down));
            } else if (left < up && right > up) {
                res.add(Arrays.asList(up, right));
            }
        }
        return res;
    }

    /**
     * 1272. 删除区间
     * https://leetcode-cn.com/problems/remove-interval/
     *
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public List<List<Integer>> removeIntervalIII(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int down = toBeRemoved[0];
        int up = toBeRemoved[1];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (right <= down || left >= up) {
                res.add(Arrays.asList(left, right));
                continue;
            }
            if (right < up && left >= down) {
                continue;
            }
            if (left < down) {
                res.add(Arrays.asList(left, down));
            }
            if (right > up) {
                res.add(Arrays.asList(up, right));
            }
        }
        return res;
    }

    /**
     * 228. 汇总区间
     * https://leetcode-cn.com/problems/summary-ranges/
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i == 0 || nums[i] - 1 == nums[i - 1]) {
                cnt++;
            } else {
                if (cnt != 1) {
                    res.add(String.format("%d->%d", nums[i - cnt], nums[i - 1]));
                } else {
                    res.add(Integer.toString(nums[i - 1]));
                }
                cnt = 1;
            }
        }
        int i = nums.length;
        if (cnt != 1) {
            res.add(String.format("%d->%d", nums[i - cnt], nums[i - 1]));
        } else {
            res.add(Integer.toString(nums[i - 1]));
        }
        return res;
    }

    /**
     * 435. 无重叠区间
     * https://leetcode-cn.com/problems/non-overlapping-intervals/
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int end = Integer.MIN_VALUE;
        int cnt = 0;
//        for (int[] interval : intervals) {
//            int
//        }
        return 0;
    }

    /**
     * 1288. 删除被覆盖区间
     * https://leetcode-cn.com/problems/remove-covered-intervals/
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        return 0;
    }

    /**
     * 327. 区间和的个数
     * https://leetcode-cn.com/problems/count-of-range-sum/
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        return 0;
    }
}
