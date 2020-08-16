public class JumpGame {
    /*
    1. canJump Leetcode-55:https://leetcode-cn.com/problems/jump-game/
    2. minJumpTime Leetcode-45:https://leetcode-cn.com/problems/jump-game-ii/
     */

    public static int minJumpTimeProject(int[] nums) {
        if (canJump1(nums)) {
            return minJumpTime(nums);
        } else {
            System.out.println("The JumpGame FAILS.");
            return -1;
        }
    }

    public static int minJumpTime(int[] nums) {
        if (nums.length == 1) return 0;
        int jump = 0, far = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, nums[i] + i);
            if (i == end) {
                jump++;
                end = far;
            }
        }
        return jump;
    }

    public static boolean canJump1(int[] nums) {
        int leftMostGoodPosition = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMostGoodPosition) {
                leftMostGoodPosition = i;
            }
        }
        return leftMostGoodPosition == 0;
    }

    public static boolean canJump2(int[] nums) {
        // do by myself
        if (nums[0] == 0) {
            if (nums.length == 1) return true;
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (i - j < nums[j]) {
                        break;
                    }
                    if (j == 0) return false;
                }
            }
        }
        return true;
    }

    public static boolean canJump3(int[] nums) {
        // do by myself
        int len = nums.length;
        if (len == 0) return true;
        int max = nums[0];
        if (max == 0) {
            if (len == 1) return true;
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = 1; j <= i; j++) {
                    if (nums[i - j] + i - j > i) {
                        break;
                    }
                    if (j == i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int minJump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int far = nums[i] + i;
            if (far >= nums.length-1) return dp[i]+1;
            for (int j = i + 1; j <= far; j++) {
                if (dp[j]!=0) continue;
                dp[j] = dp[i]+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 1, 2};
//        System.out.println(canJump1(nums));
//        System.out.println(canJump2(nums));
//        System.out.println(canJump3(nums));
//        System.out.println(minJumpTimeProject(nums));
        System.out.println(minJump(nums));
    }
}
