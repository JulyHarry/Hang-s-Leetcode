public class MaxSubArray {
    public static int maxSubArray_DP1(int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            res = dp[i] > res ? dp[i] : res;
        }
        return res;
    }

    public static int maxSubArray_DP2(int[] nums) {
        if (nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i] > nums[i] ? dp[i - 1] + nums[i] : nums[i];
        }
        for (int i = 0; i < dp.length; i++) {
            res = dp[i] > res ? dp[i] : res;
        }
        return res;
    }

    public static int maxSubArray_DP3(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = cur + nums[i] > nums[i] ? cur + nums[i] : nums[i];
            res = cur > res ? cur : res;
        }
        return res;
    }

    public static int maxSubArray_DC(int[] nums) {
        return maxSubArrayPart(nums, 0, nums.length - 1);
    }

    private static int maxSubArrayPart(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        return Math.max(
                maxSubArrayPart(nums, left, mid),
                Math.max(
                        maxSubArrayPart(nums, mid + 1, right),
                        maxSubArrayAll(nums, left, mid, right)
                )
        );
    }

    //左右两边合起来求解
    private static int maxSubArrayAll(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, -2, 1, 3, -3, 2, -1, 3};
        System.out.println(maxSubArray_DP1(nums));
        System.out.println(maxSubArray_DP2(nums));
        System.out.println(maxSubArray_DP3(nums));
        System.out.println(maxSubArray_DC(nums));
    }
}
