import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int abs = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int tempres = nums[i] + nums[j] + nums[k];
                int tempabs = Math.abs(target - tempres);
                if (tempres > target) {
                    k--;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }else {
                    j++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                }
                if (abs > tempabs){
                    abs = tempabs;
                    res = tempres;
                }
            }
        }
        return res;
    }
}
