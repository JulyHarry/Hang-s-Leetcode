package contest;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/16
 */
public class Ct210516 {
    List<Integer> choose;
    int res = 0;
    boolean[] visited;

    public int subsetXORSum(int[] nums) {
        choose = new LinkedList<>();
        visited = new boolean[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            backtrack(nums, 0, i);
        }
        System.out.println(res);
        return res;
    }

    private void backtrack(int[] nums, int start, int len){
        if (choose.size() == len) {
            int tmp = 0;
            for (int m = 0; m < choose.size(); m++) {
                tmp ^= choose.get(m);
            }
            System.out.println(choose);
            System.out.println(tmp);
            res += tmp;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                choose.add(nums[i]);
                visited[i] = true;
                backtrack(nums, i + 1, len);
                choose.remove(choose.size() - 1);
                visited[i] = false;
            }
        }
    }
}
