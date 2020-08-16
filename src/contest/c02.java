package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class c02 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int res = 0;
        int[] ans = new int[n * (n + 1)/2];
        Arrays.sort(nums);
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                ans[ptr] = i == j ? nums[j] : nums[j] + ans[ptr - 1];
                ++ptr;
            }
        }
        for (int i = left + 1; i <= right + 1; i++) {
            res += ans[i];
        }
        return res % 1000000007;
    }

    public static void main(String[] args) {
        c02 a = new c02();
        a.rangeSum(new int[]{9,1,1,7,1}, 5, 5,5);
    }
}
