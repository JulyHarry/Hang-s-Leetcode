import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    private int len = 0;
    public List<List<Integer>> fourSumA1(int[] nums, int target){
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int index, int k){
        ArrayList<List<Integer>> l = new ArrayList<List<Integer>>();
        if (index > len) {
            return l;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j){
                if (target == nums[i] + nums[j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    l.add(temp);
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i-1]) i++;
                    while (i < j && nums[j] == nums[j+1]) j--;
                }else if (target > nums[i] + nums[j]){
                    i++;
                    while (i < j && nums[i] == nums[i-1]) i++;
                }else {
                    j--;
                    while (i < j && nums[j] == nums[j+1]) j--;
                }
            }
        }else {
            for (int i = index; i < len - k + 1; i++){
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], i+1, k-1);
                if (temp != null) {
                    for (List<Integer> s : temp){
                        s.add(0,nums[i]);
                        // the first argument is the index and the second is the number you want to add.
                    }
                    l.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) i++;
            }
        }
        return l;
    }

    public static List<List<Integer>> fourSumA2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = nums.length - 1; i < j; j--){
                if (j < nums.length - 1 && nums[j] == nums[j+1]) continue;
                int m = i + 1, n = j - 1;
                while (m < n){
                    if (target == nums[i] + nums[j] + nums[m] + nums[n]){
                        res.add(Arrays.asList(nums[i], nums[m], nums[n], nums[j]));
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m-1]) m++;
                        while (m < n && nums[n] == nums[n+1]) n--;
                    }else if (target < nums[i] + nums[j] + nums[m] + nums[n]){
                        n--;
                    }else m++;
                }
            }
        }
        return res;
    }
}
