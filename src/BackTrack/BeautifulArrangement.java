package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 526. 优美的排列
 * https://leetcode-cn.com/problems/beautiful-arrangement/
 *
 * @author HarryUp
 * @date 2021/8/16
 */
public class BeautifulArrangement {
    private int n;
    private boolean[] visit;
    private List<Integer>[] list;
    private int res;

    public int countArrangement(int n) {
        this.res = 0;
        this.n = n;
        visit = new boolean[n + 1];
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    list[i].add(j);
                }
            }
        }
        backtrack(1);
        return res;
    }

    private void backtrack(int index) {
        if (index == n + 1) {
            res++;
            return;
        }
        for (int i : list[index]) {
            if (!visit[i]) {
                visit[i] = true;
                backtrack(index + 1);
                visit[i] = false;
            }
        }
    }

    public int countArrangement2(int n) {
        // 新写法！！！GET
        return switch (n){
            case 1 -> 1;
            case 2 -> 2;
            default -> -1;
        };


//        switch(n){
//            case 1:
//                return 1;
//            case 2:
//                return 2;
//            case 3:
//                return 3;
//            case 4:
//                return 8;
//            case 5:
//                return 10;
//            case 6:
//                return 36;
//            case 7:
//                return 41;
//            case 8:
//                return 132;
//            case 9:
//                return 250;
//            case 10:
//                return 700;
//            case 11:
//                return 750;
//            case 12:
//                return 4010;
//            case 13:
//                return 4237;
//            case 14:
//                return 10680;
//            case 15:
//                return 24679;
//            default:
//                return 0;
//        }
    }
}
