package BackTrack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
排列
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> paths = new LinkedList<>();
        for (int num : nums) {
            paths.add(num);
        }
        permute_backtrack(paths, result, 0, length);
        return result;
    }

    private void permute_backtrack(LinkedList<Integer> paths, List<List<Integer>> result, int begin, int size) {
        if (begin == size) {
            result.add(new LinkedList<>(paths));
            return;
        }
        for (int i = begin; i < size; i++) {
            Collections.swap(paths, begin, i);
            permute_backtrack(paths, result, begin + 1, size);
            Collections.swap(paths, begin, i);
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int size = nums.length;
        LinkedList<Integer> paths = new LinkedList<Integer>();
        for (int num : nums) {
            paths.add(num);
        }
        permute1_backtrack(paths, new LinkedList<Integer>(), result, size);
        return result;
    }

    private void permute1_backtrack(LinkedList<Integer> path, LinkedList<Integer> chooses, List<List<Integer>> result, int size) {
        // end condition
        if (chooses.size() == size) {
            result.add(new LinkedList<>(chooses));
            return;
        }
        for (int i = 0; i < path.size(); i++) {
            int cur = path.get(i);
            // choose
            chooses.add(cur);
            path.remove(i);
            // backtrack
            permute1_backtrack(path, chooses, result, size);
            // revoke
            path.add(i, cur);
            chooses.removeLast();
        }
    }


















}
