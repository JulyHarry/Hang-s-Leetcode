package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/17
 */
public class Ct210417 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int ans = 0;
            int x = query[0];
            int y = query[1];
            int r = query[2];
            for (int[] point : points) {
                int m = point[0];
                int n = point[1];
                if ((x - m) * (x - m) + (y - n) * (y - n) <= r * r) {
                    ans++;
                }
            }
            res[i++] = ans;
        }
        return res;
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur ^= nums[i];
            int max = (int) Math.pow(2, maximumBit) - 1;
            res[nums.length - i - 1] = (cur & max) ^ max;
        }
        return res;
    }
}
