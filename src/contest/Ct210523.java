package contest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/23
 */
public class Ct210523 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int r = Arrays.stream(dist).max().getAsInt();
        int l = 0;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (m == 0) {
                return -1;
            }
            if (!judge(dist, m, hour)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return r - 1;
    }

    private boolean judge(int[] dist, double speed, double hour) {
        double res = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                res += dist[i] / speed;
            } else {
                res += Math.ceil((double) dist[i] / speed);
            }
        }
        System.out.println(res);
        return res <= hour;
    }
}
