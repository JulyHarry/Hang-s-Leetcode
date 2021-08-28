package contest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/9
 */
public class Ct210509 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int max = 0;
        for (int i = 0; i < l1; i++) {
            int l = i;
            int r = l2 - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums2[mid] < nums1[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            max = Math.max(max, l - i - 1);
        }
        return max;
    }

    public int maxSumMinProduct(int[] nums) {
        Arrays.sort(nums);
        long sum = Arrays.stream(nums).sum();
        int pre = 0;
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                sum -= nums[i];
                pre = nums[i];
                continue;
            }
            max = Math.max(max, sum * nums[i]);
            sum -= nums[i];
            pre = nums[i];
        }
        return (int) (max % (1e9 + 7));
    }
}
