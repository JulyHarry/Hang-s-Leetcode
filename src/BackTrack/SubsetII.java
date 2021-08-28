package BackTrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/3/31
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<Integer>());
        for (int i = 0; i < len; i++) {
            backtrack(nums, 0, i, res, new HashSet<Integer>());
        }
        return res;
    }

    private void backtrack(int[] nums, int cur, int l, List<List<Integer>> res, Set<Integer> set) {
        if (cur == l) {
            res.add(new LinkedList<>(set));
        }
        for (int i = 0; i < nums.length; i++) {

        }
    }
}
