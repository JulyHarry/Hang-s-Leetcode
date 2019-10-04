public class JumpGame {
    public static boolean canJump1(int[] nums) {
        int leftMostGoodPosition = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMostGoodPosition) {
                leftMostGoodPosition = i;
            }
        }
        return leftMostGoodPosition == 0;
    }

    public static boolean canJump4(int[] nums) {
        int rightest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (rightest < i + nums[i]) {
                rightest = i;
            }
        }
        return rightest >= nums.length-1 ;
    }

    public static boolean canJump2(int[] nums) {
        // do by myself
        if (nums[0] == 0) {
            if (nums.length==1) return true;
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

    public static void main(String[] args) {
        int[] nums = {2,0,0,2};
        System.out.println(canJump1(nums));
        System.out.println(canJump2(nums));
        System.out.println(canJump3(nums));
        System.out.println(canJump4(nums));
    }
}