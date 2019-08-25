/**
 * @author hang
 * finished by myself
 * although it is complex
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target){
        int len = nums.length;
        int cnt = 0;
        if (target > nums[len-1]) return len;
        for(int i = 0; i < len; i++){
            if(target == nums[i]){
                return i;
            }else if(target < nums[i]){
                cnt = i;
                return cnt;
            }
        }
        return cnt;
    }

    public static int searchInsertClassic1(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            }else if (target < nums[mid]){
                end = mid - 1;
            }else return mid;
        }
        return start;
    }
}
