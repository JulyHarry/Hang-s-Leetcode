public class JumpGame {
    public static boolean canJumpA1(int[] nums) {
        int leftMostGoodPosition = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMostGoodPosition) {
                leftMostGoodPosition = i;
            }
        }

        return leftMostGoodPosition == 0;
    }

    public static boolean canJumpA2(int[] nums) {
        // do by myself
        if (nums[0] == 0) return false;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] != 0) {
                continue;
            } else {
                for (int j = i-1; j >= 0; j--) {
                    if (i - j < nums[j]) {
                        break;
                    }
                    if (j == 0) return false;
                }
            }
        }
        return true;
    }
}
