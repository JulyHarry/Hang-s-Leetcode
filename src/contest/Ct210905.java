package contest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/9/4
 */
public class Ct210905 {
    public static void main(String[] args) {
        Ct210905 c = new Ct210905();
//        int[] nums = {28, 8, 49, 85, 37, 90, 20, 8};
//        int i = c.firstDayBeenInAllRooms(nums);
//        System.out.println(i);
//        int[][] num = {{5, 5}, {6, 3}, {3, 6}};
        int[][] num = {{1, 5}, {10, 4}, {4, 3}};
        int i = c.numberOfWeakCharacters(num);
        System.out.println(i);
    }

    public int countQuadruplets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
//        for (int[] p : properties) {
//            System.out.println(Arrays.toString(p));
//        }
        int res = 0;
        for (int i = 0; i < properties.length; i++) {
//            for (int j = i + 1; j < properties.length; j++) {
//                if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]) {
//                    res++;
//                    break;
//                }
//            }
            int target = properties[i][1];
            int l = i + 1;
            int r = properties.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (properties[m][0] == properties[i][0] || properties[m][1] <= target) {
                    l = m + 1;
                } else {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        final int mod = 1000000007;
        int n = nextVisit.length;
        boolean[] visited = new boolean[n];
        int[] record = new int[n];
        int cnt = n;
        int cur = 0;
        int ans = 0;
        while (cnt > 0) {
            if (record[cur] == 0) {
                cnt--;
            }
            record[cur]++;
            if ((record[cur] & 1) == 1) {
                cur = nextVisit[cur];
            } else {
                cur = (cur + 1) % n;
            }
            if (cnt != 0) {
                ans++;
            }
            ans %= mod;
        }
        return ans;
    }
}
