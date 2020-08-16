package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c03 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer>[] list = new List[nums.length-i];
            for (int k = 0; k < nums.length-i; k++) {
                list[k] = new ArrayList<>();
            }
            for (int j = i; j < nums.length-i; j++) {
                if (i == j) {
                    list[j].add(nums[j]);
                } else {
                    list[j] = list[j-1];
                    list[j].add(nums[j]);
                }
            }
            for (List<Integer> l : list) {
                res.add(l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        c03 c = new c03();
        List<List<Integer>> mm = c.subsets(new int[]{1,2,3,4});
        System.out.println(mm);
    }
}
