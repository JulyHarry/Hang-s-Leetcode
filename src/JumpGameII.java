public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int jump = 0, end = 0, far = 0;
        for (int i = 0; i < nums.length-1; i++) {
            far = Math.max(far, i+nums[i]);
            if (i==end) {
                jump++;
                end=far;
            }
        }
        System.out.println(jump);
        return jump;
    }











































    public static int jumpII(int[] nums) {
        int[] dp = new int[nums.length];
        int cnt = 0;
        for (int i=0; i<nums.length-1;) {
            if (nums[i]==0) return 0;
            dp[i] = i + nums[i];
            i = dp[i];
            cnt ++;
        }
        System.out.println(cnt);
        return cnt;
    }

    public static void main(String[] args) {
        int[] dp = {2,3,1,1,4};
        jump(dp);
        jumpII(dp);
    }
}
