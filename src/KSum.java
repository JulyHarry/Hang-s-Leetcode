package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    private static int len = 0;
    public static List<List<Integer>> kSum(int[] nums,int target,int k){
        Arrays.sort(nums);
        len = nums.length;
        return kSumSupport(nums, target, 0, k);
    }

    public static ArrayList<List<Integer>> kSumSupport(int[] nums, int target, int index, int k){
        ArrayList<List<Integer>> l = new ArrayList<>();
        if (index > len){
            return l;
        }
        if (k == 2){
            int i = index, j = len - 1;
            while (i < j){
                if (target == nums[i] + nums[j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    l.add(temp);
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }else if (target > nums[i] + nums[j]) {
                    while (i < j && nums[i] == nums[i+1]) i++;
                    i++;
                }else {
                    while (i < j && nums[j] == nums[j-1]) j--;
                    j--;
                }
            }
        }else {
            for (int i = index; i < index - k + 1; i++){
                ArrayList<List<Integer>> temp = new ArrayList<>();
                if (temp != null) {
                    for (List<Integer> s : temp){
                        s.add(0,nums[i]);
                    }
                    l.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return l;
    }
}
