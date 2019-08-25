/***
 * 首先找到规律，从后向前遍历
 * 不用Stack等结构，直接从数组入手即可，index-1前的数组不用操作
 * 之后使用交换和反排即可
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums){
        int l = nums.length;
        if (l < 2) return;
        int index = l - 1;
        while (index > 0){
            if (nums[index-1] < nums[index]) break;
            index--;
        }
        if (index == 0){
            reverse(nums, 0, l - 1);
        }else {
            int val = nums[index-1];
            int j = l - 1;
            while (j >= index){
                if (nums[j] > val) break;
                j--;
            }
            swap(nums,j,index-1);
            reverse(nums, index, l-1);
            for (int s : nums){
                System.out.println(s);
            }
            return;
        }
    }

    private static void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void reverse(int[] nums, int start, int end){
        for (; start < end; start++,end--){
            swap(nums, start, end);
        }
    }
}
