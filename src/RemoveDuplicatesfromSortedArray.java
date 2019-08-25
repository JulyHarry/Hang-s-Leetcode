/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int j=0;
        for (int i=0; i<nums.length; i++)
            if (nums[i]!=nums[j]) nums[++j]=nums[i];
        //for(int k : nums) System.out.println(k);
        return ++j;
    }
    public static int removeDuplicatesFailure(int[] nums) {
        // 没有调整数据的结构顺序
        int cnt = nums.length;
        if (nums == null){
            return 0;
        }
        for (int i = 0; i<nums.length-1; i++){
            if( nums[i] == nums[i+1] ){
                cnt -= 1;
            }
        }
        //for(int k : nums) System.out.println(k);
        return cnt;
    }
}
